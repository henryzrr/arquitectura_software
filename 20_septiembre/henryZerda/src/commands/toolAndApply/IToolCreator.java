package commands.toolAndApply;

public interface IToolCreator {
    String getToolCreatorName();
    ITool newTool(String tool,String fileType1, String fileType2) throws Exception;
}
