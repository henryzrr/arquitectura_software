import java.util.Map;

public class Dir implements DirectoryInstruction {
    String dirName;
    String dirPath;
    public Dir(){
        dirName = null;
        dirPath=null;
    }

    @Override
    public void setDirName(String name) {
        dirName = name;
    }

    @Override
    public void setDirInstruction(String instruction) {
        if(dirName.equals("home")&&instruction==null){
            dirPath = getExecutionPath();
        }else{
            dirPath=instruction;
        }
    }

    @Override
    public void executeInstruction(Map<String, Directory> directories) throws Exception{
        Directory dir;
        if(directories.containsKey(dirName)){
            dir = directories.get(dirName);
            dir.setPath(dirPath);
        }else{
            dir = new Directory();
            dir.setName(dirName);
            dir.setPath(dirPath);
            directories.put(dirName,dir);
        }
    }

    private String getExecutionPath(){
        return (System.getProperty("user.dir"));
    }
}
