package stepdefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testcontextsetup;
	public WebDriver driver;
	public Hooks(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup=testcontextsetup;
	}
	
	@After
	public void closebrowser()
	{
		testcontextsetup.testbase.driver.quit();
		
	}
	
	@AfterStep
	public void takescreenshot(Scenario scenario) throws IOException
	{	driver=testcontextsetup.testbase.webdrivermanager();
		if(scenario.isFailed())
		{
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[]filecontent=FileUtils.readFileToByteArray(source);
			scenario.attach(filecontent, "image/jpg", "image");
		}
	}

}
