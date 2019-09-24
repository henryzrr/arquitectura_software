package commands.toolAndApply;

import main.BobProgramValues;
import main.ICommand;



import java.util.List;
import java.util.Map;

class ApplyCommand implements ICommand {

    private  String toolName;
    private String dirName;
    private BobProgramValues bobProgramValues;
    ApplyCommand(List<String> commandLineTokens, BobProgramValues bobProgramValues) throws Exception {
        initializeApplyCommand(commandLineTokens);
        this.bobProgramValues=bobProgramValues;
    }

    private void initializeApplyCommand(List<String> commandLineTokens) throws Exception {
        ApplyCommandParser applyCommandParser = new ApplyCommandParser(commandLineTokens);
        commandLineTokens = applyCommandParser.getValidTokens();
        toolName = commandLineTokens.get(0);
        dirName = commandLineTokens.get(1);
    }

    @Override
    public void execute() throws Exception {
        Map<String,ITool> tools = ToolPluginInterface.getTools();
        if(!bobProgramValues.containsDir(dirName))
            throw new Exception("apply Error, directory "+dirName+" is not declared");

        if(!tools.containsKey(toolName))
            throw new Exception("apply Error, tool "+toolName+" is not declared");

        ITool tool = tools.get(toolName);
        tool.applyTool(dirName);
    }
}
