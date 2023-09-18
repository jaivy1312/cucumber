
package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/feature", glue="stepdefinations", monochrome=true,dryRun=false)
public class JunitTestRunner {

}
