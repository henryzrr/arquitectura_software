package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class BobConfCommandReader {
    private BufferedReader bufferedReader;
    BobConfCommandReader(String BOB_CONF_PATH) throws Exception{
        FileReader fileReader = new FileReader(BOB_CONF_PATH);
        bufferedReader = new BufferedReader(fileReader);
    }

    String readNextLine() throws IOException {
        return bufferedReader.readLine();
    }

}
