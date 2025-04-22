package util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ExtractString {
    private static final Map<String, ResourceBundle> bundles = new HashMap<>();

    static {
        bundles.put("pageText", ResourceBundle.getBundle("properties.pageText"));
        bundles.put("locators", ResourceBundle.getBundle("properties.locators"));
    }

    public static String getString(String fileKey, String value) {
        ResourceBundle bundle = bundles.get(fileKey);
        if (bundle != null && bundle.containsKey(value)) {
            return bundle.getString(value);
        } else {
            throw new RuntimeException("Key '" + value + "' not found in '" + fileKey + "' properties.");
        }
    }
}
