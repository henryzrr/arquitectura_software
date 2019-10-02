import java.util.Iterator;

public class Print implements Command {
    private DirectoryManager directoryManager;
    private Settings settings;
    private PrintParser printParser;
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
        directoryManager.setNewDirectory(dirName,dirPath);
        Iterator<String> dirContent;
        switch (function){
            case "files":
                dirContent = directoryManager.getAllFiles();
                break;
            case "dirs":
                dirContent = directoryManager.getDirs();
                break;
            default:
                dirContent = directory.getDirPath();
        }
        printDirContent(dirContent);
    }

    private void printDirContent(Iterator<String> dirContent) {

        while (dirContent.hasNext()){
            System.out.println(dirContent.next());
        }
    }
}
