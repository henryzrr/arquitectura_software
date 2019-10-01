public class dirCommand implements Command {
    private Settings systemSettings;
    public dirCommand(){
        systemSettings = Settings.getSettings();
    }

    @Override
    public void execute(String args) {

    }
}
