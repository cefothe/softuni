package server;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cefothe on 04.03.17.
 */
public class Model {
    private Map<String,Object> objects;

    public Model() {
        this.objects = new HashMap<>();
    }

    public void add(String key, Object value){
        this.objects.put(key, value);

    }

    public Object get(String key){
        return  objects.get(key);
    }
}
