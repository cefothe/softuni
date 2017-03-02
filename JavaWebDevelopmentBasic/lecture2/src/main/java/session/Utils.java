package session;

import java.io.*;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Utils {
    private static boolean isPost() {
        String requestMethod = System.getProperty("cgi.request_method");
        boolean isPost = false;
        if (requestMethod.equals("post") || requestMethod.equals("POST")) {
            isPost = true;
        }

        return isPost;
    }

    public static Map<String, String> getParameters(InputStream inputStream) throws IOException {
        Map<String, String> parametersMap = new LinkedHashMap();
        String inBuffer;
        if (isPost()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            inBuffer = br.readLine();
        } else {
            inBuffer = System.getProperty("cgi.query_string");
        }

        StringTokenizer parameters = new StringTokenizer(inBuffer, "&");
        while (parameters.hasMoreTokens()) {
            String pair = parameters.nextToken();
            StringTokenizer pairs = new StringTokenizer(pair, "=");
            while (pairs.hasMoreTokens()) {
                String key = pairs.nextToken();
                String value = URLDecoder.decode(pairs.nextToken(), "UTF-8");
                parametersMap.put(key, value);
            }
        }

        return parametersMap;
    }
}
