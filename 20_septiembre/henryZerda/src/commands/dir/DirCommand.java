package commands.dir;

import main.Command;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class DirCommand implements Command {
    private String dirName;
    private String dirPath;

    DirCommand(List<String> instructionTokens) throws Exception{
        initializeDirCommand(instructionTokens);
    }

    private void initializeDirCommand(List<String> instructionTokens) throws Exception{
        if(instructionTokens.size()!=2)
            throw new Exception("dir Error, Bad params on bob.conf");
        String dirNameAndPath=instructionTokens.get(1);
        StringTokenizer tokenizer = new StringTokenizer(dirNameAndPath,"=");
        dirName = tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()) {
            dirPath = tokenizer.nextToken();
            dirPath = dirPath.replaceAll("\"", "");
        }else
            dirPath=null;
    }


    @Override
    public void execute(Map<String, String> programValues) {
        adjustDirPath(programValues);
        programValues.put(dirName,dirPath);
    }

    private void adjustDirPath(Map<String, String> programValues) {
        if(dirName.equals("home")){
            boolean pathIsNull = dirPath==null;
            if(dirPath==null){
                dirPath = getExecutionPath();
            }
            if(programValues.get("isWindows").equals("True") && !pathIsNull){
                dirPath = programValues.get("volume")+":"+dirPath;
            }
        }else {
            dirPath = (programValues.get("home"))+"/"+dirPath;
        }
        dirPath = Paths.get(dirPath).toString();
    }

    private String  getExecutionPath() {
        return System.getProperty("user.dir");
    }
}
