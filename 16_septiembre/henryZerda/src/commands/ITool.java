package commands;

import main.Directory;

import java.util.Iterator;
import java.util.Map;

public interface ITool {

    void applyTool(Map<String, String> programValues, String dirCallFunction) throws Exception;
}
