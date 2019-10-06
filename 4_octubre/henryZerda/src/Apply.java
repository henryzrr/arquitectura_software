import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Apply implements Command {
    private ToolSettings toolSettings;
    private Settings settings;

    public Apply(){
        toolSettings = ToolSettingsManager.getInstance();
        settings = SettingsManager.getInstance();
    }

    @Override
    public void execute(String args) {
        try {
            String [] applyParams = makeParsing(args);
            String toolName = applyParams[0];
            String dirName = applyParams[1];
            ToolObject toolObject = toolSettings.getTool(toolName);
            executeCommand(toolObject,settings.getDir(dirName));
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

    }

    private void executeCommand(ToolObject toolObject, String dirPath) {
        try{
            List<String> command = tokenizerCommand(toolObject.getFullCommandCall());
            getAllFiles(command,dirPath, toolObject.getInputFileType());
            File executionDir = new File(dirPath);
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.directory(executionDir);
            Process process = processBuilder.start();
            process.waitFor();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void getAllFiles(List<String> command, String dirPath,String inputFile) throws InvalidPathException{
        Iterator<String> dirIterator;
        String function=command.get(0);
        switch (function){
            case "jar":
                dirIterator = getSpecificFileTypeWithRelativePah(inputFile,dirPath);
                break;
            default:
                dirIterator = getSpecificFileTypeWithAbsolutePath(inputFile,dirPath);
        }
        while(dirIterator.hasNext()){
            command.add(dirIterator.next());
        }
    }

    private List<String> tokenizerCommand(String args) {
        List<String> list = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(args," ");
        while (tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }
        return  list;
    }

    private String[] makeParsing(String args) throws  Exception{
        try {
            StringTokenizer tokenizer = new StringTokenizer(args," ");
            String toolName = tokenizer.nextToken();
            String dirName = tokenizer.nextToken();
            return  new String[]{toolName,dirName};
        }catch (Exception e){
            throw new Exception("Error on method execute in Apply, bad params for apply on bob.conf");
        }
    }
    private Iterator<String> getSpecificFileTypeWithAbsolutePath(String fileType, String dirPath) throws InvalidPathException {
        try {
            return getFiles(fileType, dirPath).iterator();
        }catch (Exception e){
            throw  new InvalidPathException("The path does not exist: "+dirPath,"bad path param for getSpecificFileTypeWithAbsolutePath method on Apply");
        }
    }
    private List<String> getFiles(String fileType,String dirPath) throws Exception {
        Stream<Path> streamPath = Files.walk(Paths.get(dirPath));
        return  streamPath.map(Path::toString).filter(x-> x.endsWith(fileType)).collect(Collectors.toList());
    }

    private Iterator<String>getSpecificFileTypeWithRelativePah(String fileType,String dirPath) throws InvalidPathException {
        try {
            List<String> files = getFiles(fileType,dirPath);
            files = formatToRelativePath(files,dirPath);
            return files.iterator();
        }catch (Exception e){
            throw  new InvalidPathException("The path does not exist: "+dirPath,"bad path param for getSpecificFileTypeWithRelativePath method on Apply");
        }

    }
    private List<String> formatToRelativePath(List<String>files,String dirPath) {
        int dirPathSize = dirPath.length();
        List<String> filesList = new LinkedList<>();
        for (String path: files
        ) {
            filesList.add(path.substring(dirPathSize+1));
        }
        return filesList;
    }

}
