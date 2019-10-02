import java.nio.file.Paths;

public class Dir implements Command{
    Settings settings;
    DirParser parser;
    public Dir(){
        Settings settings = BobSetting.getInstance();
        DirParser parser = new DirParser();
    }
    @Override
    public void execute(String args) {
        String [] tokens = parser.makeParsing(args);
        String dirName = tokens[0];
        String dirPath = tokens[1];
        setDirAndPath(dirName,dirPath);

    }
    private void setDirAndPath(String dirName, String dirPath){
        boolean pathExist = verifyPathIsSetted(dirPath);

        if(pathExist){
            if(dirName.equals("home"))
                dirPath = getExecutionPath();
            else {
                System.err.println("Bad Params for dir on bob.conf");
                System.exit(1);
            }
        }else{
            boolean pathIsRelative = verifyPathIsRelative(dirPath);
            if(pathIsRelative)
                dirPath = settings.getDir("home")+"/"+dirPath;
            if(!settings.isUnix()){
                dirPath=settings.getVolume()+":"+dirPath;
                dirPath = Paths.get(dirPath).toString();
            }

        }
        settings.setDir(dirName,dirPath);

    }
    private boolean verifyPathIsSetted(String dirPath) {
        return dirPath==null;
    }

    private boolean verifyPathIsRelative(String dirPath) {
        return dirPath.charAt(0)!='/';
    }

    private String getExecutionPath(){
        return System.getProperty("user.dir");
    }
}
