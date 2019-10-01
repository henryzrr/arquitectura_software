import java.util.List;

public class ApplyPluginInterface implements IPlugin {
    private BobProgramValues bobProgramValues;
    public ApplyPluginInterface(){
        bobProgramValues=BobProgramValues.getBobProgramValues();
    }
    @Override
    public String getPluginName() {
        return "apply";
    }

    @Override
    public ICommand newCommand(List<String> commandLineTokens) throws Exception {
        return new ApplyCommand(commandLineTokens,bobProgramValues);
    }


}
