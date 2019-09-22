package commands.toolAndApply;

import main.ICommand;

import java.util.List;


class ToolCommand implements ICommand {
    private String toolName;
    private String toolInstruction;
    private String fileType1;
    private String fileType2;
    private ToolPluginLoader toolPluginLoader;
    ToolCommand(List<String> commandLineTokens,ToolPluginLoader toolPluginLoader) throws Exception {
        initializeToolCommand(commandLineTokens);
        this.toolPluginLoader = toolPluginLoader;
    }

    private void initializeToolCommand(List<String> commandLineTokens) throws Exception {
        ToolCommandParser toolCommandParser = new ToolCommandParser(commandLineTokens);
        commandLineTokens = toolCommandParser.getValidTokens();
        toolName = commandLineTokens.get(0);
        toolInstruction = commandLineTokens.get(1);
        fileType1 = commandLineTokens.get(2);
        fileType2 = commandLineTokens.get(3);

    }


    @Override
    public void execute( ) throws Exception {
        if(!toolPluginLoader.toolCreatorIsLoaded(toolName)){
            throw new Exception("tool Error, tool type unsuported on "+toolName);
        }

        IToolCreator toolCreator =toolPluginLoader.getToolCreator(toolName);
        ITool tool=toolCreator.newTool(toolInstruction,fileType1,fileType2);

        (ToolPluginInterface.getTools()).put(toolName,tool);
    }
}
