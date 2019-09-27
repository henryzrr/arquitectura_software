import java.util.List;

class VolumeCommand implements ICommand {

    private String volume;
    private BobProgramValues bobProgramValues;
    VolumeCommand(List<String> commandLineTokens, BobProgramValues bobProgramValues) throws Exception {
        initializeVolumeCommand(commandLineTokens);
        this.bobProgramValues=bobProgramValues;
    }

    private void initializeVolumeCommand(List<String> commandLineTokens) throws Exception {
        VolumeCommandParser volumeCommandParser = new VolumeCommandParser(commandLineTokens);
        commandLineTokens = volumeCommandParser.getValidTokens();
        volume = commandLineTokens.get(0);
    }

    @Override
    public void execute() {
        bobProgramValues.setVolume(volume);
    }
}
