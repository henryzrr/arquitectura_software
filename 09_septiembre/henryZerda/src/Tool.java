import java.util.List;
import java.util.Map;

public interface Tool {
    void applyTool(List<String> commandAndParamList, Map<String,String> systemValues)throws Exception;
}
