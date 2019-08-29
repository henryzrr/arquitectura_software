import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bob {
    private static Set<String>validInstruction;
    private static Set<String>directoryMethods;
    public static void main(String []args) {
        setValidInstruction();
        setDirectoryMethods();
        String BOB_PATH="configure/bob.conf";
        try {
            List<String>lines = Reader.readFile(BOB_PATH);
            List<DirectoryInstruction>instructions = BobConfParser.getInstructions(lines,validInstruction,directoryMethods);
            DirInstructionInvoquer dirInvoker = new DirInstructionInvoquer();
            dirInvoker.executeInstruction(instructions);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    private static void setValidInstruction(){
        validInstruction = new HashSet<>();
        validInstruction.add("dir");
        validInstruction.add("print");
    }
    private static void setDirectoryMethods(){
        directoryMethods = new HashSet<>();
        directoryMethods.add("files");
        directoryMethods.add("directories");
    }

}
