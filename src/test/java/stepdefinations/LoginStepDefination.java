package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.extensions.TestSetup;
import pages.LoginPage;
import pages.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class LoginStepDefination {
	
	public String searchitem;
	public String searchitemnext;
	public TestContextSetup testcontextsetup;
	public PageObjectManager pageobjectmanager;
	public LoginPage loginpage;
	public LoginStepDefination(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup=testcontextsetup;
		this.loginpage=testcontextsetup.pageobjectmanager.getloginpage();
	}
	@Given("User is on home page")
	public void user_is_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(loginpage.getpagetitle().contains("GreenKart"));
	
	}
	@When("^user search with name (.+) on home page and extract name from there$")
	public void user_search_with_name_on_home_page_and_extract_name_from_there(String itemname) throws InterruptedException {
		//LoginPage loginpage=testcontextsetup.pageobjectmanager.getloginpage();
		loginpage.searchitem(itemname);
		Thread.sleep(1000);
		testcontextsetup.searchitem=loginpage.getsearchedproducttext();
		System.out.println(testcontextsetup.searchitem);
	
		
	}

    @When("user add the {string} quantity of the searched order")
    public void user_add_the_quantity_of_the_searched_order(String quantity) throws InterruptedException
   {
    	loginpage.addquantity(Integer.parseInt(quantity));
	    loginpage.addtocart();
    }

}
