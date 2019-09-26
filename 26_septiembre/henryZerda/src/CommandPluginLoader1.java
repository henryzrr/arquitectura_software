import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

class CommandPluginLoader1 {

    private Map<String,IPlugin> availablePluginsInterface;
    CommandPluginLoader1() throws Exception{
        availablePluginsInterface = loadCommandPlugin();
    }

    private Map<String, IPlugin> loadCommandPlugin() throws Exception{
        try {
            Map<String, IPlugin> availableCommandInterfaces = new HashMap<>();
            ServiceLoader <IPlugin> commandPluginInterfaceLoader = ServiceLoader.load(IPlugin.class);
            for (IPlugin commandPluginInterface : commandPluginInterfaceLoader) {
                String pluginName = commandPluginInterface.getPluginName();
                availableCommandInterfaces.put(pluginName, commandPluginInterface);

            }
            return availableCommandInterfaces;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    boolean pluginInterfaceIsLoaded(String pluginName){
        return availablePluginsInterface.containsKey(pluginName);
    }
    IPlugin getPluginInterface(String pluginName){
        return availablePluginsInterface.get(pluginName);
    }
}
