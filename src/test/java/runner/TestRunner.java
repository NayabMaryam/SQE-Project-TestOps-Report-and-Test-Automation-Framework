package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepDefinations")
@ConfigurationParameter(
	    key = PLUGIN_PROPERTY_NAME,
	    value = "pretty, json:target/cucumber.json, html:target/cucumber-html-report.html, io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
	)

public class TestRunner {
}
