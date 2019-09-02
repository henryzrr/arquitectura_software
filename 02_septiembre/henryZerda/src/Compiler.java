import java.util.List;

public class Compiler {
    private List<String> files;
    private String compilerName;
    private String fileType1;
    private String fileType2;
    public Compiler(List<String> files, Tool tool) {
        this.files = files;
        this.compilerName = tool.getName();
        this.fileType1 = tool.getFileType1();
        this.fileType2 = tool.getFileType2();
    }

    public void compile() throws Exception{
        for (String path:files
             ) {
            String command = compilerName+" "+path;
            Runtime.getRuntime().exec(command);
        }

    }
}
