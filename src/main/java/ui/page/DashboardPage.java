package ui.page;

import org.openqa.selenium.By;
import ui.Browser;

public class DashboardPage {

  private final String logoutLinkXpath = "//a[@id='logout']";
  private final String greetingXpath = "//p[starts-with(text(),'Welcome ')]";

  public void clickLogOutLink() {
    Browser.getWebDriver().findElement(By.xpath(logoutLinkXpath)).click();
  }

  public String greetingText() {
    return Browser.getWebDriver().findElement(By.xpath(greetingXpath)).getText();
  }
}
