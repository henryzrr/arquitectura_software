package commands;

import main.Command;
import main.IPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToolPluginInterface implements IPlugin {
    private static Map<String,ITool> tools=new HashMap<>();

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
}
