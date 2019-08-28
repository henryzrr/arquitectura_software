public class Dir implements Instruction {
    String dirName;
    String dirPath;
    public Dir(){
        dirName = null;
        dirPath=null;
    }
    public void setDirPath(String path) {
        if(dirName.equals("home")&&path==null){
            dirPath = getExecutionPath();
        }else{
            dirPath=path;
        }
    }

    public String getDirPath() {
        return dirPath;
    }

    private String getExecutionPath(){
        return (System.getProperty("user.id"));
    }

    @Override
    public void set_instructionName(String name) {
        dirName = name;
    }

    @Override
    public String getInstructionName() {
        return dirName;
    }


}
