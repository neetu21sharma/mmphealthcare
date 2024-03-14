package betabatch;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mmplib.AppLibrary;
import mmplib.BaseClass;
import mmplib.MMPLibrary;
import patientModule.pages.MessagesPage;

public class SendMessagesTests extends BaseClass {

	@Parameters({"subject", "message", "result"})

	@Test
	public void validateSendMessagesFunc(String subject, String message, String result) throws InterruptedException{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(prop.getProperty("patient_username"), prop.getProperty("patient_password"));
		mmpLib.moduleNavigation("Messages");
		MessagesPage msgPage = new MessagesPage(driver);
		String expectedSubject = subject + AppLibrary.generateRandomString();
		String expectedMessage = message + AppLibrary.generateRandomString();
		String expectedResult = result;
		//to confirm if the message was sent successfully 
		System.out.println(expectedResult);
		boolean output = msgPage.sendMessages(expectedSubject, expectedMessage, expectedResult);
		Assert.assertTrue(output);
		
	}

}

/*
 * public void sendMessage() throws InterruptedException
 * 
 * { //driver.get(
 * "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php")
 * ;
 * 
 * //Login driver.findElement(By.id("username")).sendKeys("ria1");
 * driver.findElement(By.id("password")).sendKeys("Ria12345");
 * driver.findElement(By.name("submit")).click(); MMPLibrary mmpLib = new
 * mmplib.MMPLibrary(driver); //mmpLib.login("username", "password");
 * //driver.findElement(By.name("submit")).click();
 * mmpLib.moduleNavigation("Messages"); mmpLib.sendMessage("Message"); String
 * actualMsg = mmpLib.handleAlerts(); String expectedMsg
 * ="Messages Successfully sent."; SoftAssert sa = new SoftAssert();
 * sa.assertEquals(actualMsg, expectedMsg); //String actual1 =
 * driver.findElement(By.className("panel-title")).getText().trim(); //String
 * expected1 = "Messages sent successfully"; sa.assertAll();
 * 
 * 
 * 
 * 
 * 
 * }
 */
