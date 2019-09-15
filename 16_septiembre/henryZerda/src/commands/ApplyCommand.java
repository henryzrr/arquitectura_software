package commands;

import main.Command;



import java.util.List;
import java.util.Map;

class ApplyCommand implements Command {

    private  String toolName;
    private String dirCallFunction;

    ApplyCommand(List<String> commandLineTokens) throws Exception {
        initializeApplyCommand(commandLineTokens);
    }

    private void initializeApplyCommand(List<String> commandLineTokens) throws Exception {
        if(commandLineTokens.size()!=3)
            throw new Exception("apply Error, bad params on bob.conf");
        toolName = commandLineTokens.get(1);
        dirCallFunction = commandLineTokens.get(2);
    }

    @Override
    public void execute(Map<String, String> programValues) throws Exception {
        Map<String,ITool> tools = ToolPluginInterface.getTools();
        if(!programValues.containsKey(dirCallFunction))
            throw new Exception("apply Error, directory "+dirCallFunction+" is not declared");

        if(!tools.containsKey(toolName))
            throw new Exception("apply Error, tool "+toolName+" is not declared");

        ITool tool = tools.get(toolName);
        tool.applyTool(programValues,dirCallFunction);
    }
}
