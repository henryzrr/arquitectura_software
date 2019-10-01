import java.util.HashMap;
import java.util.Map;

public class ToolContainerImplementation implements ToolContainer {
    private ToolContainer toolContainer= new ToolContainerImplementation();
    private Map<String,Tool> container;

    private ToolContainerImplementation(){
        container = new HashMap<>();
    }
    public void setTool(String key, Tool t) {
        container.put(key,t);
    }

    @Override
    public boolean exists(String key) {
        return container.containsKey(key);
    }

    @Override
    public Tool getTool(String key) {
        return container.get(key);
    }
}
