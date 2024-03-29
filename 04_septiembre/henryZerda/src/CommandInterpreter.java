import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CommandInterpreter {
    private Reader fileReader;
    private FileConfParser fileParser;
    private boolean isWindowsOS;
    private Map<String,String> systemValues;
    private Map<String,Compiler> compilers;

    CommandInterpreter(String bob_path, Set<String> commands,boolean isWindowsOS) throws Exception {
        fileReader = new Reader(bob_path);
        fileParser = new FileConfParser(commands);
        this.isWindowsOS = isWindowsOS;
        systemValues = new HashMap<>();
        if(isWindowsOS) {
            systemValues.put("volume", "C");
        }
        compilers = new HashMap<>();
    }
    void executeConfCommands() throws Exception{
        String fileLine;
        while((fileLine= fileReader.nextLine())!=null){
            List<String> commandAndParamList=fileParser.getCommandAndParams(fileLine);
            Command command;
            switch (commandAndParamList.get(0)){
                case "dir":
                    command = new DirCommand(commandAndParamList,isWindowsOS, systemValues);
                    break;
                case "print":
                    command = new PrintCommand(commandAndParamList, systemValues);
                    break;
                case "apply":
                    command = new ApplyCommand(commandAndParamList, systemValues,compilers);
                    break;
                case "tool":
                    command = new ToolCommand(commandAndParamList, compilers, systemValues);
                    break;
                case "volume":
                    command = new VolumeCommand(commandAndParamList,systemValues);
                    break;
                default:
                    throw new Exception("Error comando, no válido");            }
            command.execute();
        }
        fileReader.close();
    }

}
