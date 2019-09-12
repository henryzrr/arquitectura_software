import java.util.List;
import java.util.Map;

public class VolumeCommand implements ICommand {
    private List<String> commandAndParamList;
    private Map<String, String> systemValues;

    VolumeCommand(List<String> commandAndParamList, Map<String, String> systemValues) {
        this.commandAndParamList =commandAndParamList;
        this.systemValues=systemValues;
    }

    @Override
    public void execute() throws Exception {
        if(commandAndParamList.size()>2)
            throw new Exception("volume error, parametro no admitido");
        String volumeIdentifier = commandAndParamList.get(1);
        systemValues.put("volume",volumeIdentifier);
    }
}
