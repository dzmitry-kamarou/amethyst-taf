package ui.account;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

import api.service.AccountsService;
import business.account.Account;
import business.account.AccountFactory;
import java.util.LinkedList;
import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.Browser;
import ui.flow.LoginPageFlow;
import ui.flow.RegistrationPageFlow;
import ui.flow.WelcomePageFlow;
import ui.page.RegistrationPage;

@Test(suiteName = "Registration suite", groups = {"smoke", "regression"})
public class RegistrationTest {

  private final AccountsService accountsService = new AccountsService();
  List<Account> accounts = new LinkedList<>();

  @BeforeMethod(description = "Load application")
  public void loadApplication() {
    Browser.Up();
    Browser.loadApp();
  }

  @Test(testName = "New account can be registered")
  public void newAccountCanBeRegistered() {
    Account account = AccountFactory.randomAccount();
    accounts.add(account);
    new WelcomePageFlow().registration().register(account);
    assertThat("Registration passed successfully",
        new LoginPageFlow().grabMessageText(),
        is("You have now registered!"));
  }

  @Test(testName = "Account can not be registered for the same email")
  public void accountCanNotBeRegisteredForTheSameEmail() {
    Account account = AccountFactory.randomAccount();
    accounts.add(account);
    new WelcomePageFlow().registration().register(account);
    Browser.loadApp();
    new WelcomePageFlow().registration().register(account);
    assertThat("The same email registration was declined",
        new RegistrationPageFlow().grabMessageText(),
        is("email already registered"));
  }

  @Test(testName = "Account can not be registered for passwords mismatch")
  public void accountCanNotBeRegisteredForPasswordsMismatch() {
    Account account = AccountFactory.randomAccount();
    new WelcomePageFlow().registration();
    RegistrationPage registrationPage = new RegistrationPage();
    registrationPage
        .fillFirstNameField(account.getFirstName())
        .fillLastNameField(account.getLastName())
        .fillEmailField(account.getEmail())
        .fillPasswordField(account.getPassword())
        .fillConfirmPasswordField(AccountFactory.randomAccount().getPassword())
        .clickRegisterButton();
    assertThat("Passwords mismatch registration was declined",
        registrationPage.messageLabelText(),
        is("passwords don't match"));
  }

  @Test(testName = "Account can not be registered for less than 6 digits password")
  public void accountCanNotBeRegisteredForLessThan6DigitsPassword() {
    Account account = AccountFactory.randomAccount();
    String sortPassword = "12345";
    new WelcomePageFlow().registration();
    RegistrationPage registrationPage = new RegistrationPage();
    registrationPage
        .fillFirstNameField(account.getFirstName())
        .fillLastNameField(account.getLastName())
        .fillEmailField(account.getEmail())
        .fillPasswordField(sortPassword)
        .fillConfirmPasswordField(sortPassword)
        .clickRegisterButton();
    assertThat("Short password registration was declined",
        registrationPage.messageLabelText(),
        is("password atleast 6 characters"));
  }

  @Test(testName = "Account can not be registered for blank fields", dataProvider = "accountsDataProvider")
  public void accountCanNotBeRegisteredForBlankFields(String firstName, String lastName,
      String email, String password, String confirmPassword) {
    new WelcomePageFlow().registration();
    RegistrationPage registrationPage = new RegistrationPage();
    registrationPage
        .fillFirstNameField(firstName)
        .fillLastNameField(lastName)
        .fillEmailField(email)
        .fillPasswordField(password)
        .fillConfirmPasswordField(confirmPassword)
        .clickRegisterButton();
    assertThat("Blank fields registration was declined",
        registrationPage.messageLabelText(),
        startsWith("Please fill in all fields"));
  }

  @DataProvider(name = "accountsDataProvider")
  public Object[][] accountsDataProvider() {
    String blank = "";
    Account account = AccountFactory.randomAccount();
    return new Object[][]{
        {
            blank,
            account.getLastName(),
            account.getEmail(),
            account.getPassword(),
            account.getPassword()
        },
        {
            account.getFirstName(),
            blank,
            account.getEmail(),
            account.getPassword(),
            account.getPassword()
        },
        {
            account.getFirstName(),
            account.getLastName(),
            blank,
            account.getPassword(),
            account.getPassword()
        },
        {
            account.getFirstName(),
            account.getLastName(),
            account.getEmail(),
            blank,
            account.getPassword()
        },
        {
            account.getFirstName(),
            account.getLastName(),
            account.getEmail(),
            account.getPassword(),
            blank
        }
    };
  }

  @AfterMethod(description = "Close application")
  public void closeApplication() {
    Browser.down();
  }

  @AfterClass(description = "Remove accounts")
  public void removeAccounts() {
    accounts.forEach(a -> accountsService
        .deleteAccount(accountsService.getAccount(a.getEmail()).as(Account.class).getObjectId()));
  }
}
