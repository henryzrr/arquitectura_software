package main;

public class Main {
    public static void main(String [] args) {
        try {
            String BOB_CONF_PATH="src/configure/bob.conf";
            BobProgramPreparer bobPreparer = new BobProgramPreparer(BOB_CONF_PATH);
            bobPreparer.startProgram();
        }catch (Exception e){
            System.err.println("Fatal Error, el programa bob dejo de funcionar");
            e.printStackTrace();
        }

    }
}
