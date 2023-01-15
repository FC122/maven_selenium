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
        if(locators.inputUsername.isDisplayed()) locators.inputUsername.sendKeys(username);
        if(locators.inputPassword.isDisplayed()) locators.inputPassword.sendKeys(password);
        if(locators.btnLogIn.isDisplayed()) locators.btnLogIn.click();
        if(!locators.wrpProducts.isDisplayed()) throw new RuntimeException("Products page not visible");
    }

}
