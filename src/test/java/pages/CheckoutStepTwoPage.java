package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends Page{
  public CheckoutStepTwoPage(WebDriver driver){super(driver, "CheckoutStepTwoPage");}

  @FindBy(css="[data-test=\"tax-label\"]")
  public WebElement taxLabel;

  @FindBy(css="[data-test=\"total-label\"]")
  public WebElement totalLabel;

}
