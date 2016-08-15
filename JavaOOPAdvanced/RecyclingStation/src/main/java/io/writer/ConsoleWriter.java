package io.writer;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class ConsoleWriter implements  Writer {
    @Override

    public void writeLine(String line) {
        System.out.println(line);
    }
}
