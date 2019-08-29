import java.util.Map;

public interface DirectoryInstruction {
    void setDirName(String name);
    void setDirInstruction(String instruction);
    void executeInstruction(Map<String, Directory> directories) throws Exception;

}
