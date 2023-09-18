package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	
	public WebDriver webdrivermanager() throws IOException
	{	
		Properties prop=new Properties();
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		prop.load(fis);
		
		String url=prop.getProperty("url");
		String browser_properties=prop.getProperty("browser");
		String browser_system=System.getProperty("browser");
		
		String browser=browser_system!=null ? browser_system : browser_properties;
		
		if(driver==null)
	{
			if(browser.equalsIgnoreCase("chrome"))
			{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
			}
			else
			{
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
			}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
		return driver;
	}

}
