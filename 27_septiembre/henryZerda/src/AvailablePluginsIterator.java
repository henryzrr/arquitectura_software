import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AvailablePluginsIterator implements Iterable<String>,Iterator<String> {
    private List<String> availablePlugins;
    private Iterator<String>it;
    public AvailablePluginsIterator(){
        availablePlugins  = new LinkedList<>();
        addPlugins();
        it = availablePlugins.iterator();
    }

    private void addPlugins() {

        availablePlugins.add("ToolPluginInterface");
        availablePlugins.add("VolumePluginInterface");
        availablePlugins.add("ApplyPluginInterface");
        availablePlugins.add("DirPluginInterface");
        availablePlugins.add("PrintPluginInterface");
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }


    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public String next() {
        return it.next();
    }
}
