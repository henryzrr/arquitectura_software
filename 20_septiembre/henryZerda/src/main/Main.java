package main;

public class Main {
    public static void main(String [] args) {
        try {
            BobProgramPreparer bobPreparer = new BobProgramPreparer();
            bobPreparer.startProgram();
        }catch (Exception e){
            System.err.println("Fatal Error, el programa bob dejo de funcionar");
            e.printStackTrace();
        }

    }
}
