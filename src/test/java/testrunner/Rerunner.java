package testrunner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenario.txt", glue="stepdefinations",
monochrome=true,tags="@Placeorder",
plugin= {"json:target/cucumber.json","html:target/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
dryRun=false)
public class Rerunner extends AbstractTestNGCucumberTests  {

	@Override
	@DataProvider(parallel=true)
	public Object[][]scenarios()
	{
		return super.scenarios();
	}
}
