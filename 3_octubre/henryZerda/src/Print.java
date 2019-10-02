import java.util.Iterator;

public class Print implements Command {
    private DirectoryManager directoryManager;
    private Settings settings;
    private PrintParser printParser;
    public Print(){
        directoryManager = DirectoryManager.getInstance();
        settings = BobSetting.getInstance();
        printParser = new PrintParser();
    }
    @Override
    public void execute(String args) {
        String [] tokens = printParser.makeParsing(args);
        String dirName = tokens[0];
        String function = tokens[1];
        print(dirName,function);
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
                dirContent = directoryManager.getAllFiles(dirPath);printDirContent(dirContent);
                printDirContent(dirContent);
                break;
            case "dirs":
                dirContent = directoryManager.getDirs(dirPath);
                printDirContent(dirContent);
                break;
            default:
                printCurrentPath(dirPath);
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
}
