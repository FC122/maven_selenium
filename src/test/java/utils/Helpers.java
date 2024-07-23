package utils;

import org.testng.Assert;

public class Helpers {
  public static double extractDouble(String stringWithDollars){
    int dollarIndex = stringWithDollars.indexOf("$");
    if (dollarIndex == -1) {
      Assert.fail("Dollar sign not found in given string");
    }
    return Double.parseDouble(stringWithDollars.substring(dollarIndex+1));
  }
}
