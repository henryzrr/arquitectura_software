import java.util.*;

public class DirInstructionInvoquer {
    Map<String,Directory> directories;

    public DirInstructionInvoquer(){
        directories=new HashMap<>();
    }
    public void executeInstruction(List<DirectoryInstruction> directoryInstructions) throws Exception {
        for (DirectoryInstruction i: directoryInstructions
             ) {
            i.executeInstruction(directories);
        }
    }


}
