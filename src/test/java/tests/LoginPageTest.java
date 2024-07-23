package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.InventoryPage;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
  LoginPage loginPage;
  @BeforeMethod
  public void setUp(){
    initWebDriver();
    maximizeWindow();
    loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
  }

  @Test(description="Check that user cant log in with non existing username")
  public void WrongUsernameTest(){ //1.1 zad
    loginPage.logIn("STWrongUsername", configs.getProperty("password"));
    Assert.assertEquals(loginPage.getContent().byKey("errorWrongUsernameOrPassword"), loginPage.errorNotification.getText());
  }

  @Test(description = "Check that user cant login with the wrong password")
  public void WrongPasswordTest(){ //1.2 zad
    loginPage.logIn(configs.getProperty("username"), "STWrongPassword");
    Assert.assertEquals(loginPage.getContent().byKey("errorWrongUsernameOrPassword"),loginPage.errorNotification.getText());
  }

  @Test(description = "Check that user can log in")
  public void SuccessfulLoginTest(){ //1.3
    InventoryPage inventoryPage = PageFactory.initElements(getWebDriver(),InventoryPage.class);
    loginPage.logIn(configs.getProperty("username"), configs.getProperty("password"));
    Assert.assertEquals(getWebDriver().getCurrentUrl(),configs.getProperty("baseUrl")+(String)inventoryPage.getContent().byKey("url"));
  }
}
