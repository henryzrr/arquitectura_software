import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class DirCommand implements Command {
    private String dirName;
    private String dirPath;
    private List<String>params;
    private boolean isWindows;
    private Map<String,String> systemValues;

    DirCommand(List<String> commandAndParamList, boolean isWindowsOS, Map<String, String> systemValues) {
        params = commandAndParamList;
        this.isWindows = isWindowsOS;
        this.systemValues = systemValues;
    }

    private String getExecutionPath(){
        return (System.getProperty("user.dir"));
    }

    @Override
    public void execute() throws Exception {
        setDirNameAndPath();
        systemValues.put(dirName,dirPath);
    }
    private void setDirNameAndPath()throws Exception{
        if(params.size()>2){
            throw new Exception("Error en  Comando dir, mal parametro");
        }
        StringTokenizer tokenizer = new StringTokenizer(params.get(1),"=");
        dirName = tokenizer.nextToken();
        if(!tokenizer.hasMoreElements())
            if(dirName.equals("home"))
                dirPath = getExecutionPath();
            else
                throw new Exception("Error en  Comando dir, mal parametro "+dirName);
        else
            dirPath = tokenizer.nextToken();
            dirPath = dirPath.replaceAll("\"","");
        if(isWindows)
            dirPath= systemValues.get("volume")+":"+dirPath;
    }
}
