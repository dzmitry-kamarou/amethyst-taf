package ui.page;

import org.openqa.selenium.By;
import ui.Browser;

public class DashboardPage extends BasePage {

  private final String logoutLinkXpath = "//a[@id='logout']";
  private final String greetingXpath = "//p[starts-with(text(),'Welcome ')]";

  public void clickLogOutLink() {
    logger.debug("Click 'logout' link");
    Browser.getWebDriver().findElement(By.xpath(logoutLinkXpath)).click();
  }

  public String greetingText() {
    logger.debug("Grab 'greeting' text");
    return Browser.getWebDriver().findElement(By.xpath(greetingXpath)).getText();
  }
}
