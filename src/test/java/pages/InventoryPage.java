package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.Helpers;
import utils.Item;

public class InventoryPage extends Page {
  private List<Item> items;

  public InventoryPage(final WebDriver driver){
    super(driver, "InventoryPage");
  }

  @FindBy(css="[data-test=\"product-sort-container\"]")
  public WebElement productSortSelect;

  @FindBy(css="[value=\"hilo\"]")
  public WebElement highToLowOption;

  @FindBy(css="[data-test=\"shopping-cart-badge\"]")
  public WebElement shoppingCartBadge;

  @FindAll(@FindBy(css="[data-test='inventory-item']"))
  public List<WebElement> inventoryItems;

  @FindBy(css="[data-test=\"shopping-cart-link\"]")
  public WebElement shoppingCartLink;

  @FindBy(how=How.ID, using = "react-burger-menu-btn")
  public WebElement menuBurgerButton;

  @FindBy(how=How.ID, using = "logout_sidebar_link")
  public WebElement logOutLink;

  public WebElement addToCartButton(int index){
    return inventoryItems.get(index).findElement(new By.ByClassName("btn_inventory"));
  }

  public WebElement itemPageLink(int index){
    return inventoryItems.get(index).findElement(itemName);
  }

  By itemName = By.cssSelector("[data-test=\"inventory-item-name\"]");
  By itemDescription = By.cssSelector("[data-test=\"inventory-item-desc\"]");
  By itemPrice = By.cssSelector("[data-test=\"inventory-item-price\"]");
  By itemImageUrl = By.cssSelector("img.inventory_item_img");

  public List<Item> getFreshItems(){
    items = new ArrayList<>();
    for(WebElement webElement:inventoryItems){
      items.add(ConstructItemFromWebElement(webElement));
    }
    return items;
  }

  public Item ConstructItemFromWebElement(WebElement webElement){
    return new Item(
      webElement.findElement(itemName).getText(),
      webElement.findElement(itemDescription).getText(),
      Helpers.extractDouble(webElement.findElement(itemPrice).getText()),
      webElement.findElement((itemImageUrl)).getAttribute("src")
    );
  }

  public List<Item> getItems(){
    if(items==null) {
      items = getFreshItems();
    }
    return items;
  }

  public void refreshItemsData(){
    items = getFreshItems();
  }
}
