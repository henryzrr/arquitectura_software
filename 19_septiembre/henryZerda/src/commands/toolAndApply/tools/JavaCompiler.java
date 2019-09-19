package commands.toolAndApply.tools;


import main.Directory;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


class JavaCompiler implements ICompiler{

    private Directory directory;
    private ProcessBuilder processBuilder;
    JavaCompiler(Directory directory) {
        this.directory = directory;
        processBuilder = new ProcessBuilder();
    }

    private void compileOne(String file) throws Exception {
        List<String>command = new LinkedList<>();
        command.add("javac");
        command.add(file);
        processBuilder.command(command);
        Process process = processBuilder.start();
        process.waitFor();
    }

    @Override
    public void compileAll( ) throws Exception {
        Iterator<String> filesIterator = directory.getEspeciFicfileType(".java");
        while (filesIterator.hasNext()) {
            compileOne(filesIterator.next());
        }
    }
}
