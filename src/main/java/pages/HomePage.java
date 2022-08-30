package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import setup.Base;


public class HomePage extends Base {

	// Locators
	By contactusBtn = By.xpath("//*[text()='Contact us']");
	By acceptBtn = By.xpath("//a[@id='wt-cli-accept-all-btn']");

	// Methods
	public void click_ContactUS() {

		if (getDriverInstance().findElement(acceptBtn).isDisplayed())
		{
		getDriverInstance().findElement(acceptBtn).click();
		}
		WebDriverWait wait = new WebDriverWait(getDriverInstance(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(getDriverInstance().findElement(contactusBtn))).click();
	}

}
