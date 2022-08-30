package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import setup.Base;

public class CareersPage extends Base{

	
	// Locators
	By careers = By.xpath("(//div[@id=\"menu\"]//a[@class=\"main-link\"])[5]");
	By openPositions = By.xpath("//span[text()='Check our open positions']");
	By locationsList = By.xpath("//select[@name='get_location']");
	By acceptBtn = By.xpath("//a[@id='wt-cli-accept-all-btn']");
	By qaEngineer = By.xpath("//h2[@data-alt='Automation QA Engineer']");
	By generalDescription = By.xpath("//h2[text()='General description']");
	By requirements = By.xpath("//h2[text()='Requirements']");
	By responsibilities = By.xpath("//h2[text()='Responsibilities']");
	By whatWeOffer = By.xpath("//h2[text()='What we offer']");
	By applyBtn = By.xpath("//input[@value='Apply']");
	By name = By.xpath("//input[@name='your-name']");
	By email = By.xpath("//input[@name='your-email']");
	By chooseCV = By.xpath("//input[@name='upload-cv']");
	By sendBtn = By.xpath("//input[@value='Send']");
	By invalid_message = By.xpath("//label[text()='Email']/..//span[@class='wpcf7-not-valid-tip']");
	By jobsAvailableList = By.xpath("//article[@class = \"card-jobsHot\"]");	
	By jobsListNames = By.xpath("//h2[@class = \"card-jobsHot__title\"]");
	By jobsAvaialabeListLinks = By.xpath("//div[@class = \"card-container\"]//a");
	
	
	// Methods
	public void click_careers() 
	{
		getDriverInstance().findElement(careers).click();
	}
	
	public void click_openPositions ()
	{
		getDriverInstance().findElement(openPositions).click();
	}
	
	public void select_Location(String location) 
	{
		Select selectoptions = new Select(getDriverInstance().findElement(locationsList));
		selectoptions.selectByVisibleText(location);
		
	}
	
	public void select_Job() 
	{
		
		getDriverInstance().findElement(acceptBtn).click();
		getDriverInstance().findElement(qaEngineer).click();
	}
	
	public boolean assert_GeneralDesc_Displayed()
	{
		return getDriverInstance().findElement(generalDescription).isDisplayed();
	}
	
	public boolean assert_Requirements_Displayed()
	{
		return getDriverInstance().findElement(requirements).isDisplayed();
	}
	
	public boolean assert_Responsibilities_Displayed()
	{
		return getDriverInstance().findElement(responsibilities).isDisplayed();
	}
	
	public boolean assert_WhatWeOffer_Displayed()
	{
		return getDriverInstance().findElement(whatWeOffer).isDisplayed();
	}
	
	public boolean assert_applyBtn_isDisplayed()
	{
		return getDriverInstance().findElement(applyBtn).isDisplayed();
	}
	
	public void click_Apply()
	{
		getDriverInstance().findElement(applyBtn).click();
		
	}
	
	public void fill_Fields(String Name, String Email) 
	{
		getDriverInstance().findElement(name).sendKeys(Name);
		getDriverInstance().findElement(email).sendKeys(Email);
		getDriverInstance().findElement(chooseCV).sendKeys(System.getProperty("user.dir")+"/src/test/resources/Test doc.docx");
		
	}
	
	public void click_Send()
	{
		getDriverInstance().findElement(sendBtn);
		
	}

	public String  assert_invalid_message()
	{
		return getDriverInstance().findElement(invalid_message).getText();		
	
	}
	
	public void get_AvailableJobsDetails()
	{
		getDriverInstance().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		List<WebElement> jobs_names = getDriverInstance().findElements(jobsListNames);
		
	
		List<WebElement> jobs_links = getDriverInstance().findElements(jobsAvaialabeListLinks);
		
		  for (int i=0; i<jobs_names.size();i++){
		      System.out.println("Position:" + jobs_names.get(i).getText());
		      System.out.println("More info:"+ jobs_links.get(i).getAttribute("href"));
		    }
	}
	

}
