import junit.framework.TestCase;

import org.junit.*;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.*;

import com.thoughtworks.selenium.*;

public class Screenshot extends TestCase implements IConstantes {

public Selenium selenium;

@BeforeClass
public void setUp() throws Exception {
	WebDriver driver = new FirefoxDriver();
	String baseUrl = "http://demo.backoff.stenodoc.com";
	selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}
@Test
public void testScreenshot() throws Exception
{
 
  try {
  selenium.open("http://in.yahoo.com//?p=us");
  selenium.windowMaximize();
  selenium.click("//li[@id='pa-u_14782488-bd']/a/span[2]");
  selenium.waitForPageToLoad("30000");
  selenium.type("username", "test");
  Thread.sleep(1000);
  //the element name for password field is "passwd" But here i changed it to "passd" which is wrong.
  //Selenium will capture screen shot after the error
  selenium.type("passd", "123");
  selenium.click(".save");
  selenium.waitForPageToLoad("30000");
 }
 catch (Exception e) {
  // TODO: handle exception
  e.printStackTrace();
  selenium.captureScreenshot("C:/Users/rodrign/Pictures");
 }
}
@AfterClass
public void tearDown() throws InterruptedException{
selenium.stop();
}
}