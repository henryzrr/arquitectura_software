package commands.toolAndApply.tools;

import commands.toolAndApply.ITool;
import main.Directory;


import java.util.Map;

public class Compiler implements ITool {

    private  String toolName;
    private  String fileType1;
    private  String fileType2;

    public Compiler(String toolName, String fileType1, String fileType2) {
        this.toolName = toolName;
        this.fileType1 = fileType1;
        this.fileType2 = fileType2;
    }



    @Override
    public void applyTool(Map<String, String> programValues, String dirCallFunction) throws Exception {
        String dirPath = programValues.get(dirCallFunction);
        Directory directory = new Directory(dirPath,dirCallFunction);
        ICompiler compiler;
        if(fileType1.equals("java") && fileType2.equals("class")) {
            compiler = new JavaCompiler(directory);
            compiler.compileAll();
        }else
            throw new Exception("apply Error, bad params "+fileType1 +" or "+fileType2 +" unsupported");
    }


}
