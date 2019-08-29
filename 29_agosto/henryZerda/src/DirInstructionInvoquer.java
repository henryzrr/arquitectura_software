import java.util.*;

class DirInstructionInvoquer {
    private Map<String,Directory> directories;

    DirInstructionInvoquer(){
        directories=new HashMap<>();
    }
    void executeInstruction(List<DirectoryInstruction> directoryInstructions) throws Exception {
        for (DirectoryInstruction i: directoryInstructions
             ) {
            i.executeInstruction(directories);
        }
    }


}
