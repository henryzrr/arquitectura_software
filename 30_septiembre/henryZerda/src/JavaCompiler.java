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

    @Override
    public void compileAll( Directory directory) throws Exception {
        List<String>command = new LinkedList<>();
        command.add(toolInstruction);
        Iterator<String> filesIterator = directory.getEspeciFicfileType("."+fileType1);
        while (filesIterator.hasNext()) {
            command.add(filesIterator.next());
        }
        processBuilder.command(command);
        Process process = processBuilder.start();
        process.waitFor();
    }
    public String getOutputFileType(){
        return fileType2;
    }
}
