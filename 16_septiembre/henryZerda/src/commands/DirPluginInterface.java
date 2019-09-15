package commands;

import main.Command;
import main.IPlugin;

import java.util.List;


public class DirPluginInterface implements IPlugin {
    @Override
    public String getPluginName() {
        return "dir";
    }

    @Override
    public Command newCommand(List<String> commandLineTokens) throws Exception{
        return new DirCommand(commandLineTokens);
    }
}
