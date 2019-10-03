public class ToolTool implements Tool {
    private String name;
    private String args;
    private String in;
    private String out;

    public ToolTool(String name, String args, String in, String out) {
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
    public String getArgs() {
        return args;
    }

    @Override
    public String getIn() {
        return in;
    }

    @Override
    public String getOut() {
        return out;
    }
}
