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
        if(commandAndParamList.size()!=5){
            throw new Exception("Comando tool con malos parametros");
        }
        String type=commandAndParamList.get(1);
        String name=commandAndParamList.get(2);
        String fileType1=commandAndParamList.get(3);
        String fileType2=commandAndParamList.get(4);

        Tool tool = new Tool(type,name,fileType1,fileType2);
        tools.put(name,tool);
    }
}
