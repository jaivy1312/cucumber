package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pages.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String searchitem;
	public PageObjectManager pageobjectmanager;
	public TestBase testbase;
	public GenericMethods genericmethods;
	public TestContextSetup() throws IOException
	{	testbase=new TestBase();
		pageobjectmanager=new PageObjectManager(testbase.webdrivermanager());
		genericmethods =new GenericMethods(testbase.webdrivermanager());
	}

}
