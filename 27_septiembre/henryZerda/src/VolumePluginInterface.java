import java.util.List;

public class VolumePluginInterface implements IPlugin {
    private BobProgramValues bobProgramValues;
    public VolumePluginInterface(){
        this.bobProgramValues = BobProgramValues.getBobProgramValues();
    }
    @Override
    public String getPluginName() {
        return "volume";
    }

    @Override
    public ICommand newCommand(List<String> commandLineTokens) throws Exception {
        return new VolumeCommand(commandLineTokens,bobProgramValues);
    }

}
