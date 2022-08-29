package pages;

import java.util.Set;

import setup.TestBase;

public class FacebookPage extends TestBase{
	
	public String  assert_FBPage_url()
	{
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) 
		{ 
			driver.switchTo().window(window);
		}
		
		return driver.getCurrentUrl();
	}


}
