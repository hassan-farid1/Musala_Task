package pages;

import org.openqa.selenium.By;

import setup.TestBase;

public class CompanyPage extends TestBase {
	
	
	FacebookPage facebook;
	
	// Locators
	By company = By.xpath("(//div[@id=\"menu\"]//a[@class=\"main-link\"])[1]");
	By innovate = By.xpath("//span[text()='Let`s innovate and grow together']");
	By leadershipSection = By.xpath("//h2[text()='Leadership']");
	By acceptBtn = By.xpath("//a[@id='wt-cli-accept-all-btn']");
	By facebookLink = By.xpath("//span[@class='musala musala-icon-facebook']");
	

	
	
	
	// Methods
	public void click_Company()
	{
		getDriverInstance().findElement(company).click();
	}
	
	public String assert_LeaderShip_text()
	{
		return getDriverInstance().findElement(leadershipSection).getText();
	}
	
	
	public void click_Facebook()
	{
		getDriverInstance().findElement(acceptBtn).click();
		getDriverInstance().findElement(facebookLink).click();
	}
	
}
