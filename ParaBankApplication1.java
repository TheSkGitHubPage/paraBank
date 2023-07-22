package pomdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

import java.util.List;


import base.Base;
import page_objects.AccountDetailsPage;
import page_objects.LoginPage;

public class ParaBankApplication1 extends Base {

	// @Test
	public void registerAcoount() {
		driver.get("https://parabank.parasoft.com/parabank/index.htm");

		WebElement registerBtn = driver.findElement(By.xpath("//a[text()='Register']"));
		registerBtn.click();

		WebElement typeFirstNameBox = driver.findElement(By.id("customer.firstName"));
		typeFirstNameBox.sendKeys("Johny");

		WebElement typeLastNameBox = driver.findElement(By.id("customer.lastName"));
		typeLastNameBox.sendKeys("Walker");

		WebElement typeAddressBox = driver.findElement(By.id("customer.address.street"));
		typeAddressBox.sendKeys("100 Main st");

		WebElement typeCityBox = driver.findElement(By.id("customer.address.city"));
		typeCityBox.sendKeys("Washington");

		WebElement typeStateBox = driver.findElement(By.id("customer.address.state"));
		typeStateBox.sendKeys("DC");

		WebElement typeZipcodeBox = driver.findElement(By.id("customer.address.zipCode"));
		typeZipcodeBox.sendKeys("20004");

		WebElement typePhoneNumberBox = driver.findElement(By.id("customer.phoneNumber"));
		typePhoneNumberBox.sendKeys("+12022007777");

		WebElement typeSnnNumberBox = driver.findElement(By.id("customer.ssn"));
		typeSnnNumberBox.sendKeys("202001177");

		WebElement typeUsernameBox = driver.findElement(By.id("customer.username"));
		typeUsernameBox.sendKeys("JWalker");

		WebElement typePasswordBox = driver.findElement(By.id("customer.password"));
		typePasswordBox.sendKeys("Jw202DC7777");

		WebElement typeConfirmPasswordBox = driver.findElement(By.id("repeatedPassword"));
		typeConfirmPasswordBox.sendKeys("Jw202DC7777");

		WebElement registerBtn1 = driver.findElement(By.cssSelector("input[value=\"Register\"]"));
		registerBtn1.click();

	}

//		WebElement logoutBtn = driver.findElement(By.xpath("//a[text()='Log Out']"));
//		logoutBtn.click();

	@Test
	public void testLogin() throws InterruptedException {
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		LoginPage loginPage = new LoginPage(driver);
		AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);
		//driver.findElement(By.name("username")).sendKeys("JWalker");
		loginPage.insertUsername("JWalker");
		
		
		
		//driver.findElement(By.name("password")).sendKeys("Jw202DC7777");
		loginPage.insertPassword("Jw202DC7777");
		

		//driver.findElement(By.xpath("(//input[@class=\"button\"])[1]")).click();
		loginPage.clickLoginBtn();
		
		Thread.sleep(2000);
		
		// Verify logged in successfully
//		List<WebElement> logoutLink = driver.findElements(By.xpath("//a[text()='Log Out']"));
//		Assert.assertEquals(logoutLink.size(), 1);
		Assert.assertTrue(accountDetailsPage.isLogoutDisplayed());
		
		
		//String accountNumber = driver.findElement(By.xpath("//table[@id='accountTable']/tbody/tr[1]/td[1]/a")).getText();
		Assert.assertEquals(accountDetailsPage.getAccountNumber(), "13788");
		Thread.sleep(2000);
		
		// Open the account details
		//driver.findElement(By.xpath("//tr[@ng-repeat=\"account in accounts\"]/td/a")).click();
		//driver.findElement(By.xpath("//a[text()='13788']")).click();
		accountDetailsPage.openAccountDetails();
		
		Thread.sleep(2000);
		
		// Check account type
		//Thread.sleep(1000);
		
		wait.until(ExpectedConditions.textToBePresentInElement(accountDetailsPage.getAccountTypeElement(), "CHECKING"));
//		String acctType = driver.findElement(By.id("accountType")).getText();
//		System.out.println("AcctType: " + acctType);
		Assert.assertEquals(accountDetailsPage.getAccountTypeValue(), "CHECKING");
		
		String acctNumber = driver.findElement(By.id("accountId")).getText();
		System.out.println("AcctNumber: " + acctNumber);
		Assert.assertEquals(acctNumber, "13788");
		
//		String acctBalance = driver.findElement(By.id("balance")).getText();
//		System.out.println("AcctBalance is: " + acctBalance);
		Assert.assertEquals(accountDetailsPage.getAccountBalance(), "$1000.00");
		
		String avlbBalance = driver.findElement(By.id("availableBalance")).getText();
		System.out.println("AvlbBalance is: " + avlbBalance);
		Assert.assertEquals(avlbBalance, "$1000.00");
		
		// Account activity:
		
//		driver.findElement(By.id("month")).click();
//		WebElement activityPeriod = driver.findElement(By.xpath("//select[@id='month']/option[@value='December']"));
//		wait.until(ExpectedConditions.elementToBeClickable(activityPeriod));
//		driver.findElement(By.cssSelector("option[value=\"December\"]"));
//		driver.findElement(By.id("transactionType")).click();
//		
//		WebElement activityType = driver.findElement(By.xpath("//select[@id='transactionType']/option[@value='Credit']"));
//		wait.until(ExpectedConditions.elementToBeClickable(activityType));
//		driver.findElement(By.cssSelector("option[value=\"Credit\"]")).click();
//		driver.findElement(By.cssSelector("input[value=\"Go\"]")).click();
//		
//		String acctActivityResult = driver.findElement(By.cssSelector("p[ng-if=\"transactions.length <= 0\"]")).getText();
//		System.out.println("AcctActivityResults: " + acctActivityResult);
//		assertEquals(acctActivityResult, "No transactions found.");
	}

}
