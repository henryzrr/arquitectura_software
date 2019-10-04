import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Dir implements Command{
    Settings settings;
    public Dir(){
        settings = SettingsManager.getInstance();
    }
    @Override
    public void execute(String args) {
        String [] tokens = makeParsing(args);
        String dirName = tokens[0];
        String dirPath = tokens[1];
        setDirAndPath(dirName,dirPath);

    }
    private void setDirAndPath(String dirName, String dirPath){
        boolean pathExist = verifyPathIsSetted(dirPath);
        if(!pathExist){
            if(dirName.equals("home")) {
                dirPath = getExecutionPath();
            }else {
                System.err.println("Bad Params for dir on bob.conf");
                System.exit(1);
            }
        }else{
            boolean pathIsRelative = verifyPathIsRelative(dirPath);
            if(!settings.exists("home"))
                settings.setDir("home",getExecutionPath());
            if(pathIsRelative) {
                dirPath = settings.getDir("home") + "/" + dirPath;
                dirPath = Paths.get(dirPath).toString();
            }else if(!settings.isUnix()){
                dirPath=settings.getVolume()+":"+dirPath;
                dirPath = Paths.get(dirPath).toString();
            }

        }
        settings.setDir(dirName,dirPath);

    }
    public String[] makeParsing(String args) {
        StringTokenizer tokenizer = new StringTokenizer(args,"=");
        String dirName = tokenizer.nextToken();
        String dirPath = "";
        if(tokenizer.hasMoreTokens()){
            dirPath = tokenizer.nextToken().replaceAll("\"","");
        }
        return  new String[]{dirName,dirPath};
    }
    private boolean verifyPathIsSetted(String dirPath) {
        return !dirPath.equals("");
    }

    private boolean verifyPathIsRelative(String dirPath) {
        return dirPath.charAt(0)!='/';
    }

    private String getExecutionPath(){
        return System.getProperty("user.dir");
    }
}
