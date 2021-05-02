package ui.page;

import org.openqa.selenium.By;
import ui.Browser;

public class LoginPage {

  private String titleXpath = "//h1[@id='title']";
  private String errorLabelXpath = "//span[@id='error']";
  private String emailFieldXpath = "//input[@id='email']";
  private String passwordFieldXpath = "//input[@id='password']";
  private String loginButtonXpath = "//button[@id='submit']";

  public LoginPage enterEmail(String email) {
    Browser.getWebDriver().findElement(By.xpath(emailFieldXpath)).sendKeys(email);
    return this;
  }

  public LoginPage enterPassword(String password) {
    Browser.getWebDriver().findElement(By.xpath(passwordFieldXpath)).sendKeys(password);
    return this;
  }

  public void clickLoginButton() {
    Browser.getWebDriver().findElement(By.xpath(loginButtonXpath)).click();
  }

  public String errorLabelText() {
    return Browser.getWebDriver().findElement(By.xpath(errorLabelXpath)).getText();
  }

  public String titleText() {
    return Browser.getWebDriver().findElement(By.xpath(titleXpath)).getText();
  }
}
