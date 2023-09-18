package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericMethods {
	
	public WebDriver driver;
	public GenericMethods(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void switchwindow()
	{
		Set<String>window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		String parentwindow= it.next();
		String childwindow=it.next();
		
		driver.switchTo().window(childwindow);
	}

}
