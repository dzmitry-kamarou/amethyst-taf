package ui.flow;

import ui.page.DashboardPage;

public class DashboardPageFlow {

  private final DashboardPage dashboardPage;

  public DashboardPageFlow() {
    dashboardPage = new DashboardPage();
  }

  public LoginPageFlow logOut() {
    dashboardPage.clickLogOutLink();
    return new LoginPageFlow();
  }

  public String grabGreeting() {
    return dashboardPage.greetingText();
  }
}
