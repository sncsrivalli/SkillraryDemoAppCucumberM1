package stepDefinitions;

import genericUtilities.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.AddNewCategoryPage;
import objectRepository.CategoryPage;

public class CategorySteps {
	TestContextSetup testContextSetup;
	CategoryPage category;
	AddNewCategoryPage addCategory;
	String newCategory;

	public CategorySteps(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@When("clicks on new category button")
	public void clicks_on_new_category_button() {
		category = testContextSetup.pageObjectManager.getCategoryPage();
		category.clickNewButton();
	}
	
	@When("adds a new category")
	public void adds_a_new_category(String categoryName) {
		addCategory = testContextSetup.pageObjectManager.getAddNewCategoryPage();
		newCategory = categoryName;
		addCategory.setNameTF(categoryName);
		addCategory.clickSaveButton();
	}

	@Then("new category should be added to category list")
	public void new_category_should_be_added_to_category_list() {
		System.out.println(category.getSuccessAlert());
	}

	@When("user deletes the added category")
	public void user_deletes_the_added_category() {
		category.deleteCategory(testContextSetup.web, newCategory);
	}

	@Then("newly added category should be deleted from category list")
	public void newly_added_category_should_be_deleted_from_category_list() {
		System.out.println(category.getSuccessAlert());
	}
}
