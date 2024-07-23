package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import config.Configs;

public class LoginPage extends Page {
  public LoginPage(final WebDriver driver){
    super(driver, "LoginPage");
  }

  @FindBy(css = "[data-test=\"username\"]")
  public WebElement usernameInputField;

  @FindBy(css = "[data-test=\"password\"]")
  public WebElement passwordInputField;

  @FindBy(css= "[data-test=\"login-button\"]")
  public WebElement loginButton;

  @FindBy(css = "[data-test=\"error\"]")
  public  WebElement errorNotification;

  public void logIn(final String username, final String password){// 1. zad
    driver.get(Configs.getInstance().getProperty("baseUrl"));
    usernameInputField.sendKeys(username);
    passwordInputField.sendKeys(password);
    loginButton.click();
  }
}