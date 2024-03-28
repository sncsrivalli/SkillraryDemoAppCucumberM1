package stepDefinitions;

import genericUtilities.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginStepDefinition {
	TestContextSetup testContextSetup;

	public LoginStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User navigates to skillrary application")
	public void user_navigates_to_skillrary_application() {
		testContextSetup.web
				.navigateToApp(testContextSetup.property.readFromProperties("url"));
	}

	@And("logs in into the application")
	public void logs_in_into_the_application() {
		testContextSetup.pageObjectManager.getLoginPage().loginToApp(
				testContextSetup.property.readFromProperties("username"),
				testContextSetup.property.readFromProperties("password"));

	}
}
