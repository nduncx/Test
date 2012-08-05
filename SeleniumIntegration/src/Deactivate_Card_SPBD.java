import java.util.Date;

import junit.framework.TestCase;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import testlink.api.java.client.TestLinkAPIResults;

import com.thoughtworks.selenium.Selenium;

public class Deactivate_Card_SPBD extends TestCase implements IConstantes {  

Selenium selenium;  

@Before
public void setUp() throws Exception {
WebDriver driver = new FirefoxDriver();
String baseUrl = "http://demo.backoff.stenodoc.com";
selenium = new WebDriverBackedSelenium(driver, baseUrl);
}
@Test
public void testDeactivateemail() throws Exception {
	String resultado = null;
	String nota = null;
	try
	{
	selenium.open("/backoff/csr/htmls/login.html");
	selenium.type("name=userName", "dolkev");
	selenium.type("name=password", "password");
	selenium.click("css=input[type=\"image\"]");
	selenium.waitForPageToLoad("30000");
	selenium.click("css=a > img");
	selenium.open("http://demo.backoff.stenodoc.com/backoff/csr/htmls/customer_search_page.html");
	selenium.click("link=Bet History");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=ViewCustomerDetails");
	selenium.waitForPageToLoad("30000");
	selenium.selectWindow("null");
	selenium.click("link=Deactivate EmailId");
	selenium.waitForPageToLoad("30000");
	selenium.click("link=Deactivate Cards");
	selenium.waitForPageToLoad("30000");
	selenium.type("name=cardNumber", "4243199999998759");
	selenium.click("//tr[6]/td[3]/a/img");
	selenium.click("id=cardInfo");
	selenium.click("name=disableCards");
	assertTrue(selenium.getConfirmation().matches("^Do you want to disable cards[\\s\\S]$"));

resultado = TestLinkAPIResults.TEST_PASSED;
}
catch (Exception e) {
resultado = TestLinkAPIResults.TEST_FAILED;
nota = e.getMessage();
e.printStackTrace();
}
finally {
ResultadoExecucao.reportTestCaseResult1(PROJETO, PLANO, CASO_TESTE6, BUILD, nota, resultado);
}
}
@AfterMethod(alwaysRun=true)
public void stopSelenium() {
Date dt;
dt = new Date();
System.out.println("Execution Terminated at "+ dt);
this.selenium.stop();
} //stopSelenium();
}
