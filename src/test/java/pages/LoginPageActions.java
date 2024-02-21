package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.Debug;
import pageLocators.LoginPageLocators;

import java.util.logging.Logger;

public class LoginPageActions {

    WebDriver driver;
    LoginPageLocators locators;
    public LoginPageActions(WebDriver driver){
        this.driver=driver;
        locators = new LoginPageLocators(driver);
    }
    public void logIn(String username, String password){
        locators.inputUsername.sendKeys(username);
        locators.inputPassword.sendKeys(password);
        ilocators.btnLogIn.click();
    }
}