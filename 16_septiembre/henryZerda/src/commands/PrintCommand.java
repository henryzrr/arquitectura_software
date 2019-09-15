package commands;

import main.Command;
import main.Directory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class PrintCommand implements Command {
    private String dirName;
    private String functionCall;

    PrintCommand(List<String> commandLineTokens) throws Exception{
        initializePrintCommand(commandLineTokens);
    }

    private void initializePrintCommand(List<String> commandLineTokens) throws Exception{
        if(commandLineTokens.size()!=2)
            throw new Exception("print Error, bad params on bob.conf");
        String dirAndCallFunction = commandLineTokens.get(1);
        StringTokenizer tokenizer = new StringTokenizer(dirAndCallFunction,".");
        dirName = tokenizer.nextToken();
        if(tokenizer.hasMoreTokens())
            functionCall = tokenizer.nextToken();
        else
            functionCall="path";

    }


    @Override
    public void execute(Map<String, String> programValues) throws Exception {
        if(!programValues.containsKey(dirName))
            throw new Exception("print Error, bad param on bob.conf. "+dirName+" does not exist");
        String dirPath = programValues.get(dirName);
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
