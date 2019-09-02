import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class PrintCommand implements Command {
    private String dirName;
    private String dirFunction;
    List<String> commandAndParamList;
    Map<String, String> directories;

    public PrintCommand(List<String> commandAndParamList, Map<String, String> directories) {
        this.commandAndParamList = commandAndParamList;
        this.directories=directories;
    }

    @Override
    public void execute() throws Exception {
        if(commandAndParamList.size()>2){
            throw new Exception("Error en  Comando print, mal parametro");
        }
        StringTokenizer tokenizer = new StringTokenizer(commandAndParamList.get(1),".");
        dirName = tokenizer.nextToken();
        if(tokenizer.hasMoreElements())
            dirFunction = tokenizer.nextToken();
        else
            dirFunction="path";
        if(!directories.containsKey(dirName))
            throw new Exception("Nombre de directorio inexistente "+dirName);
        Directory dir = new Directory(directories.get(dirName),dirName);
        switch (dirFunction){
            case "path":
                printPathDir(dir);
                break;
            case "files":
                printFilesDir(dir);
                break;
            case "dirs":
                printDirsDir(dir);
                break;
        }

    }
    private void printPathDir(Directory dir){
        System.out.println("\nEl path de "+dirName+" es:");
        System.out.println(dir.getPath()+"\n");
    }
    private void printFilesDir(Directory dir) throws Exception {
        System.out.println("\nLos Archivos que contiene "+dirName+" son:");
        List<String>files = dir.getFiles();
        files.forEach(System.out::println);
        System.out.println();
    }
    private void printDirsDir(Directory dir) throws Exception {
        System.out.println("\nLos directorios que contiene "+dirName+" son:");
        List<String>files = dir.getDirectories();
        files.forEach(System.out::println);
        System.out.println();
    }
}
