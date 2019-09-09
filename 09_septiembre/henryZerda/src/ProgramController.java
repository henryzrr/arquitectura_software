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
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private Set<String> setCommands(){
        Set<String>commandList=new HashSet<>();
        commandList.add("dir");
        commandList.add("print");
        commandList.add("tool");
        commandList.add("apply");
        commandList.add("volume");
        return commandList;
    }
    private String setFilePath(){
        return "configure/bob.conf";
    }
    private boolean getIsWindows(){
        return (System.getProperty("os.name")).contains("Windows");
    }

}
