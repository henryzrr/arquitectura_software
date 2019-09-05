import java.util.List;
import java.util.Map;

public class ToolCommand implements Command{
    private List<String> commandAndParamList;
    private Map<String,Tool> tools;

    public ToolCommand(List<String> commandAndParamList, Map<String, Tool> tools) {
        this.commandAndParamList = commandAndParamList;
        this.tools = tools;
    }

    @Override
    public void execute() throws Exception {
        String toolName = commandAndParamList.get(1);
        switch (toolName){
            case "compilador":
                Tool compiler = new Compiler(commandAndParamList.get(2),commandAndParamList.get(3),commandAndParamList.get(4));
                tools.put(commandAndParamList.get(2),compiler);
                break;
            default:
                throw new Exception("Herramienta "+toolName+" no válida");
        }
    }
}
