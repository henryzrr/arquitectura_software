package commands.toolAndApply.tools.packer;

import main.Directory;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class javaPacker implements IPacker {
    private Directory directory;
    private ProcessBuilder processBuilder;
    private String toolInstruction;
    private String fileType1;
    private String fileType2;


    public javaPacker(Directory directory, String toolInstruction, String fileType1, String fileType2) {
        this.toolInstruction = toolInstruction;
        this.fileType1 = fileType1;
        this.fileType2 = fileType2;
        this.directory = directory;
        this.processBuilder = initializeProcessBuilder();
    }

    private ProcessBuilder initializeProcessBuilder() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        File executionDir = new File(directory.pathToString());
        processBuilder.directory(executionDir);
        return processBuilder;
    }

    @Override
    public void startPacking() throws Exception {
        Iterator<String> fileIterator = directory.getEspecificFileTypeWithRelativePah("."+fileType1);
        List<String> command = prepareJarCommand();
        while (fileIterator.hasNext()){
            command.add(fileIterator.next());
        }
        processBuilder.command(command);
        processBuilder.start();
    }

    private List<String> prepareJarCommand() {
        List<String>command = new LinkedList<>();
        String [] toolTokens = toolInstruction.split(" ");
        command.addAll(Arrays.asList(toolTokens));
        return command;
    }
}
