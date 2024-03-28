package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import genericUtilities.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Before
	public void browserConfig() {
		testContextSetup.web.maximizeBrowser();
		testContextSetup.web
				.waitUntilElementFound(Long.parseLong(testContextSetup.property.readFromProperties("timeouts")));
	}

	@AfterStep
	public void afterStep(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			File file = testContextSetup.web.takeScreenshot(testContextSetup.driver, testContextSetup.jutil, scenario.getName());
			byte[] byteArray = FileUtils.readFileToByteArray(file);
			scenario.attach(byteArray, "image/png", scenario.getName());
		}

	}

	@After
	public void closeBrowser() {
		testContextSetup.web.quitAllWindows();
	}
}
