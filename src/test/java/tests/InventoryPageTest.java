package tests;

import pages.InventoryPage;
import pages.ItemPage;
import pages.LoginPage;
import utils.Item;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class InventoryPageTest extends BaseTest {
  LoginPage loginPage;
  InventoryPage inventoryPage;

  @BeforeMethod
  public void setUp(){
    initWebDriver();
    maximizeWindow();
    loginPage = PageFactory.initElements(getWebDriver(),LoginPage.class);
    loginPage.logIn(configs.getProperty("username"), configs.getProperty("password"));
    inventoryPage = PageFactory.initElements(getWebDriver(), InventoryPage.class);
  }

  @Test(description = "Second Task")
  public void PrintItemData(){//2.1 zad
    for(Item item:inventoryPage.getItems()){
      System.out.println(item.toString());
    }
  }

  @Test(description = "Check lowest to highest sorting")
  public void HighToLowSortingTest(){//3. zad
    inventoryPage.productSortSelect.click();
    inventoryPage.highToLowOption.click();
    inventoryPage.refreshItemsData();
    List<Item> items = inventoryPage.getItems();
    for(int i = 0; i<items.size()-1;i++){
      Assert.assertTrue(items.get(i).getPrice()>=items.get(i+1).getPrice());
    }
  }

  @Test(description = "Check that user can add the item with the lowest price to cart")
  public void AddToCart() {// 4. zad
    List<Item> items = inventoryPage.getFreshItems();
    int minPriceIndex =0;
    double minPrice=items.get(minPriceIndex).getPrice();
    for(int i=1;i<items.size();i++){
      double price = items.get(i).getPrice();
      if(price<minPrice){
        minPrice=price;
        minPriceIndex = i;
      }
    }
    inventoryPage.addToCartButton(minPriceIndex).click();
    Assert.assertEquals(
      inventoryPage.addToCartButton(minPriceIndex).getText(),
      inventoryPage.getContent().byKey("removeButton")
    );
    Assert.assertEquals(inventoryPage.shoppingCartBadge.getText(),"1");
  }

  @Test(description = "Check that user can open item page and add 4th the item to cart")
  public void AddToCartFromItemPage() {// 5. zad
    inventoryPage.itemPageLink(3).click();
    ItemPage itemPage = PageFactory.initElements(getWebDriver(), ItemPage.class);
    itemPage.addToCartButton.click();
    Assert.assertEquals(
      itemPage.removeFromCartButton.getText(),
      inventoryPage.getContent().byKey("removeButton")
    );
    Assert.assertEquals(inventoryPage.shoppingCartBadge.getText(),"1");
  }

  @Test(description = "Check that user can log out")
  public void LogOut(){// 7. zad
    WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    inventoryPage.menuBurgerButton.click();
    wait.until(ExpectedConditions.visibilityOf(inventoryPage.logOutLink));//7.1 zad
    wait.until(ExpectedConditions.elementToBeClickable(inventoryPage.logOutLink));
    inventoryPage.logOutLink.click();
  }
}
