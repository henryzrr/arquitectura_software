import java.util.List;
import java.util.Map;

public class ToolCommand implements Command{
    private List<String> commandAndParamList;
    private Map<String,Tool> tools;


    ToolCommand(List<String> commandAndParamList, Map<String, Tool> tools) {
        this.commandAndParamList = commandAndParamList;
        this.tools = tools;
    }

    @Override
    public void execute() throws Exception {
        String toolType = commandAndParamList.get(1);
        switch (toolType){
            case "compilador":
                newCompiler();
                break;
            case "empaquetador":
                newPacker();
                break;
            default:
                throw new Exception("tool error, Herramienta no soportada por el sistema");
        }

    }
    private void newCompiler()throws Exception{
        if(commandAndParamList.size()!=5){
            throw new Exception("tool error, error en la declaracion de tool compiler");
        }
        String compilerName = commandAndParamList.get(2);
        String inputFile = commandAndParamList.get(3);
        String outputFile = commandAndParamList.get(4);
        Tool compiler;
        if(compilerName.equals("javac"))
            compiler = new Javac(compilerName,inputFile,outputFile);
        else
            throw new Exception("tool error, herramienta no soportada: "+compilerName);
        tools.put(compilerName,compiler);
    }
    private void newPacker() throws Exception {
        if(commandAndParamList.size()!=5){
            throw new Exception("tool error, error en la declaracion de tool empaquetador");
        }

        String packerName = commandAndParamList.get(2);
        String inputFile = commandAndParamList.get(3);
        String outputFile = commandAndParamList.get(4);
        Tool packer;
        if(packerName.equals("jar")){
            packer = new Jar(packerName,inputFile,outputFile);
        }else{
            throw new Exception("tool error, herramienta no soportada "+packerName);
        }

        tools.put(packerName,packer);

    }
}
