package pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageLocators {
    private WebDriver driver;
    public LoginPageLocators(WebDriver driver){
        this.driver=driver;
    }

    public WebElement wrpLogin =driver.findElement(By.cssSelector(".login_wrapper"));
    public WebElement inputUsername = driver.findElement(By.cssSelector("input[placeholder=\"Username\"]"));
    public WebElement inputPassword = driver.findElement(By.cssSelector(("input[placeholder=\"Password\"]")));
    public WebElement btnLogIn = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
    public WebElement txtError = driver.findElement(By.cssSelector("div.error-message-container.error"));
    public WebElement wrpProducts=driver.findElement(By.id("page_wrapper"));
}