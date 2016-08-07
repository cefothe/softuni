package engine;



import io.reader.ConsoleReader;
import io.reader.Reader;
import io.writer.ConsoleWriter;
import io.writer.Writer;

import java.io.IOException;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class Engine implements EngineInterface {

    private Reader consoleReader;

    private Writer consoleWriter;

    private Boolean isRunning;

    public Engine(){
        this.consoleReader = new ConsoleReader();
        this.consoleWriter = new ConsoleWriter();
    }

    @Override
    public void run() throws IOException {
        this.isRunning = true;

        while (this.isRunning) {

            String inputLine = this.consoleReader.readLine();

            this.processInput(inputLine);
        }
    }

    private void processInput(String input) {

    }
}
