import java.util.List;
import java.util.Map;

public class ToolCommand implements ICommand {
    private List<String> commandAndParamList;
    private Map<String, ITool> tools;


    ToolCommand(List<String> commandAndParamList, Map<String, ITool> tools) {
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
        ITool compiler;
        if(compilerName.equals("javac"))
            compiler = new JavacTool(compilerName,inputFile);
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
        ITool packer;
        if(packerName.equals("jar")){
            packer = new JarTool(packerName,inputFile,outputFile);
        }else{
            throw new Exception("tool error, herramienta no soportada "+packerName);
        }

        tools.put(packerName,packer);

    }
}
