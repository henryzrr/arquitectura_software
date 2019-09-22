package commands.toolAndApply.tools.compiler;

import commands.toolAndApply.ITool;
import main.BobProgramValues;
import main.Directory;


import java.util.Map;

public class CompilerTool implements ITool {

    private  String toolInstruction;
    private  String fileType1;
    private  String fileType2;
    private BobProgramValues bobProgramValues;
    public CompilerTool(String toolInstruction, String fileType1, String fileType2, BobProgramValues bobProgramValues) {
        this.toolInstruction = toolInstruction;
        this.fileType1 = fileType1;
        this.fileType2 = fileType2;
        this.bobProgramValues = bobProgramValues;
    }



    @Override
    public void applyTool(String dirCallFunction) throws Exception {
        String dirPath = bobProgramValues.getDirPath(dirCallFunction);
        Directory directory = new Directory(dirPath,dirCallFunction);
        ICompiler compiler;
        compiler = new JavaCompiler(toolInstruction,fileType1,fileType2);
        compiler.compileAll(directory);

    }

}
