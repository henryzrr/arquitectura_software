import java.util.HashMap;
import java.util.Map;

public class Settings {
    private static Settings settings = new Settings();
    private Map<String,String> environment;
    private String volume;
    private boolean isWindows;

    private Settings(){
        environment = new HashMap<>();
        volume = "C";
        isWindows = defineOS();
        setHomeDefault();
    }

    private void setHomeDefault() {
        String executionPath = System.getProperty("user.dir");
        environment.put("home",executionPath);
    }

    private boolean defineOS() {
        return System.getProperty("os.name").contains("Windows");
    }
    public static Settings getSettings(){
        return settings;
    }
    public boolean isWindows(){
        return isWindows;
    }
    public String getVolume(){
        return volume;
    }
    public boolean dirIsDeclared(String dirName){
        return environment.containsKey(dirName);
    }
    public String getPath(String dirName){
        return environment.get(dirName);
    }
    public void setPath(String dirName, String dirPath){
        environment.put(dirName,dirPath);
    }
    public void SetVolume(String volume){
        this.volume = volume;
    }
}
