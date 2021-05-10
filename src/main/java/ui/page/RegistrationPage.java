package ui.page;

import org.openqa.selenium.By;
import ui.Browser;

public class RegistrationPage {

  private final String firstNameFieldXpath = "//input[@id='firstName']";
  private final String lastNameFieldXpath = "//input[@id='lastName']";
  private final String emailFieldXpath = "//input[@id='email']";
  private final String passwordFieldXpath = "//input[@id='password']";
  private final String confirmPasswordFieldXpath = "//input[@id='confirmPassword']";
  private final String registerButtonXpath = "//button[@id='submit']";
  private final String messageLabelXpath = "//span[@id='message']";

  public RegistrationPage fillFirstNameField(String firstName) {
    Browser.getWebDriver().findElement(By.xpath(firstNameFieldXpath)).sendKeys(firstName);
    return this;
  }

  public RegistrationPage fillLastNameField(String lastName) {
    Browser.getWebDriver().findElement(By.xpath(lastNameFieldXpath)).sendKeys(lastName);
    return this;
  }

  public RegistrationPage fillEmailField(String email) {
    Browser.getWebDriver().findElement(By.xpath(emailFieldXpath)).sendKeys(email);
    return this;
  }

  public RegistrationPage fillPasswordField(String password) {
    Browser.getWebDriver().findElement(By.xpath(passwordFieldXpath)).sendKeys(password);
    return this;
  }

  public RegistrationPage fillConfirmPasswordField(String password) {
    Browser.getWebDriver().findElement(By.xpath(confirmPasswordFieldXpath)).sendKeys(password);
    return this;
  }

  public RegistrationPage clickRegisterButton() {
    Browser.getWebDriver().findElement(By.xpath(registerButtonXpath)).click();
    return this;
  }

  public String messageLabelText() {
    return Browser.getWebDriver().findElement(By.xpath(messageLabelXpath)).getText();
  }
}
