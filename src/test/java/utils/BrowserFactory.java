package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

public class BrowserFactory {
  public static WebDriver createChromeDriver(){
    LoggingPreferences logs = new LoggingPreferences();
    logs.enable(LogType.BROWSER, Level.SEVERE);
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setCapability(ChromeOptions.LOGGING_PREFS, logs);
    return new ChromeDriver(chromeOptions);
  }

  public static WebDriver createFirefoxDriver(){
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    firefoxOptions.setLogLevel(FirefoxDriverLogLevel.FATAL);
    return new FirefoxDriver(firefoxOptions);
  }
}
