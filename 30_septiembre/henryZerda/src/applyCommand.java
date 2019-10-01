public class applyCommand implements Command {
    private  Settings systemSettings;

    public  applyCommand(){
        systemSettings = Settings.getSettings();
    }
    @Override
    public void execute(String args) {

    }
}
