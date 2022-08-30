package pages;

import java.util.Set;

import setup.Base;

public class FacebookPage extends Base{
	
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
