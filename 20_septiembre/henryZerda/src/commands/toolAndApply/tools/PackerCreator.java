package commands.toolAndApply.tools;

import commands.toolAndApply.ITool;
import commands.toolAndApply.IToolCreator;

public class PackerCreator implements IToolCreator {

    @Override
    public String getToolCreatorName() {
        return "empaquetador";
    }

    @Override
    public ITool newTool(String tool, String fileType1, String fileType2) throws Exception {
        return new Packer(tool,fileType1,fileType2);
    }
}
