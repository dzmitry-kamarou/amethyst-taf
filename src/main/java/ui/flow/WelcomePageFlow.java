package ui.flow;

import ui.page.WelcomePage;

public class WelcomePageFlow {

  private final WelcomePage welcomePage;

  public WelcomePageFlow() {
    welcomePage = new WelcomePage();
  }

  public LoginPageFlow login() {
    welcomePage.clickLoginLink();
    return new LoginPageFlow();
  }
}
