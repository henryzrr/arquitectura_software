package commands.toolAndApply;

import main.Command;
import main.IPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

public class ToolPluginInterface implements IPlugin {
    private static Map<String,ITool> tools=new HashMap<>();
    private static Map<String,IToolCreator> toolCreator;

    public ToolPluginInterface(){
        toolCreator = getAvailableTools();
    }

    private Map<String, IToolCreator> getAvailableTools(){
        Map<String, IToolCreator> availableTools = new HashMap<>();
        ServiceLoader<IToolCreator> commandPluginInterfaceLoader = ServiceLoader.load(IToolCreator.class);
        for (IToolCreator commandPluginInterface : commandPluginInterfaceLoader) {
            String toolName = commandPluginInterface.getToolCreatorName();
            availableTools.put(toolName, commandPluginInterface);
        }
        return availableTools;
    }

    @Override
    public String getPluginName() {
        return "tool";
    }

    @Override
    public Command newCommand(List<String> commandLineTokens) throws Exception {
        return new ToolCommand(commandLineTokens);
    }

    static Map<String,ITool> getTools(){
        return tools;
    }
    static Map<String,IToolCreator> getToolCreator(){
        return toolCreator;
    }
}
