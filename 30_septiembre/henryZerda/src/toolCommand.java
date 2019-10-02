public class toolCommand implements Command{
    private Settings systemSettings;

    public toolCommand(){
        systemSettings = Settings.getSettings();
    }

    @Override
    public void execute(String args) {

    }
}