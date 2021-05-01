package ui.flow;

import ui.page.DashboardPage;

public class DashboardPageFlow {

  private final DashboardPage dashboardPage;

  public DashboardPageFlow() {
    dashboardPage = new DashboardPage();
  }

  public String grabGreeting() {
    return dashboardPage.greetingText();
  }
}
