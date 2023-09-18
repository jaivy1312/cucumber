package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	public WebDriver driver;
	public String searchitem;
	By searchtab=By.id("search-field");
	By searchedoffertext=By.cssSelector("tr td:nth-child(1)");
	public OffersPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void searchitem(String itemname)
	{
		driver.findElement(searchtab).sendKeys(itemname);	
		
		
	}
	
	public String getsearchedofferproducttext()
	{
		searchitem=	driver.findElement(searchedoffertext).getText().trim();
		
		System.out.println(searchitem);
		return searchitem;
	}

}
