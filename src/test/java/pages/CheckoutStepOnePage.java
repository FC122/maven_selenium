package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends Page{
  public CheckoutStepOnePage(WebDriver driver){super(driver, "CheckoutStepOnePage");}
  @FindBy(css = "[data-test='firstName']")
  public WebElement firstNameInput;

  @FindBy(css = "[data-test='lastName']")
  public WebElement lastNameInput;

  @FindBy(css = "[data-test='postalCode']")
  public WebElement postalCodeInput;

  @FindBy(css = "[data-test=\"continue\"]")
  public WebElement continueButton;

  public void fillInformationForm(String firstName, String lastName, String postalCode) {
    firstNameInput.sendKeys(firstName);
    lastNameInput. sendKeys(lastName);
    postalCodeInput.sendKeys(postalCode);
    continueButton.click();
  }
}
