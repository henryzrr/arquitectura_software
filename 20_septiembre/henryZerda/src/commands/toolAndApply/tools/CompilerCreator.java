package commands.toolAndApply.tools;

import commands.toolAndApply.ITool;
import commands.toolAndApply.IToolCreator;

public class CompilerCreator implements IToolCreator {

    @Override
    public String getToolCreatorName() {
        return "compilador";
    }

    @Override
    public ITool newTool(String tool, String fileType1, String fileType2) throws Exception {
        return new Compiler(tool,fileType1,fileType2);
    }
}
