import java.util.List;

public class Compiler implements Tool{
    private String compilerName;
    private String fileType1;
    private String fileType2;

    public Compiler(String compilerName, String fileType1, String fileType2) {
        this.compilerName = compilerName;
        this.fileType1 = fileType1;
        this.fileType2 = fileType2;
    }


    @Override
    public void applyTool() throws Exception {
        for (String path:files
        ) {
            String command = compilerName+" "+path;
            System.out.println(command);
            Process process=Runtime.getRuntime().exec(command);
        }
    }
}
