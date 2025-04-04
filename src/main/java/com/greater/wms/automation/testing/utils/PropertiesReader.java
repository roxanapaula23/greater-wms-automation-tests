package com.greater.wms.automation.testing.utils;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class PropertiesReader {

    private final Map<String, Object> properties;

    public PropertiesReader(String fileName) {
        Yaml yaml = new Yaml();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (in != null) {
                properties = yaml.load(in);
            } else {
                throw new RuntimeException("File not found: " + fileName);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read YAML file: " + fileName, e);
        }
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }
}
