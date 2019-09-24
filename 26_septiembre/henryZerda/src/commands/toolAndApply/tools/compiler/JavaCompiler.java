package commands.toolAndApply.tools.compiler;


import main.Directory;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


class JavaCompiler implements ICompiler{

    private ProcessBuilder processBuilder;
    private String toolInstruction;
    private String fileType1;
    private String fileType2;


    JavaCompiler(String toolInstruction, String fileType1, String fileType2) {
        this.toolInstruction = toolInstruction;
        this.fileType1 = fileType1;
        this.fileType2 = fileType2;
        processBuilder = new ProcessBuilder();
    }

    private void compileOne(String file) throws Exception {
        List<String>command = new LinkedList<>();
        command.add(toolInstruction);
        command.add(file);
        processBuilder.command(command);
        Process process = processBuilder.start();
        process.waitFor();
    }

    @Override
    public void compileAll( Directory directory) throws Exception {
        Iterator<String> filesIterator = directory.getEspeciFicfileType("."+fileType1);
        while (filesIterator.hasNext()) {
            compileOne(filesIterator.next());
        }
    }
    public String getOutputFileType(){
        return fileType2;
    }
}
