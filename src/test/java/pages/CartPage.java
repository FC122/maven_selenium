package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends Page {
  public CartPage(final WebDriver driver){super(driver, "CartPage");}

  @FindAll(@FindBy(css="[data-test='inventory-item']"))
  public List<WebElement> cartItems;

  @FindBy(css="[data-test=\"checkout\"]")
  public WebElement checkoutButton;

  @FindBy(css="[data-test=\"inventory-item-name\"]")
  public WebElement itemName;

  @FindBy(css="[data-test=\"inventory-item-desc\"]")
  public WebElement itemDescription;

  @FindBy(css="[data-test=\"inventory-item-price\"]")
  public  WebElement itemPrice;
}
