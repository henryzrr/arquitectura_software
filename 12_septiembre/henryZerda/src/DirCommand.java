import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class DirCommand implements ICommand {
    private String dirName;
    private String dirPath;
    private List<String> CommandAndParams;
    private boolean isWindows;
    private Map<String,String> systemValues;

    DirCommand(List<String> commandAndParamList, boolean isWindowsOS, Map<String, String> systemValues) {
        CommandAndParams = commandAndParamList;
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
        if(CommandAndParams.size()>2){
            throw new Exception("dir error, mal parametro");
        }
        String dirNameAndPath = CommandAndParams.get(1);
        StringTokenizer tokenizer = new StringTokenizer(dirNameAndPath,"=");
        dirName = tokenizer.nextToken();
        if(!tokenizer.hasMoreElements())
            if(dirName.equals("home"))
                dirPath = getExecutionPath();
            else
                throw new Exception("dir error, mal parametro "+dirName);
        else{
            dirPath = tokenizer.nextToken();
            dirPath = dirPath.replaceAll("\"","");
            if(isWindows) {
                dirPath = systemValues.get("volume") + ":" + dirPath;
                dirPath = dirPath.replaceAll("/", "\\\\");
            }
        }
    }
}
