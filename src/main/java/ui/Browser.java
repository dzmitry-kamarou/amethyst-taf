package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

  private static final AmethystConfig AMETHYST_CONFIG = AmethystConfig.config;
  private static final String AMETHYST_URL = AMETHYST_CONFIG.uri();
  private static WebDriver driver;

  private Browser() {
  }

  public static void loadApp() {
    getWebDriver().get(AMETHYST_URL);
  }

  public static void down() {
    getWebDriver().close();
    getWebDriver().quit();
    driver = null;
  }

  public static void Up() {
    getWebDriver().manage().window().maximize();
  }

  public static WebDriver getWebDriver() {
    System.setProperty("webdriver.chrome.driver", System.getenv("chromedriver"));
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setBinary(System.getenv("chromebinary"));
    if (driver == null) {
      driver = new ChromeDriver(chromeOptions);
    }
    return driver;
  }
}
