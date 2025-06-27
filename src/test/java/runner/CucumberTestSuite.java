package runner;/*
package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)  // Use Serenity Runner
@CucumberOptions(
        features = "src/test/resources/features",  // Path to feature files
        glue = "runner.stepDef",  // Package containing step definitions
        //plugin = {"pretty", "html:target/cucumber-reports.html"} // Reports
       tags = "@smoke or @unitTest"  // Run specific scenarios (optional)
)
public class CucumberTestSuite {
}
*/

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // Specify the directory where your feature files are located
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty") // Optional: For pretty output
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "runner.stepDef")
@SelectPackages("stepDef")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporter,pretty")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@smoke or @unitTest")
public class CucumberTestSuite {
}