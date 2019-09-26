import java.nio.file.Paths;
import java.util.List;

class DirCommand implements ICommand {
    private String dirName;
    private String dirPath;
    private BobProgramValues bobProgramValues;
    DirCommand(List<String> instructionTokens, BobProgramValues bobProgramValues) throws Exception{
        initializeDirCommand(instructionTokens);
        this.bobProgramValues=bobProgramValues;
    }

    private void initializeDirCommand(List<String> instructionTokens) throws Exception{
        DirCommandParser dirCommandParser = new DirCommandParser(instructionTokens);
        instructionTokens = dirCommandParser.getValidTokens();
        dirName=instructionTokens.get(0);
        dirPath=instructionTokens.get(1);
    }


    @Override
    public void execute() {
        setDirAndPath();
        bobProgramValues.setNewDirectory(dirName,dirPath);
    }

    private void setDirAndPath() {
        if(dirName.equals("home")){
            boolean pathIsNull = dirPath==null;
            if(dirPath==null){
                dirPath = bobProgramValues.getExecutionPath();
            }
            if(bobProgramValues.isWindows() && !pathIsNull){
                dirPath = bobProgramValues.getVolume()+":"+dirPath;
            }
        }else {
            dirPath = bobProgramValues.getDirPath("home") +"/"+dirPath;
            dirPath = Paths.get(dirPath).toString();
        }

    }

}
