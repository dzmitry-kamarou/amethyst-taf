package ui.page;

import org.openqa.selenium.By;
import ui.Browser;

public class DashboardPage {

  private final String titleXpath = "//h1[text()='Dashboard']";
  private final String greetingXpath = "//p[starts-with(text(),'Welcome ')]";

  public boolean isVisible() {
    return Browser.getWebDriver().findElement(By.xpath(titleXpath)).isDisplayed();
  }

  public String greetingText() {
    return Browser.getWebDriver().findElement(By.xpath(greetingXpath)).getText();
  }
}
