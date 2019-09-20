package commands.toolAndApply;

import main.Command;
import main.IPlugin;

import java.util.List;

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
