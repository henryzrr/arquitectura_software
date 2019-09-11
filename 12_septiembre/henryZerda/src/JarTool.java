import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class JarTool implements ITool {
    private String packerName;
    private String inputFileType;
    private String outputFileType;

    JarTool(String packerName, String inputFileType, String outputFileType) {
        this.packerName = packerName;
        this.inputFileType = inputFileType;
        this.outputFileType = outputFileType;
    }


    @Override
    public void applyTool(List<String> commandAndParamList, Map<String, String> systemValues) throws Exception {
        int paramListSize = commandAndParamList.size();
        if(!hasValidParams(paramListSize)){
            throw new Exception("apply error, instruccion mal declarada para "+packerName);
        }
        String directoryClassesName = commandAndParamList.get(2);
        String directoryClassesPath = systemValues.get(directoryClassesName);
        List<String> files = getAllFiles(directoryClassesPath,directoryClassesName);
        makeJar(files,directoryClassesPath);
    }

    private List<String> getAllFiles(String directoryClassesPath,String directoryClassesName) throws Exception{
        List<String> files;
        Directory dirPath = new Directory(directoryClassesPath,directoryClassesName);
        files = dirPath.getOneFileTypeRelativePath(inputFileType);
        return files;
    }
    private void makeJar(List<String> files,String directoryClassesPath) throws Exception{
        List<String>command=new LinkedList<>();
        command.add("jar");
        command.add("cfe");
        command.add("jar."+outputFileType);
        command.add("Main");
        command.addAll(files);
        File path = new File(directoryClassesPath);
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.directory(path);
        Process process = processBuilder.start();
        process.waitFor();
    }
    private boolean hasValidParams(int paramListSize){
        return paramListSize==3;
    }
}
