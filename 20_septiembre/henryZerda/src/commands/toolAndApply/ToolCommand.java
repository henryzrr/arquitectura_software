package commands.toolAndApply;

import commands.toolAndApply.tools.Compiler;
import commands.toolAndApply.tools.Packer;
import main.Command;

import java.util.List;
import java.util.Map;


class ToolCommand implements Command {
    private String toolName;
    private String toolType;
    private String fileType1;
    private String fileType2;

    ToolCommand(List<String> commandLineTokens) throws Exception {
        initializeToolCommand(commandLineTokens);
    }

    private void initializeToolCommand(List<String> commandLineTokens) throws Exception {
        if(commandLineTokens.size()!=5)
            throw new Exception("tool Error, bad params on bob.conf");
        toolName = commandLineTokens.get(1);
        toolType = commandLineTokens.get(2).replaceAll("\"","");
        fileType1 = commandLineTokens.get(3);
        fileType2 = commandLineTokens.get(4);
    }


    @Override
    public void execute(Map<String, String> programValues) throws Exception {
        ITool tool;
        switch (toolType){
            case "compilador":
                tool = new Compiler(toolName,fileType1,fileType2);
                break;
            case "empaquetador":
                tool = new Packer(toolName,fileType1,fileType2);
                break;
            default:
                throw new Exception("tool Error, tool type unsuported on "+toolName);
        }
        Map<String,ITool> tools = ToolPluginInterface.getTools();
        tools.put(toolName,tool);
    }
}
