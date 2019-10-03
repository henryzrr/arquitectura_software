public class Volume implements Command {
    private Settings settings;

    public Volume(){
        settings = BobSetting.getInstance();
    }
    @Override
    public void execute(String args) {
        try{
            char volume = getCharVolume(args);
            settings.setVolume(volume);
        }catch (Exception e){
            System.err.println("Error on execute method in Volume");
            e.printStackTrace();
            System.exit(1);
        }

    }

    private char getCharVolume(String args) throws Exception {
        args = args.replaceAll(" ","");
        if(args.length()>1){
            throw  new Exception("Error on execute method, bar params for volume");
        }
        return args.charAt(0);
    }
}
