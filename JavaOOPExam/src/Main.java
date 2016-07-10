import com.cefothe.exam.system.split.SplitSystem;
import com.cefothe.exam.system.split.factory.HardwareFactory;
import com.cefothe.exam.system.split.factory.SoftwareFactory;
import com.cefothe.exam.system.split.hardware.Hardware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.cefothe.exam.system.split.common.Configuration.*;
import static java.lang.System.in;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        in
                )
        );

        SplitSystem system = new SplitSystem();

        String line;
        while (!(line = reader.readLine()).equals(SYSTEM_SPLIT)) {
            parseCommand(line, system);
        }
        system.systemSplit();
    }

    private static void parseCommand(String line, SplitSystem system) {

        if(line.contains("Analyze")){
            system.systemAnalysis();
        }
        else if(line.trim() != ""){
            Pattern pattern = Pattern.compile("\\w+");
            String[] comand = line.split("\\(");
            Matcher matcher = pattern.matcher(comand[1]);
            List<String> homeArgs = parseHomeArguments(comand[0], matcher);

            if(line.contains(RELEASE_SOFTWARE)){
                system.releaseSoftware(homeArgs);
            }
            else if (line.contains(HARDWARE)) {
                system.addHardware(HardwareFactory.F.createHardware(homeArgs));
            } else if (line.contains(SOFTWARE)) {
                Hardware hardware = system.getHardware(homeArgs.get(1));
                if (hardware != null) {
                    hardware.addSoftware(SoftwareFactory.F.createSoftware(homeArgs));
                }
            }
        }
    }

    private static List<String> parseHomeArguments(String command, Matcher matcher) {
        List<String> homeArgs = new ArrayList<>();
        homeArgs.add(command);

        while (matcher.find()) {
            homeArgs.add(matcher.group());
        }

        return homeArgs;
    }
}
