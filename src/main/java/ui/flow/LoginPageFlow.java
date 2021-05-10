package ui.flow;

import business.account.Account;
import ui.page.LoginPage;

public class LoginPageFlow {

  private final LoginPage loginPage;

  public LoginPageFlow() {
    loginPage = new LoginPage();
  }

  public void login(Account account) {
    loginPage.fillEmailField(account.getEmail());
    loginPage.fillPasswordField(account.getPassword());
    loginPage.clickLoginButton();
  }

  public String grabMessageText() {
    return loginPage.messageLabelText();
  }

  public String grabTitleText() {
    return loginPage.titleHeadingText();
  }
}
