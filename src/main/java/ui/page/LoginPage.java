package ui.page;

import org.openqa.selenium.By;
import ui.Browser;

public class LoginPage {

  private String titleHeadingXpath = "//h1[@id='title']";
  private String messageLabelXpath = "//span[@id='message']";
  private String emailFieldXpath = "//input[@id='email']";
  private String passwordFieldXpath = "//input[@id='password']";
  private String loginButtonXpath = "//button[@id='submit']";

  public LoginPage fillEmailField(String email) {
    Browser.getWebDriver().findElement(By.xpath(emailFieldXpath)).sendKeys(email);
    return this;
  }

  public LoginPage fillPasswordField(String password) {
    Browser.getWebDriver().findElement(By.xpath(passwordFieldXpath)).sendKeys(password);
    return this;
  }

  public void clickLoginButton() {
    Browser.getWebDriver().findElement(By.xpath(loginButtonXpath)).click();
  }

  public String messageLabelText() {
    return Browser.getWebDriver().findElement(By.xpath(messageLabelXpath)).getText();
  }

  public String titleHeadingText() {
    return Browser.getWebDriver().findElement(By.xpath(titleHeadingXpath)).getText();
  }
}
