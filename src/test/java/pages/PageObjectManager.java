package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LoginPage loginpage;
	public WebDriver driver;
	public OffersPage offerspage;
	public CheckoutPage checkoutpage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	public LoginPage getloginpage()
	{
		loginpage=new LoginPage(driver);
		return loginpage;
	}

	public OffersPage getofferpage()
	{
		offerspage=new OffersPage(driver);
		return offerspage;
	}
	
	public CheckoutPage getcheckoutpage()
	{
		checkoutpage=new CheckoutPage(driver);
		return checkoutpage;
	}
}
