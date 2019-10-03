import java.util.HashMap;
import java.util.Map;

public class CommandPluginLoader {
    private Map<String,Command> availablePluginsInterface;
    CommandPluginLoader() throws Exception{
        availablePluginsInterface = loadCommandPlugin();

    }

    private Map<String, Command> loadCommandPlugin() throws Exception{
        Map<String, Command> availableCommandInterfaces = new HashMap<>();

        availableCommandInterfaces.put("dir",new Dir());
        availableCommandInterfaces.put("print",new Print());
        availableCommandInterfaces.put("volume",new Volume());
        availableCommandInterfaces.put("tool",new ToolCommand());
        availableCommandInterfaces.put("apply",new Apply());

        return availableCommandInterfaces;
    }

    boolean commandIsLoaded(String commandName){
        return availablePluginsInterface.containsKey(commandName);
    }
    Command getCommand(String commandName){
        return availablePluginsInterface.get(commandName);
    }

}
