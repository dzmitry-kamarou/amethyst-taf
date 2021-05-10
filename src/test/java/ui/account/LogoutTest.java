package ui.account;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import business.account.Account;
import business.account.AccountFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.Browser;
import ui.flow.DashboardPageFlow;
import ui.flow.WelcomePageFlow;

@Test(suiteName = "Logout suite", groups = {"smoke", "regression"})
public class LogoutTest {

  @BeforeMethod(description = "Load application")
  public void loadApplication() {
    Browser.Up();
    Browser.loadApp();
  }

  @Test(testName = "Logged in account can log out")
  public void LoggedInAccountCanLogOut() {
    Account account = AccountFactory.registeredAccount();
    new WelcomePageFlow().login().login(account);
    assertThat(String.format("Logged in account '%s' has been logged out", account.getEmail()),
        new DashboardPageFlow().logOut().grabTitleText(),
        is("Welcome!"));
  }

  @AfterMethod(description = "Close application")
  public void closeApplication() {
    Browser.down();
  }
}
