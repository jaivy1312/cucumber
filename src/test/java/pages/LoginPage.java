package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	public String searchitem;
	By searchtab=By.xpath("//input[@type='search']");
	By searchedtext=By.xpath("//div/h4[@class='product-name']");
	By topdeals=By.linkText("Top Deals");
	By increment=By.cssSelector(".increment");
	By addtocart=By.cssSelector(".product-action button");
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void searchitem(String itemname)
	{
		driver.findElement(searchtab).sendKeys(itemname);	
		
		
	}
	
	public String getsearchedproducttext()
	{
		searchitem=	driver.findElement(searchedtext).getText().split("-")[0].trim();
		
		System.out.println(searchitem);
		return searchitem;
	}
	public void selecttopdealspage()
	{
		driver.findElement(topdeals).click();
	}
	
	public String getpagetitle()
	{
		return driver.getTitle();
	}
	
	public void addquantity(int quantity)
	{	
		for(int i=1;i<=quantity;i++)
		{
			driver.findElement(increment).click();
			
		}
	}
	
	public void addtocart()
	{
		driver.findElement(addtocart).click();
	}

}
