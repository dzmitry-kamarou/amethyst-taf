package ui.page;

import org.openqa.selenium.By;
import ui.Browser;

public class WelcomePage extends BasePage {

  private final String loginLinkXpath = "//a[text()='Login']";
  private final String registrationLinkXpath = "//a[text()='Registration']";

  public LoginPage clickLoginLink() {
    logger.debug("Click 'Login' link");
    Browser.getWebDriver().findElement(By.xpath(loginLinkXpath)).click();
    return new LoginPage();
  }

  public RegistrationPage clickRegistrationLink() {
    logger.debug("Click 'Registration' link");
    Browser.getWebDriver().findElement(By.xpath(registrationLinkXpath)).click();
    return new RegistrationPage();
  }
}
