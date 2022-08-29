package pages;


import org.openqa.selenium.By;

import setup.TestBase;

public class ContactUsPage extends TestBase
{
	
	
	
	// Locators
	By name = By.name("your-name");
	By email = By.name("your-email");
	By mobile = By.name("mobile-number");
	By subject = By.name("your-subject");
	By your_message = By.name("your-message");
	By invalid_message = By.xpath("//label[text()='Email']/..//span[@class='wpcf7-not-valid-tip']");
	By submit_btn = By.xpath("//input[@type='submit'][@value='Send']");

	
	// Methods
	public void contact_US(String FirstName, String Email, String Mobile, String Subject, String YourMsg) {
		getDriverInstance().findElement(name).sendKeys(FirstName);
		getDriverInstance().findElement(mobile).sendKeys(Mobile);
		getDriverInstance().findElement(subject).sendKeys(Subject);
		getDriverInstance().findElement(your_message).sendKeys(YourMsg);
		getDriverInstance().findElement(email).sendKeys(Email);
		getDriverInstance().findElement(submit_btn).click();
	}
	
	public String  assert_invalidemail_message()
	{
		return getDriverInstance().findElement(invalid_message).getText();
		//"The e-mail address entered is invalid.";
	}
}
