import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class BobConfParser {
    static List<DirectoryInstruction> getInstructions(List<String> lines, Set<String> valid_instructions, Set<String> directoryMethods) throws Exception{
        List<DirectoryInstruction> directoryInstruction_list = new ArrayList<>();
        ParamInstructionParser param_parser = new ParamInstructionParser();
        for (String line:lines
             ) {
            String[]instruction_param=getInstruction(line);
            String[]dir_instruction=null;
            if(valid_instructions.contains(instruction_param[0])){
                DirectoryInstruction directoryInstruction =null;
                switch (instruction_param[0]){
                    case "dir":
                        dir_instruction=param_parser.getDirParams(instruction_param[1]);
                        directoryInstruction = new Dir();
                        break;
                    case "print":
                        dir_instruction = param_parser.getPrintParams(instruction_param[1],directoryMethods);
                        directoryInstruction =  new Print();
                        break;
                }
                assert directoryInstruction != null;
                directoryInstruction.setDirName(dir_instruction[0]);
                directoryInstruction.setDirInstruction(dir_instruction[1]);
                directoryInstruction_list.add(directoryInstruction);
            }else{
                throw new  Exception("Instruccion ingresada en Bob.conf: "+instruction_param[0]+" no válida");
            }
        }
        return directoryInstruction_list;
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
