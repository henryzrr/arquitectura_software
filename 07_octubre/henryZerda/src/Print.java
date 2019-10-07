import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Print implements Command {
    private Settings settings;
    public Print(){
        settings = SettingsManager.getInstance();
    }
    @Override
    public void execute(String args) {
        try {
            String [] tokens = makeParsing(args);
            String dirName = tokens[0];
            String function = tokens[1];
            print(dirName,function);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void print(String dirName, String function) {
        if(!settings.exists(dirName)){
            System.err.println("Error executing print command, "+dirName+" was not declared");
            System.exit(1);
        }
        String dirPath = settings.getDir(dirName);
        Iterator<String> dirContent;
        System.out.println();
        switch (function){
            case "files":
                dirContent = getAllFiles(dirPath);
                printDirContent(dirContent);
                break;
            case "dirs":
                dirContent = getDirs(dirPath);
                printDirContent(dirContent);
                break;
            default:
                printCurrentPath(dirPath);
        }

    }

     private Iterator<String> getAllFiles(String dirPath)throws InvalidPathException {
        try {
            Stream<Path> streamPath = Files.walk(Paths.get(dirPath));
            return  streamPath.filter(Files::isRegularFile).map(Path::toString).collect(Collectors.toList()).iterator();
        }catch (Exception e){
            throw  new InvalidPathException("The path does not exist: "+dirPath,"bad path param for getAllFiles method on Print");
        }
    }

    private Iterator<String> getDirs(String dirPath)throws InvalidPathException{
        try{
            Stream<Path> streamPath = Files.walk(Paths.get(dirPath));
            List<String> dirs = streamPath.filter(Files::isDirectory).map(Path::toString).collect(Collectors.toList());
            return dirs.iterator();
        }catch (Exception e){
            throw  new InvalidPathException("The path does not exist: "+dirPath,"bad path param for getDirs method on Print");
        }
    }
    private void printCurrentPath(String dirPath) {
        System.out.println(dirPath);
    }

    private void printDirContent(Iterator<String> dirContent) {
        while (dirContent.hasNext()){
            System.out.println(dirContent.next());
        }
    }
    private String [] makeParsing(String args) {
        StringTokenizer tokenizer = new StringTokenizer(args,".");
        String dirName = tokenizer.nextToken();
        String functionCall;
        if(tokenizer.hasMoreTokens())
            functionCall = tokenizer.nextToken();
        else
            functionCall="path";

        return new String[]{dirName,functionCall};
    }

}
