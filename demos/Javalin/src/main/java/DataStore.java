import java.util.HashMap;
import java.util.Map;

public class DataStore {
    private static Map<String, Object> dataStore = new HashMap<>();

    public static void storeObject(String name, Object obj) {
        dataStore.put(name, obj);
    }

    public static Object getObject(String name) {
        return dataStore.get(name);
    }
}
