package commands;

import main.Command;

import java.util.List;
import java.util.Map;

class VolumeCommand implements Command {

    private String volume;

    VolumeCommand(List<String> commandLineTokens) throws Exception {
        initializeVolumeCommand(commandLineTokens);
    }

    private void initializeVolumeCommand(List<String> commandLineTokens) throws Exception {
        if(commandLineTokens.size()!=2)
            throw new Exception("volume Error, bad params on bob.conf");

        volume = commandLineTokens.get(1);
    }

    @Override
    public void execute(Map<String, String> programValues) {
        programValues.put("volume",volume);
    }
}
