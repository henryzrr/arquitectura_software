import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToolPluginInterface implements IPlugin {
    private static Map<String,ITool> tools=new HashMap<>();
    private ToolPluginLoader toolPluginLoader;

    public ToolPluginInterface() throws Exception {
        toolPluginLoader = new ToolPluginLoader();
    }

    @Override
    public String getPluginName() {
        return "tool";
    }

    @Override
    public ICommand newCommand(List<String> commandLineTokens) throws Exception {
        return new ToolCommand(commandLineTokens,toolPluginLoader);
    }

    static Map<String,ITool> getTools(){
        return tools;
    }
}
