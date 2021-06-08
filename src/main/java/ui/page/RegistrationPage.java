package ui.page;

import org.openqa.selenium.By;
import ui.Browser;

public class RegistrationPage extends BasePage {

  private final String firstNameFieldXpath = "//input[@id='firstName']";
  private final String lastNameFieldXpath = "//input[@id='lastName']";
  private final String emailFieldXpath = "//input[@id='email']";
  private final String passwordFieldXpath = "//input[@id='password']";
  private final String confirmPasswordFieldXpath = "//input[@id='confirmPassword']";
  private final String registerButtonXpath = "//button[@id='submit']";
  private final String messageLabelXpath = "//span[@id='message']";

  public RegistrationPage fillFirstNameField(String firstName) {
    logger.debug(String.format("Enter '%s' to 'first name' field", firstName));
    Browser.getWebDriver().findElement(By.xpath(firstNameFieldXpath)).sendKeys(firstName);
    return this;
  }

  public RegistrationPage fillLastNameField(String lastName) {
    logger.debug(String.format("Enter '%s' to 'last name' field", lastName));
    Browser.getWebDriver().findElement(By.xpath(lastNameFieldXpath)).sendKeys(lastName);
    return this;
  }

  public RegistrationPage fillEmailField(String email) {
    logger.debug(String.format("Enter '%s' to 'email' field", email));
    Browser.getWebDriver().findElement(By.xpath(emailFieldXpath)).sendKeys(email);
    return this;
  }

  public RegistrationPage fillPasswordField(String password) {
    logger.debug(String.format("Enter '%s' to 'password' field", password));
    Browser.getWebDriver().findElement(By.xpath(passwordFieldXpath)).sendKeys(password);
    return this;
  }

  public RegistrationPage fillConfirmPasswordField(String password) {
    logger.debug(String.format("Enter '%s' to 'confirm password' field", password));
    Browser.getWebDriver().findElement(By.xpath(confirmPasswordFieldXpath)).sendKeys(password);
    return this;
  }

  public RegistrationPage clickRegisterButton() {
    logger.debug("Click 'Register' button");
    Browser.getWebDriver().findElement(By.xpath(registerButtonXpath)).click();
    return this;
  }

  public String messageLabelText() {
    logger.debug("Grab message text");
    return Browser.getWebDriver().findElement(By.xpath(messageLabelXpath)).getText();
  }
}
