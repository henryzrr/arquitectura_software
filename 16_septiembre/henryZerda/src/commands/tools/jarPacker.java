package commands.tools;

import main.Directory;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class jarPacker implements IPacker {
    private Directory directory;
    private String homePath;
    private ProcessBuilder processBuilder;
    public jarPacker(Directory directory, String homePath) {
        this.directory = directory;
        this.homePath = homePath;
        processBuilder = initializeProcessBuilder();

    }

    private ProcessBuilder initializeProcessBuilder() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        File executionDir = new File(directory.pathToString());
        processBuilder.directory(executionDir);
        return processBuilder;
    }

    @Override
    public void startPacking() throws Exception {
        Iterator<String> fileIterator = directory.getEspecificFileTypeWithRelativePah(".class");
        List<String> command = prepareJarCommand();
        while (fileIterator.hasNext()){
            command.add(fileIterator.next());
        }
        processBuilder.command(command);
        processBuilder.start();
    }

    private List<String> prepareJarCommand() {
        List<String>command = new LinkedList<>();
        command.add("jar");
        command.add("-cfe");
        command.add("program.jar");
        command.add("Main");
        return command;
    }
}
