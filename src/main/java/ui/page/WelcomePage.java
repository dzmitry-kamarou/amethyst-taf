package ui.page;

import org.openqa.selenium.By;
import ui.Browser;

public class WelcomePage {

  private final String loginLinkXpath = "//a[text()='Login']";
  private final String registerLinkXpath = "//a[text()='Register']";

  public LoginPage clickLoginLink() {
    Browser.getWebDriver().findElement(By.xpath(loginLinkXpath)).click();
    return new LoginPage();
  }

  public LoginPage clickRegisterLink() {
    Browser.getWebDriver().findElement(By.xpath(registerLinkXpath)).click();
    return new LoginPage();
  }
}
