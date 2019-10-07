import java.util.HashMap;
import java.util.Map;

public class ToolSettingsManager implements ToolSettings {
    private static ToolSettings toolSettingsManager = new ToolSettingsManager();
    private Map<String, ToolObject> container;

    private ToolSettingsManager(){
        container = new HashMap<>();
    }
    public void setTool(String key, ToolObject t) {
        container.put(key,t);
    }

    @Override
    public boolean exists(String key) {
        return container.containsKey(key);
    }

    @Override
    public ToolObject getTool(String key) {
        return container.get(key);
    }

    public static ToolSettings getInstance(){
        return toolSettingsManager;
    }
}
