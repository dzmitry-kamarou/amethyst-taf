package ui.flow;

import business.account.Account;
import ui.page.RegistrationPage;

public class RegistrationPageFlow {

  private final RegistrationPage registrationPage;

  public RegistrationPageFlow() {
    registrationPage = new RegistrationPage();
  }

  public void register(Account account) {
    registrationPage
        .fillFirstNameField(account.getFirstName())
        .fillLastNameField(account.getLastName())
        .fillEmailField(account.getEmail())
        .fillPasswordField(account.getPassword())
        .fillConfirmPasswordField(account.getPassword())
        .clickRegisterButton();
  }

  public String grabMessageText() {
    return registrationPage.messageLabelText();
  }
}
