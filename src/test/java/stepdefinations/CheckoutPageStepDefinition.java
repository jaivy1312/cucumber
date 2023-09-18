package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.extensions.TestSetup;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class CheckoutPageStepDefinition {
	
	public String searchitem;
	public String searchitemnext;
	public TestContextSetup testcontextsetup;
	public PageObjectManager pageobjectmanager;
	public CheckoutPage checkoutpage;
	public CheckoutPageStepDefinition(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup=testcontextsetup;
		this.checkoutpage=testcontextsetup.pageobjectmanager.getcheckoutpage();
	}
	
	@Then("verify user has the ability to apply promo code and placeorder")
	public void verify_user_has_the_ability_to_apply_promo_code_and_placeorder()
	{	
		Assert.assertTrue(checkoutpage.verifyplaceorderbutton());
		Assert.assertTrue(checkoutpage.verifypromptbutton());
	}
	
	@Then("^user proceeds to checkoutpage and validate (.+) in checkoutpage$")
	public void user_proceeds_to_checkoutpage(String vegetable) throws InterruptedException
	{	
		
		boolean verifyvegetables=checkoutpage.verifytext(vegetable).equalsIgnoreCase(vegetable);
		System.out.println(vegetable+"yes");
		String checkouttext=checkoutpage.verifytext(vegetable);
		System.out.println(checkouttext+"yes");
		Assert.assertFalse(verifyvegetables);
		checkoutpage.checkoutitem();
		Thread.sleep(3000);
	}



}
