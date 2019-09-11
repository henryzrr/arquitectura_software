import java.util.List;
import java.util.Map;

public interface ITool {
    void applyTool(List<String> commandAndParamList, Map<String,String> systemValues)throws Exception;
}
