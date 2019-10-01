import java.util.HashMap;
import java.util.Map;

public class ToolPluginLoader {
    private Map<String,IToolCreator> availablePluginsInterface;
    ToolPluginLoader() throws Exception{
        availablePluginsInterface = loadCommandPlugin();

    }

    private Map<String, IToolCreator> loadCommandPlugin() throws Exception{
        Map<String, IToolCreator> availableCommandInterfaces = new HashMap<>();
        AvailableToolPluginIterator iteratorAvailablePlugins = new AvailableToolPluginIterator();
        for (String pluginName: iteratorAvailablePlugins
             ) {
            ClassLoader loader = new BobClassLoader();
            Object o= ((BobClassLoader) loader).loadClass(pluginName,true).getDeclaredConstructor().newInstance();
            IToolCreator tool = (IToolCreator) o;
            availableCommandInterfaces.put(tool.getToolCreatorName(),tool);
        }
        return availableCommandInterfaces;
    }

    boolean toolCreatorIsLoaded(String pluginName){
        return availablePluginsInterface.containsKey(pluginName);
    }
    IToolCreator getToolCreator(String pluginName){
        return availablePluginsInterface.get(pluginName);
    }

}
