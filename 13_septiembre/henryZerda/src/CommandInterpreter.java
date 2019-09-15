import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CommandInterpreter {
    private Reader fileReader;
    private FileConfParser fileParser;
    private boolean isWindowsOS;
    private Map<String,String> systemValues;
    private Map<String, ITool> tools;

    CommandInterpreter(String bob_path, Set<String> commands,boolean isWindowsOS) throws Exception {
        fileReader = new Reader(bob_path);
        fileParser = new FileConfParser(commands);
        this.isWindowsOS = isWindowsOS;
        systemValues = new HashMap<>();
        if(isWindowsOS) {
            systemValues.put("volume", "C");
        }
        tools = new HashMap<>();
    }
    void executeConfCommands() throws Exception{
        String fileLine;
        while((fileLine= fileReader.nextLine())!=null){
            List<String> commandAndParamList=fileParser.getCommandAndParams(fileLine);
            ICommand command;
            switch (commandAndParamList.get(0)){
                case "dir":
                    command = new DirCommand(commandAndParamList,isWindowsOS, systemValues);
                    break;
                case "print":
                    command = new PrintCommand(commandAndParamList, systemValues);
                    break;
                case "apply":
                    command = new ApplyCommand(commandAndParamList, systemValues, tools);
                    break;
                case "tool":
                    command = new ToolCommand(commandAndParamList, tools);
                    break;
                case "volume":
                    command = new VolumeCommand(commandAndParamList,systemValues);
                    break;
                default:
                    throw new Exception("bob.conf error,  comando, no válido");            }
            command.execute();
        }
        fileReader.close();
    }

}
