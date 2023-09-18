package stepdefinations;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.OffersPage;
import pages.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class OfferPageStepDefinition {

	public String offerpageproduct;
	public TestContextSetup testcontextsetup;
	public PageObjectManager pageobjectmanager;
	public OfferPageStepDefinition(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup=testcontextsetup;
	}
	@And("^user serach short name (.+) in offer page and extract name from there$")
	public void user_serach_short_name_in_offer_page_and_extract_name_from_there(String itemnext) throws InterruptedException {
		OffersPage offerspage=testcontextsetup.pageobjectmanager.getofferpage();
		switchtoofferpage();
		Thread.sleep(1000);
		offerspage.searchitem(itemnext);
		Thread.sleep(1000);
		offerpageproduct=offerspage.getsearchedofferproducttext();
		System.out.println(offerpageproduct);
	//	testcontextsetup.driver.switchTo().window(parentwindow);
		
		
	}
	
	public void switchtoofferpage()
	{	
		//if(testcontextsetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/"))
		
			LoginPage loginpage= testcontextsetup.pageobjectmanager.getloginpage();
			loginpage.selecttopdealspage();
			testcontextsetup.genericmethods.switchwindow();
			
		
	}
	@Then("compare name extracted from both pages")
	public void compare_name_extracted_from_both_pages() {
		Assert.assertEquals(testcontextsetup.searchitem, offerpageproduct);
	}


}
