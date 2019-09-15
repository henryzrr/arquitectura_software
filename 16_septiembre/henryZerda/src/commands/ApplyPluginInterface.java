package commands;

import main.Command;
import main.IPlugin;

import java.util.List;
import java.util.Map;

public class ApplyPluginInterface implements IPlugin {
    @Override
    public String getPluginName() {
        return "apply";
    }

    @Override
    public Command newCommand(List<String> commandLineTokens) throws Exception {
        return new ApplyCommand(commandLineTokens);
    }


}
