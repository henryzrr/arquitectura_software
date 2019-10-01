import javax.tools.Tool;
import java.util.HashMap;
import java.util.Map;

public class ToolManager {
    private ToolLoader toolLoader;
    private Map<String, Tool> availableTool;

    public ToolManager(){
        toolLoader = new ToolLoader();
        availableTool = new HashMap<String, Tool>();
    }

}
