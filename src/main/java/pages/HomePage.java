package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import setup.TestBase;


public class HomePage extends TestBase {

	// Locators
	By contactusBtn = By.xpath("//*[text()='Contact us']");
	By acceptBtn = By.xpath("//a[@id='wt-cli-accept-all-btn']");

	// Methods
	public void click_ContactUS() {

		getDriverInstance().findElement(acceptBtn).click();
		WebDriverWait wait = new WebDriverWait(getDriverInstance(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(getDriverInstance().findElement(contactusBtn))).click();
	}

}
