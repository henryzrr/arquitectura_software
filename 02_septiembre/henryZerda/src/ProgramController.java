import javax.annotation.processing.FilerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class ProgramController {

    private String CONF_FILE_PATH;
    private Set<String>commands;
    private  boolean isWindows;
    ProgramController() {
        this.CONF_FILE_PATH=setFilePath();
        this.commands = setCommands();
        this.isWindows = getIsWindows();
    }
    void programStart(){
        try{
            CommandInterpreter interpreter = new CommandInterpreter(CONF_FILE_PATH,commands,isWindows);
            interpreter.executeConfCommands();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    Set<String> setCommands(){
        Set<String>commandList=new HashSet<>();
        commandList.add("dir");
        commandList.add("print");
        commandList.add("tool");
        commandList.add("apply");
        commandList.add("volume");
        return commandList;
    }
    String setFilePath(){
        return "configure/bob.conf";
    }
    private boolean getIsWindows(){
        return false;
    }

}
