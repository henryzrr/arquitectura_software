public class PackerTool implements ITool {
    private  String toolName;
    private  String fileType1;
    private  String fileType2;
    private BobProgramValues bobProgramValues;
    public PackerTool(String toolName, String fileType1, String fileType2, BobProgramValues bobProgramValues) {
        this.toolName = toolName;
        this.fileType1 = fileType1;
        this.fileType2 = fileType2;
        this.bobProgramValues = bobProgramValues;
    }


    @Override
    public void applyTool(String dirCallFunction) throws Exception {
        String dirPath = bobProgramValues.getDirPath(dirCallFunction);
        Directory directory = new Directory(dirPath,dirCallFunction);
        IPacker packer;
        packer = new javaPacker(directory,toolName,fileType1,fileType2);
        packer.startPacking();
    }


}
