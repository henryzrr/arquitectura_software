import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ApplyCommand implements Command{
    private List<String> commandAndParamList;
    private Map<String, String> directories;
    private Map<String,Tool> tools;

    public ApplyCommand(List<String> commandAndParamList, Map<String, String> directories, Map<String, Tool> tools) {
        this.commandAndParamList = commandAndParamList;
        this.directories = directories;
        this.tools = tools;
    }

    @Override
    public void execute() throws Exception {
        if(commandAndParamList.size()!=3){
            throw new Exception("Parametros comando apply invalidos");
        }
        String toolName = commandAndParamList.get(1);
        if(!tools.containsKey(toolName))
            throw new Exception("No existe un tool con el nombre "+toolName);
        Tool tool= tools.get(toolName);
        switch (tool.getType()){
            case "compilador":
                List<String> files = getAllFiles(commandAndParamList.get(2),tool.getFileType1());
                Compiler compiler = new Compiler(files,tool);
                compiler.compile();
                break;
        }

    }

    private List<String> getAllFiles(String path,String fileType) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(path,".");
        String dirName = tokenizer.nextToken();
        List<String>files;
        if(tokenizer.hasMoreTokens()){
            if(!directories.containsKey(dirName))
                throw new Exception("Parametros commando apply inválidos: no existe el directorio "+dirName);
            Directory dir = new Directory(dirName,directories.get(dirName));
            String dirFunction = tokenizer.nextToken();
            if(!dirFunction.equals("files") || tokenizer.hasMoreTokens()){
                throw new Exception("Parametros commando apply inválidos");
            }
            files = dir.getOneFileType(fileType);
        }else{
            files = new ArrayList<>();
            files.add(dirName);
        }
        return files;
    }

}
