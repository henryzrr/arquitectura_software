import java.util.HashMap;
import java.util.Map;

public class CommandPluginLoader {
    private Map<String,IPlugin> availablePluginsInterface;
    CommandPluginLoader() throws Exception{
        availablePluginsInterface = loadCommandPlugin();

    }

    private Map<String, IPlugin> loadCommandPlugin() throws Exception{
        Map<String, IPlugin> availableCommandInterfaces = new HashMap<>();
        AvailablePluginsIterator iteratorAvailablePlugins = new AvailablePluginsIterator();
        for (String pluginName: iteratorAvailablePlugins
             ) {
            ClassLoader loader = new BobClassLoader();
            Object o= ((BobClassLoader) loader).loadClass(pluginName,true).newInstance();
            IPlugin command = (IPlugin) o;
            availableCommandInterfaces.put(command.getPluginName(),command);
        }
        return availableCommandInterfaces;
    }

    boolean pluginInterfaceIsLoaded(String pluginName){
        return availablePluginsInterface.containsKey(pluginName);
    }
    IPlugin getPluginInterface(String pluginName){
        return availablePluginsInterface.get(pluginName);
    }

}
