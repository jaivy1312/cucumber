package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CheckoutPage {
	public WebDriver driver;
	public String checkouttext;
	public CheckoutPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	By cartpurse= By.cssSelector("img[alt='Cart']");
	By checkout=By.xpath("//button[contains(text(),'PROCEED TO')]");
	By applybtn= By.cssSelector(".promoBtn");
	By placeorderbtn=By.xpath("//button[contains(text(),'Place Order')]");
	By checkouttextsearch=By.className("product-name");
	
	public void checkoutitem()
	{
		driver.findElement(cartpurse).click();
		driver.findElement(checkout).click();
	}
	
	public boolean verifypromptbutton()
	{
		return driver.findElement(applybtn).isDisplayed();
		
	}
	
	public boolean verifyplaceorderbutton()
	{
		return driver.findElement(placeorderbtn).isDisplayed();
	}
	
	public String verifytext(String vegetable)
	{
		checkouttext=driver.findElement(checkouttextsearch).getText().split("-")[0].trim();
		System.out.println(checkouttext);
		System.out.println("this is checkoutpage verifytext");
		return checkouttext;
	}
}
