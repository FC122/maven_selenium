package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends Page {
  public ItemPage(final WebDriver driver){
    super(driver, "ItemPage");
  }

  @FindBy(css="[data-test=\"add-to-cart\"]")
  public WebElement addToCartButton;

  @FindBy(css="[data-test=\"remove\"]")
  public WebElement removeFromCartButton;
}
