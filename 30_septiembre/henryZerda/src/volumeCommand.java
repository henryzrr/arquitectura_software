public class volumeCommand implements Command {
    private Settings systemSettings;
    public volumeCommand(){
        systemSettings = Settings.getSettings();
    }
    @Override
    public void execute(String args) {

    }
}
