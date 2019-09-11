import java.util.List;
import java.util.Map;

public class ApplyCommand implements ICommand {
    private List<String> commandAndParamList;
    private Map<String, String> systemValues;
    private Map<String, ITool> tools;

    ApplyCommand(List<String> commandAndParamList, Map<String, String> systemValues, Map<String, ITool> tools) {
        this.commandAndParamList = commandAndParamList;
        this.systemValues = systemValues;
        this.tools = tools;
    }

    @Override
    public void execute() throws Exception {
        int applyArguments = commandAndParamList.size();
        if(applyArguments<2)
            throw new Exception("apply error, instruccion mal declarada");

        String toolName = commandAndParamList.get(1);
        if(!tools.containsKey(toolName)){
            throw new Exception("apply error, herramienta no soportada por el sistema");
        }
        ITool tool = tools.get(toolName);
        tool.applyTool(commandAndParamList,systemValues);
    }




}
