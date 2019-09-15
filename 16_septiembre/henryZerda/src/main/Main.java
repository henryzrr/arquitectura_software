package main;

public class Main {
    public static void main(String [] args) throws Exception {
        String BOB_CONF_PATH="src/configure/bob.conf";
        BobProgramPreparer bobPreparer = new BobProgramPreparer(BOB_CONF_PATH);
        bobPreparer.startProgram();
    }
}
