package objectRepository;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	
	public LoginPage login;
	public HomePage home;
	public CourseListPage course;
	public CategoryPage category;
	public AddNewCoursePage addCourse;
	public AddNewCategoryPage addCategory;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage getLoginPage() {
		login = new LoginPage(driver);
		return login;
	}
	
	public HomePage getHomePage() {
		home = new HomePage(driver);
		return home;
	}
	
	public CourseListPage getCourseListPage() {
		course = new CourseListPage(driver);
		return course;
	}
	
	public CategoryPage getCategoryPage() {
		category = new CategoryPage(driver);
		return category;
	}
	
	public AddNewCoursePage getAddNewCoursePage() {
		addCourse = new AddNewCoursePage(driver);
		return addCourse;
	}
	
	public AddNewCategoryPage getAddNewCategoryPage() {
		addCategory = new AddNewCategoryPage(driver);
		return addCategory;
	}
}
