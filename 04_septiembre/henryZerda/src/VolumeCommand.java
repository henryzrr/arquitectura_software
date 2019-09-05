import java.util.List;
import java.util.Map;

public class VolumeCommand implements Command{
    List<String> commandAndParamList;
    Map<String, String> systemValues;

    public VolumeCommand(List<String> commandAndParamList, Map<String, String> systemValues) {
        this.commandAndParamList =commandAndParamList;
        this.systemValues=systemValues;
    }

    @Override
    public void execute() throws Exception {
        if(commandAndParamList.size()>2)
            throw new Exception("parametro no admitido para volume ");
        systemValues.put("volume",commandAndParamList.get(1));
    }
}
