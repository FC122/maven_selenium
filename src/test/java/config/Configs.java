package config;

import java.io.*;
import java.util.Properties;

public class Configs {
  private static Configs instance;
  private Properties properties = new Properties();
  private final String propertyFilePath = System.getProperty("user.dir") + "/src/test/java/config/Configuration.properties";

  private Configs() {
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(propertyFilePath));
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

  public static Configs getInstance() {
    if (instance == null) {
      synchronized (Configs.class) {
        if (instance == null) {
          instance = new Configs();
        }
      }
    }
    return instance;
  }

  public <T> T getProperty(String key){
    return (T) properties.getProperty(key);
  }
}
