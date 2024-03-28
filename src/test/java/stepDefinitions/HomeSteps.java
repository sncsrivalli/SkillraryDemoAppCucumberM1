package stepDefinitions;

import genericUtilities.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.HomePage;

public class HomeSteps {

	TestContextSetup testContextSetup;
	HomePage home;

	public HomeSteps(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@When("user navigates to course list page")
	public void user_navigates_to_course_list_page() {
		home = testContextSetup.pageObjectManager.getHomePage();
		home.navigateToCourseListPage();
	}

	@Then("User logs out of the application")
	public void user_logs_out_of_the_application() {
	    home.signoutOfApp();
	}
	
	@When("user navigates to category page")
	public void user_navigates_to_category_page() {
		home = testContextSetup.pageObjectManager.getHomePage();
	    home.navigateToCategoryPage();
	}

}
