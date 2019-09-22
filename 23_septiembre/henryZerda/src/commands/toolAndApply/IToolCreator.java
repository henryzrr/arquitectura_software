package commands.toolAndApply;

public interface IToolCreator {
    String getToolCreatorName();
    ITool newTool(String toolInstruction,String fileType1, String fileType2) throws Exception;
}
