package business.account;

import business.BusinessConfig;
import com.github.javafaker.Faker;

public class AccountFactory {

  private static final BusinessConfig CONFIG = BusinessConfig.config;

  public static Account randomAccount() {
    Account account = new Account();
    Faker faker = new Faker();
    account.setFirstName(faker.name().firstName());
    account.setLastName(faker.name().lastName());
    account.setEmail(faker.internet().emailAddress());
    account.setPassword(faker.internet().password());
    return account;
  }

  public static Account registeredAccount() {
    Account account = new Account();
    account.setFirstName(CONFIG.registeredAccountFirstName());
    account.setLastName(CONFIG.registeredAccountLastName());
    account.setEmail(CONFIG.registeredAccountEmail());
    account.setPassword(CONFIG.registeredAccountPassword());
    return account;
  }
}
