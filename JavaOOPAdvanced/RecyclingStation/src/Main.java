import engine.Engine;
import engine.EngineInterface;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        EngineInterface engine = new Engine();
        engine.run();
    }
}
