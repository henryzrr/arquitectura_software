import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BobConfParser {
    public static List<Instruction> getInstructions(List<String>lines,Set<String>valid_instructions,Set<String> directoryMethods) throws Exception{
        List<Instruction> instruction_list = new ArrayList<>();
        ParamInstructionParser param_parser = new ParamInstructionParser();
        for (String line:lines
             ) {
            String[]instruction_param=getInstruction(line);
            if(valid_instructions.contains(instruction_param[0])){
                Instruction instruction=null;
                switch (instruction_param[0]){
                    case "dir":
                        String[]dir_params=param_parser.getDirParams(instruction_param[1]);
                        instruction = new Dir();
                        instruction.set_instructionName(dir_params[0]);
                        ((Dir) instruction).setDirPath(dir_params[1]);
                        break;
                    case "print":
                        String []print_params = param_parser.getPrintParams(instruction_param[1],directoryMethods);
                        instruction =  new Print();
                        instruction.set_instructionName(print_params[0]);
                        ((Print) instruction).setObjectFunction(print_params[1]);
                        break;
                }
                instruction_list.add(instruction);
            }else{
                throw new  Exception("Instruccion ingresada en Bob.conf: "+instruction_param[0]+" no válida");
            }
        }
        return instruction_list;
    }

    private static String[]getInstruction(String line) throws Exception{
        StringTokenizer tokenizer = new StringTokenizer(line," ");
        String token1,token2;
        token1=tokenizer.nextToken();
        token2=tokenizer.nextToken();
        if(tokenizer.hasMoreTokens()){
            throw new Exception("Error en Bob.conf, la cadena despues de la instruccion no debe contener espacios");
        }
        return new String []{token1,token2};
    }
}
