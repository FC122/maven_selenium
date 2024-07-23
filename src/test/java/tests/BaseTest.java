package tests;

import config.Configs;
import utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public abstract class BaseTest {
  private WebDriver webDriver;
  protected Configs configs = Configs.getInstance();

  protected void initWebDriver(){//split this in two methods?
    switch ((String) Configs.getInstance().getProperty("browser")) {
      case "chrome" -> webDriver = BrowserFactory.createChromeDriver();
      case "firefox" -> webDriver = BrowserFactory.createFirefoxDriver();
      default -> Assert.fail("Missing setup for browser");
    }
  }

  public WebDriver getWebDriver(){
    return webDriver;
  }

  protected void maximizeWindow(){
    if(webDriver == null)
    {
      Assert.fail("Cant maximise window before driver is initialised");
    }
    webDriver.manage().window().maximize();
  }

  @AfterMethod
  public void close(){
    getWebDriver().quit();
  }
}
