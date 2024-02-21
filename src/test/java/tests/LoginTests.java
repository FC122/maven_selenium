package tests;

import config.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageLocators.LoginPageLocators;
import pages.LoginPageActions;

public class LoginTests {
    public WebDriver driver;
    public LoginPageLocators locators;
    public LoginPageActions actions;
    public ConfigFileReader configs = new ConfigFileReader();
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver",configs.getDriverPath());
        driver = new ChromeDriver();
        locators = new LoginPageLocators(driver);
        actions = new LoginPageActions(driver);
        driver.navigate().to(configs.getApplicationUrl());
    }
    @Test
    public void checkIfRegisteredUserCanLogIn() throws InterruptedException {
        actions.logIn(configs.getStandardUsername(),configs.getPassword());
    }
    @Test
    public void checkIfRegisteredUserCanLogInWithUpercaseUsername() throws InterruptedException {
        actions.logIn(configs.getStandardUsername().toUpperCase(), configs.getPassword());
    }
    @Test
    public void checkValidationForLoggingInWithEmptyInputs() throws InterruptedException {
        if(locators.btnLogIn.isDisplayed()) locators.btnLogIn.click();
        if(locators.txtError.isDisplayed()) Assert.assertEquals(locators.txtError.getText(),configs.getUsernameRequiredErrorTxt());
    }
    @Test
    public void checkValidationForLoggingInWithJustUsername() throws InterruptedException {
        if(locators.inputUsername.isDisplayed()) locators.inputUsername.sendKeys(configs.getStandardUsername());
        if(locators.btnLogIn.isDisplayed()) locators.btnLogIn.click();
        if(locators.txtError.isDisplayed()) Assert.assertEquals(locators.txtError.getText(),configs.getPasswordRequiredErrorTxt());
    }
    @Test
    public void checkValidationForLoggingInWithJustPassword() throws InterruptedException {
        if(locators.inputPassword.isDisplayed()) locators.inputPassword.sendKeys(configs.getPassword());
        if(locators.btnLogIn.isDisplayed()) locators.btnLogIn.click();
        if(locators.txtError.isDisplayed()) Assert.assertEquals(locators.txtError.getText(),configs.getUsernameRequiredErrorTxt());
    }
    @AfterMethod
    public void teardownTest() {

        driver.quit();
    }
}
