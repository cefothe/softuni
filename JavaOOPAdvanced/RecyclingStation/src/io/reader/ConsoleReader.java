package io.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class ConsoleReader implements  Reader {

    private BufferedReader bufferedReader;

    public ConsoleReader() {
        this.bufferedReader = new BufferedReader(
                new InputStreamReader(
                        System.in
                )
        );
    }

    @Override
    public String readLine() throws IOException {
        return this.bufferedReader.readLine();
    }
}
