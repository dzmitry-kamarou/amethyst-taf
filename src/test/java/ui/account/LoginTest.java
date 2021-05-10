package ui.account;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import business.account.Account;
import business.account.AccountFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.Browser;
import ui.flow.DashboardPageFlow;
import ui.flow.LoginPageFlow;
import ui.flow.WelcomePageFlow;

@Test(suiteName = "Login suite", groups = {"smoke", "regression"})
public class LoginTest {

  @BeforeMethod(description = "Load application")
  public void loadApplication() {
    Browser.Up();
    Browser.loadApp();
  }

  @Test(testName = "Registered account can log in")
  public void registeredAccountCanLogIn() {
    Account account = AccountFactory.registeredAccount();
    new WelcomePageFlow().login().login(account);
    assertThat(String.format("Account '%s' has been registered", account.getEmail()),
        new DashboardPageFlow().grabGreeting(),
        equalTo(String.format("Welcome %s %s", account.getFirstName(), account.getLastName())));
  }

  @Test(testName = "Not registered account can not log in")
  public void notRegisteredAccountCanNotLogIn() {
    Account account = AccountFactory.randomAccount();
    new WelcomePageFlow().login().login(account);
    assertThat("Account '%s' has not been registered",
        new LoginPageFlow().grabMessageText(),
        is("that email is not registered"));
  }

  @Test(testName = "Registered account can not log in with wrong password")
  public void registeredAccountCanNotLoginWithWrongPassword() {
    Account account = AccountFactory.registeredAccount();
    account.setPassword(String.format("wrong%s", account.getPassword()));
    new WelcomePageFlow().login().login(account);
    assertThat("Account '%s' entered wrong password",
        new LoginPageFlow().grabMessageText(),
        is("password incorrect"));
  }

  @AfterMethod(description = "Close application")
  public void closeApplication() {
    Browser.down();
  }
}
