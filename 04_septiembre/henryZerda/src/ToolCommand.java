import java.util.List;
import java.util.Map;

public class ToolCommand implements Command{
    private List<String> commandAndParamList;
    private Map<String,Compiler> compilers;
    private Map<String,String> systemValues;

    ToolCommand(List<String> commandAndParamList, Map<String, Compiler> compilers, Map<String, String> systemValues) {
        this.commandAndParamList = commandAndParamList;
        this.compilers = compilers;
        this.systemValues = systemValues;
    }

    @Override
    public void execute() throws Exception {
        switch (commandAndParamList.get(1)){
            case "compilador":
                newCompiler();
                break;
            default:
                throw new Exception("tool error, Herramienta no soportada por el sistema");
        }

    }
    private void newCompiler()throws Exception{
        if(commandAndParamList.size()!=5){
            throw new Exception("tool error, error en la declaracion de tool compiler");
        }
        Compiler compiler = new Compiler(commandAndParamList.get(2),commandAndParamList.get(3),commandAndParamList.get(4));
        systemValues.put(commandAndParamList.get(2),"compilador");
        compilers.put(commandAndParamList.get(2),compiler);
    }
}
