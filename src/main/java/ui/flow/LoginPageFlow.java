package ui.flow;

import business.account.Account;
import ui.page.LoginPage;

public class LoginPageFlow {

  private final LoginPage loginPage;

  public LoginPageFlow() {
    loginPage = new LoginPage();
  }

  public void login(Account account) {
    loginPage.enterEmail(account.getEmail());
    loginPage.enterPassword(account.getPassword());
    loginPage.clickLoginButton();
  }

  public String grabErrorText() {
    return loginPage.errorLabelText();
  }
}
