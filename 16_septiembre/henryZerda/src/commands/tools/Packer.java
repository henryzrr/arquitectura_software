package commands.tools;

import commands.ITool;
import main.Directory;


import java.util.Map;

public class Packer implements ITool {
    private  String toolName;
    private  String fileType1;
    private  String fileType2;

    public Packer(String toolName, String fileType1, String fileType2) {
        this.toolName = toolName;
        this.fileType1 = fileType1;
        this.fileType2 = fileType2;
    }


    @Override
    public void applyTool(Map<String, String> programValues, String dirCallFunction) throws Exception {
        String dirPath = programValues.get(dirCallFunction);
        Directory directory = new Directory(dirPath,dirCallFunction);
        IPacker packer;
        if(fileType1.equals("class") && fileType2.equals("jar")) {
            String homePath = programValues.get("home");
            packer = new jarPacker(directory);
            packer.startPacking();
        }else
            throw new Exception("apply Error, bad params "+fileType1 +" or "+fileType2 +" unsupported");
    }
}
