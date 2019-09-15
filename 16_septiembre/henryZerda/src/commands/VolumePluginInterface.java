package commands;

import main.Command;
import main.IPlugin;

import java.util.List;

public class VolumePluginInterface implements IPlugin {
    @Override
    public String getPluginName() {
        return "volume";
    }

    @Override
    public Command newCommand(List<String> commandLineTokens) throws Exception {
        return new VolumeCommand(commandLineTokens);
    }

}
