import java.util.HashMap;
import java.util.Map;

public class BobProgramValues {
    private boolean isWindows;
    private Map<String,String> environment;
    private char volume;
    private static BobProgramValues bobValues=null;

    private BobProgramValues() {
        volume = 'C';
        isWindows = whichOSisRunning();
        environment = new HashMap<>();
        setHomePath();
    }

    private void setHomePath() {
        String homePath = getExecutionPath();
        environment.put("home",homePath);
    }

    public String getExecutionPath() {
        return System.getProperty("user.dir");
    }

    private boolean whichOSisRunning() {
        return System.getProperty("os.name").contains("Windows");
    }

    public boolean isWindows() {
        return isWindows;
    }

    public char getVolume() {
        return volume;
    }

    public boolean containsDir(String dirName){
        return environment.containsKey(dirName);
    }
    public String getDirPath(String dirName){
        return environment.get(dirName);
    }


    public static BobProgramValues getBobProgramValues() {
        if(bobValues==null)
            bobValues = new BobProgramValues();

        return bobValues;
    }

    public void setNewDirectory(String dirName, String dirPath) {
        environment.put(dirName,dirPath);
    }
    public void setVolume(String volume){
        this.volume = volume.charAt(0);
    }


}
