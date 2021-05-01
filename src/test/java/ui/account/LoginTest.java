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

@Test(suiteName = "Login suite", groups = {"smoke", "regression", "account"})
public class LoginTest {

  @BeforeMethod(description = "Load application")
  public void setUp() {
    Browser.Up();
    Browser.loadApp();
  }

  @Test(testName = "Registered account can log in")
  public void registeredAccountCanLogIn() {
    Account account = AccountFactory.registeredAccount();
    new WelcomePageFlow().login().login(account);
    assertThat(String.format("Account '%s' has been registered", account.getEmail()),
        new DashboardPageFlow().grabGreeting(),
        equalTo("Welcome " + account.getFirstName()));
  }

  @Test(testName = "Not registered account can not log in")
  public void notRegisteredAccountCannotLogIn() {
    Account account = AccountFactory.randomAccount();
    new WelcomePageFlow().login().login(account);
    assertThat("Account '%s' has not been registered",
        new LoginPageFlow().grabErrorText(),
        is("that email is not registered"));
  }

  @Test(testName = "Registered account can not log in with wrong password")
  public void registeredAccountCanNotLoginWithWrongPassword() {
    Account account = AccountFactory.registeredAccount();
    account.setPassword(String.format("wrong%s", account.getPassword()));
    new WelcomePageFlow().login().login(account);
    assertThat("Account '%s' entered wrong password",
        new LoginPageFlow().grabErrorText(),
        is("password incorrect"));
  }

  @AfterMethod(description = "Close application")
  public void tearDown() {
    Browser.down();
  }
}
