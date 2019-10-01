import java.nio.file.Paths;
import java.util.List;

class DirCommand implements ICommand {
    private String dirName;
    private String dirPath;
    private BobProgramValues bobProgramValues;
    DirCommand(List<String> instructionTokens) throws Exception{
        initializeDirCommand(instructionTokens);
        this.bobProgramValues=BobProgramValues.getBobProgramValues();
    }

    private void initializeDirCommand(List<String> instructionTokens) throws Exception{
        DirCommandParser dirCommandParser = new DirCommandParser(instructionTokens);
        instructionTokens = dirCommandParser.getValidTokens();
        dirName=instructionTokens.get(0);
        dirPath=instructionTokens.get(1);
    }


    @Override
    public void execute() throws Exception {
        setDirAndPath();
        bobProgramValues.setNewDirectory(dirName,dirPath);
    }

    private void setDirAndPath() throws Exception {
        boolean pathIsNull = verifyPathIsSetted();

        if(pathIsNull){
            if(dirName.equals("home"))
                dirPath = bobProgramValues.getExecutionPath();
            else
                throw new BadParamsDirException("There is not a valid path for "+dirName);
        }else{
            boolean pathIsRelative = verifyPathIsRelative();
            if(pathIsRelative)
                dirPath = bobProgramValues.getDirPath("home")+"/"+dirPath;
            if(bobProgramValues.isWindows()){
                dirPath=bobProgramValues.getVolume()+":"+dirPath;
                dirPath = Paths.get(dirPath).toString();
            }

        }

    }

    private boolean verifyPathIsSetted() {
        return dirPath==null;
    }

    private boolean verifyPathIsRelative() {
        return dirPath.charAt(0)!='/';
    }

}
