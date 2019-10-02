public class Volume implements Command {
    private BobSetting settings;
    public Volume(){
        settings = (BobSetting) BobSetting.getInstance();
    }
    @Override
    public void execute(String args) {

    }
}
