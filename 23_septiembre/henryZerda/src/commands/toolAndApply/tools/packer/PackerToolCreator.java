package commands.toolAndApply.tools.packer;

import commands.toolAndApply.ITool;
import commands.toolAndApply.IToolCreator;
import main.BobProgramValues;

public class PackerToolCreator implements IToolCreator {
    private BobProgramValues bobProgramValues;

    public PackerToolCreator(){
        bobProgramValues=BobProgramValues.getBobProgramValues();
    }
    @Override
    public String getToolCreatorName() {
        return "empaquetador";
    }

    @Override
    public ITool newTool(String toolInstruction, String fileType1, String fileType2) throws Exception {
        return new PackerTool(toolInstruction,fileType1,fileType2,bobProgramValues);
    }
}
