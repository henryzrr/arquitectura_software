public class ToolObjectManager implements ToolObject {
    private String name;
    private String args;
    private String in;
    private String out;

    public ToolObjectManager(String name, String args, String in, String out) {
        this.name = name;
        this.args = args;
        this.in = in;
        this.out = out;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFullCommandCall() {
        return args;
    }

    @Override
    public String getInputFileType() {
        return in;
    }

    @Override
    public String getOutputFileType() {
        return out;
    }
}
