package runner;

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