package commands.toolAndApply.tools.compiler;

import commands.toolAndApply.ITool;
import commands.toolAndApply.IToolCreator;
import main.BobProgramValues;

public class CompilerToolCreator implements IToolCreator {
    private  BobProgramValues bobProgramValues;
    public CompilerToolCreator(){
        bobProgramValues = BobProgramValues.getBobProgramValues();
    }
    @Override
    public String getToolCreatorName() {
        return "compilador";
    }

    @Override
    public ITool newTool(String toolInstruction, String fileType1, String fileType2) throws Exception {
        return new CompilerTool(toolInstruction,fileType1,fileType2,bobProgramValues);
    }
}
