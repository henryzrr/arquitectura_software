public class printCommand implements Command {
    private Settings systemSettings;
    private ToolManager toolManager;
    public printCommand(){
        systemSettings = Settings.getSettings();
    }
    @Override
    public void execute(String args) {

    }
}
