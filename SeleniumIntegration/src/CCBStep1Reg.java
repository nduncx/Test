import java.util.Date;

import junit.framework.TestCase;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.Random;

import testlink.api.java.client.TestLinkAPIResults;

import com.thoughtworks.selenium.Selenium;

public class CCBStep1Reg extends TestCase implements IConstantes {  

Selenium selenium;  

@Before
public void setUp() throws Exception {
WebDriver driver = new FirefoxDriver();
String baseUrl = "http://butlinsarcade.stminver-demo.com/butlinsarcade/casino/home/";
selenium = new WebDriverBackedSelenium(driver, baseUrl);
}
@Test
public void testCCBStep1Reg() throws Exception {
	String resultado = null;
	String nota = null;
	Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 1; ++idx){
	      int randomInt = randomGenerator.nextInt(99999999);
	
		try {
			selenium.open("/maxbetreal/casino/home/");
			selenium.click("css=img[alt=\"Join Now\"]");
			selenium.waitForPageToLoad("900000");
			selenium.type("name=newPlayer.firstName", "Nicholas");
			selenium.type("name=newPlayer.lastName", "Rodriguez");
			selenium.type("id=emailId", "nicholas.rodriguez@gtechg22.com");
			selenium.select("id=birthday_day", "label=4");
			selenium.select("id=birthday_month", "label=Feb");
			selenium.select("id=birthday_year", "label=1980");
			selenium.select("name=newPlayer.gender", "label=barbat");
			selenium.type("name=newPlayer.address.mobilePhone",
					"+4492929292922");
			selenium.select("id=country", "label=ROMANIA");
			selenium.click("id=next1");
			selenium.waitForPageToLoad("500000");
			selenium.type("id=userId", "MRT_"+ randomInt);
			selenium.type("name=newPlayer.password", "111111");
			selenium.click("name=newPlayer.personalInformation.confirmedAge18");
			selenium.click("name=newPlayer.personalInformation.termsAccepted");
			selenium.select(
					"name=newPlayer.personalInformation.sendNewsLetter",
					"label=Da, versiunea HTML (cu imagini)");
			selenium.click("id=registration_button_practice");
			selenium.waitForPageToLoad("900000");


resultado = TestLinkAPIResults.TEST_PASSED;
}
catch (Exception e) {
resultado = TestLinkAPIResults.TEST_FAILED;
nota = e.getMessage();
e.printStackTrace();
}
finally {
ResultadoExecucao.reportTestCaseResult1(PROJETO, PLANO, CASO_TESTE3, BUILD, nota, resultado);
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
