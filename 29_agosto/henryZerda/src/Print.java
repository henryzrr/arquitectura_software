public class Print implements Instruction{
    String objectName;
    String objectFunction;
    public Print(){
        objectName=null;
        objectFunction=null;
    }

    @Override
    public void set_instructionName(String name) {
        objectName=name;
    }

    @Override
    public String getInstructionName() {
        return objectName;
    }

    public void setObjectFunction(String objectFunction) {
        this.objectFunction = objectFunction;
    }

    public String getObjectFunction() {
        return objectFunction;
    }
}
