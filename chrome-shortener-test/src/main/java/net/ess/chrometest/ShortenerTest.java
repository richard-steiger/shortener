package net.ess.chrometest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShortenerTest
{
  // ======================================================================
  // Fields
  // ======================================================================
  private static final String siteBase = "http://localhost:9000";
  private static final String testUrl1 = "http://www.apple.com/iphone-7/";
  private static final String testUrl2 = "http://www.apple.com/macbookPro/";

  private WebDriver driver;
  
  // ======================================================================
  // Methods
  // ======================================================================
  // ---------------------------
  // Test Units 
  // ---------------------------
  @BeforeClass
  public static void setUp() {
    System.setProperty("webdriver.chrome.driver", "T:\\google\\chromedriver\\chromedriver.exe");
  }
  
  @Test
  public void testAddAlias() {
    driver = new ChromeDriver();
    driver.get(siteBase);
    showPageSource();
    pause(5);
    
    WebElement urlEntryBox = driver.findElement(By.name("q"));
    urlEntryBox.sendKeys("testUrl1");
    urlEntryBox.submit();
    showPageSource();
    pause(60);
    
    driver.quit();
  }
  
  // ---------------------------
  // Support Utilities
  // ---------------------------
  private void pause(int seconds) {
    try {
      Thread.sleep(seconds * 1000); 
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  
  private void showPageSource() {
    System.out.println(">>>");
    System.out.println(driver.getPageSource());
    System.out.println("<<<");
  }
}
