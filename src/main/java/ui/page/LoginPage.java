package ui.page;

import org.openqa.selenium.By;
import ui.Browser;

public class LoginPage extends BasePage {

  private String titleHeadingXpath = "//h1[@id='title']";
  private String messageLabelXpath = "//span[@id='message']";
  private String emailFieldXpath = "//input[@id='email']";
  private String passwordFieldXpath = "//input[@id='password']";
  private String loginButtonXpath = "//button[@id='submit']";

  public LoginPage fillEmailField(String email) {
    logger.debug(String.format("Enter '%s' to 'email' field", email));
    Browser.getWebDriver().findElement(By.xpath(emailFieldXpath)).sendKeys(email);
    return this;
  }

  public LoginPage fillPasswordField(String password) {
    logger.debug(String.format("Enter '%s' to 'password' field", password));
    Browser.getWebDriver().findElement(By.xpath(passwordFieldXpath)).sendKeys(password);
    return this;
  }

  public void clickLoginButton() {
    logger.debug("Click 'Login' button");
    Browser.getWebDriver().findElement(By.xpath(loginButtonXpath)).click();
  }

  public String messageLabelText() {
    logger.debug("Get 'message' text");
    return Browser.getWebDriver().findElement(By.xpath(messageLabelXpath)).getText();
  }

  public String titleHeadingText() {
    logger.debug("Grab 'Heading' text");
    return Browser.getWebDriver().findElement(By.xpath(titleHeadingXpath)).getText();
  }
}
