import java.util.List;
import java.util.Map;

public class ApplyCommand implements Command{
    private List<String> commandAndParamList;
    private Map<String, String> systemValues;
    private Map<String,Compiler> compilers;

    ApplyCommand(List<String> commandAndParamList, Map<String, String> systemValues, Map<String, Compiler> compilers) {
        this.commandAndParamList = commandAndParamList;
        this.systemValues = systemValues;
        this.compilers = compilers;
    }

    @Override
    public void execute() throws Exception {
        int applyArguments = commandAndParamList.size();
        if(applyArguments<2)
            throw new Exception("apply error, instruccion mal declarada");
        if(!systemValues.containsKey(commandAndParamList.get(1)))
            throw new Exception("apply error, herramienta no soportada por el sistema");

        switch (systemValues.get(commandAndParamList.get(1))){
            case "compilador":
                startCompilation(applyArguments);
                break;
            case "otro1":
                break;
        }

    }
    private void startCompilation(int argumentsNumber)throws Exception{
        if(argumentsNumber!=3)
            throw new Exception("apply error, instruccion mal declarada");
        Compiler compiler = compilers.get(commandAndParamList.get(1));
        compiler.execCompilation(commandAndParamList.get(2),systemValues);
    }



}
