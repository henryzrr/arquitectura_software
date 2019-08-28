import java.util.*;

public class DirInstructionInvoquer {
    Map<String,Directory> directories;
    Set<String>directory_methods;
    public DirInstructionInvoquer(){
        directories=new HashMap<>();
        directory_methods = new HashSet<>();
        directory_methods.add("files");
        directory_methods.add("directories");
    }
    public void executeInstruction(List<Instruction> instructions){
        for (Instruction i:instructions
             ) {
            if()
        }
    }


    private void doInstruction(Print p){

    }
    private void doInstruction(Dir d){

    }


    public Set<String> getDirectory_methods() {
        return directory_methods;
    }
}
