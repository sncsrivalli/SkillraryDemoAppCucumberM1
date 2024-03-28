package stepDefinitions;

import java.util.Map;

import genericUtilities.IConstantPath;
import genericUtilities.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.AddNewCoursePage;
import objectRepository.CourseListPage;

public class CourseListSteps {
	TestContextSetup testContextSetup;
	CourseListPage course;
	AddNewCoursePage addCourse;
	Map<String, String> map;
	
	public CourseListSteps(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@And("clicks on new course button")
	public void clicks_on_new_button() {
		course = testContextSetup.pageObjectManager.getCourseListPage();
		course.clickNewButton();
	}
	
	@When("adds a new course")
	public void adds_a_new_course() {
		addCourse = testContextSetup.pageObjectManager.getAddNewCoursePage();
		testContextSetup.excel.excelinit(IConstantPath.EXCEL_PATH);
		map = testContextSetup.excel.readFromExcel("Sheet1", "Add Course");
		addCourse.setNameTF(map.get("Name"));
		addCourse.selectCategory(testContextSetup.web, map.get("Category"));
		addCourse.setPriceTF(map.get("Price"));
		addCourse.setPhotoFilePath(map.get("Photo"));
		addCourse.setDescription(testContextSetup.web, map.get("Description"));
		addCourse.clickSaveButton();
	}

	@Then("new course should be added to course list")
	public void new_course_should_be_added_to_course_list() {
	    System.out.println(course.getSuccessAlert());
	}

	@When("user deletes the added course")
	public void user_deletes_the_added_course() {
	  course.deleteCourse(testContextSetup.web, map.get("Name"));
	}

	@Then("newly added course should be deleted from course list")
	public void newly_added_course_should_be_deleted_from_course_list() {
	    System.out.println(course.getSuccessAlert());
	}
}
