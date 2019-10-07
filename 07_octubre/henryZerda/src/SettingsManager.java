import java.util.HashMap;
import java.util.Map;

public class SettingsManager implements Settings {

    private static Settings settings = new SettingsManager();
    private Map<String,String>environment;
    private char volume;
    private boolean isUnix;

    private SettingsManager(){
        volume = 'C';
        isUnix = discoverOS();
        environment = new HashMap<>();
    }
    private boolean discoverOS(){
        return !System.getProperty("os.name").contains("Windows");
    }
    @Override
    public String getDir(String key) {
        return environment.get(key);
    }

    @Override
    public boolean isUnix() {
        return isUnix;
    }

    @Override
    public char getVolume() {
        return volume;
    }

    @Override
    public void setVolume(char vol) {
        volume=vol;
    }

    @Override
    public void setDir(String key, String path) {
        environment.put(key,path);
    }

    @Override
    public boolean exists(String key) {
        return environment.containsKey(key);
    }
    public static Settings getInstance(){
        return settings;
    }
}
