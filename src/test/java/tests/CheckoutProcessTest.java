package tests;

import pages.*;
import utils.Helpers;
import utils.Item;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutProcessTest extends BaseTest {
  LoginPage loginPage;
  InventoryPage inventoryPage;
  CartPage cartPage;

  @BeforeMethod
  public void setUp(){
    initWebDriver();
    maximizeWindow();
    loginPage = PageFactory.initElements(getWebDriver(),LoginPage.class);
    loginPage.logIn(configs.getProperty("username"), configs.getProperty("password"));
    inventoryPage = PageFactory.initElements(getWebDriver(), InventoryPage.class);
    cartPage = PageFactory.initElements(getWebDriver(), CartPage.class);
  }

  @Test(description = "Check that checkout is only showing selected item")
  public void CartSelectedItem(){
    Item inventoryItem = inventoryPage.getItems().get(0);
    inventoryPage.addToCartButton(0).click();
    inventoryPage.shoppingCartLink.click();

    Double cartItemPrice = Helpers.extractDouble(cartPage.itemPrice.getText());
    Assert.assertEquals(inventoryItem.getPrice(),cartItemPrice);
    Assert.assertEquals(inventoryItem.getDescription(),cartPage.itemDescription.getText());
    Assert.assertEquals(inventoryItem.getName(),cartPage.itemName.getText());
  }

  @Test(description = "Check that total sum is correct")
  public void CartTotalSum(){
    inventoryPage.addToCartButton(0).click();
    inventoryPage.shoppingCartLink.click();

    Double cartItemPrice = Helpers.extractDouble(cartPage.itemPrice.getText());
    cartPage.checkoutButton.click();

    CheckoutStepOnePage checkoutStepOnePage = PageFactory.initElements(getWebDriver(), CheckoutStepOnePage.class);
    checkoutStepOnePage.fillInformationForm("STName", "STLastName", "30000");

    CheckoutStepTwoPage checkoutStepTwoPage = PageFactory.initElements(getWebDriver(), CheckoutStepTwoPage.class);
    Double expectedSum = Helpers.extractDouble(checkoutStepTwoPage.taxLabel.getText())+cartItemPrice;
    Double actualSum = Helpers.extractDouble(checkoutStepTwoPage.totalLabel.getText());

    Assert.assertEquals(expectedSum, actualSum);
  }
}
