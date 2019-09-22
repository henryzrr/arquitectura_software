package commands.toolAndApply;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

class ToolPluginLoader {
    private Map<String,IToolCreator> toolPluginInterfaces;
    ToolPluginLoader(){
        toolPluginInterfaces = loadTools();
    }

    private Map<String, IToolCreator> loadTools() {
        Map<String,IToolCreator> toolPluginInterfaces=new HashMap<>();
        ServiceLoader<IToolCreator> toolLoader = ServiceLoader.load(IToolCreator.class);
        for (IToolCreator tool:toolLoader
             ) {
            IToolCreator toolCreator = tool;
            String toolName=tool.getToolCreatorName();
            toolPluginInterfaces.put(toolName,tool);
        }
        return toolPluginInterfaces;
    }
    boolean toolCreatorIsLoaded(String toolName){
        return toolPluginInterfaces.containsKey(toolName);
    }

    IToolCreator getToolCreator(String toolName){
        return toolPluginInterfaces.get(toolName);
    }
}
