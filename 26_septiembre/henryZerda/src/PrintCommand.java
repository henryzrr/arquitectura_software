import java.util.Iterator;
import java.util.List;


public class PrintCommand implements ICommand {
    private String dirName;
    private String functionCall;
    private BobProgramValues bobProgramValues;
    PrintCommand(List<String> commandLineTokens, BobProgramValues bobProgramValues) throws Exception{
        initializePrintCommand(commandLineTokens);
        this.bobProgramValues=bobProgramValues;
    }

    private void initializePrintCommand(List<String> commandLineTokens) throws Exception{
        PrintCommandParser  printCommandParser = new PrintCommandParser(commandLineTokens);
        commandLineTokens = printCommandParser.getValidTokens();
        dirName=commandLineTokens.get(0);
        functionCall = commandLineTokens.get(1);
    }


    @Override
    public void execute( ) throws Exception {
        if(!bobProgramValues.containsDir(dirName))
            throw new Exception("print Error, bad param on bob.conf. "+dirName+" does not exist");
        String dirPath = bobProgramValues.getDirPath(dirName);
        Directory directory = new Directory(dirPath,dirName);
        Iterator<String> dirContent;
        switch (functionCall){
            case "files":
                System.out.println("\nEl directorio "+dirName+" tiene los siguientes archivos:");
                dirContent = directory.getAllFiles();
                break;
            case "dirs":
                System.out.println("\nEl directorio "+dirName+" tiene los siguientes directorios:");
                dirContent = directory.getDirs();
                break;
            default:
                System.out.println("\nEl directorio "+dirName+" tiene de path:");
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
