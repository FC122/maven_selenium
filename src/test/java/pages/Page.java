package pages;

import utils.Content;
import org.openqa.selenium.WebDriver;

public abstract class Page {
  protected final WebDriver driver;
  protected Content content;
  private String contentFileName;

  public Page(final WebDriver driver, String contentFileName){
    this.driver = driver;
    this.contentFileName = contentFileName;
  }

  public Content getContent(){
    if (content == null) {
      content = new Content(contentFileName);
    }
    return content;
  }
}
