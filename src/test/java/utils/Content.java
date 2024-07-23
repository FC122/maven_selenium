package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Content {
    private Properties properties;
    private final String propertyFilePath;

    public Content(String fileName) {
      properties = new Properties();
      propertyFilePath = String.format("%s/src/test/java/CONTENT/%s.properties", System.getProperty("user.dir"), fileName);
      BufferedReader reader;
      try {
        reader = new BufferedReader(new java.io.FileReader(propertyFilePath));
        try {
          properties.load(reader);
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      } catch (FileNotFoundException e) {
        e.printStackTrace();
        throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
      }
    }

    public <T> T byKey(String key){
      return (T) properties.getProperty(key);
    }
}