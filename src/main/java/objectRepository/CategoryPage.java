package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CategoryPage {

	// Declaration

		@FindBy(xpath = "//h1[normalize-space(text())='Category']")
		private WebElement pageHeader;

		@FindBy(xpath = "//div[contains(@class,'alert-success')]")
		private WebElement successAlert;

		@FindBy(xpath = "//a[text()=' New']")
		private WebElement newButton;

		private String commonDeletePath = "//td[text()='%s']/following-sibling::td/child::button[text()=' Delete']";

		@FindBy(name = "delete")
		private WebElement deleteButton;

		// Initialization

		public CategoryPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		// Utilization

		public boolean pageHeaderIsDisplayed() {
			if (pageHeader.isDisplayed())
				return true;
			else
				return false;
		}
		
		public void clickNewButton() {
			newButton.click();
		}
		
		public void deleteCategory(WebDriverUtility web, String categoryName) {
			web.convertDynamicXpathToWebElement(commonDeletePath, categoryName).click();
			deleteButton.click();
		}
		
		public String getSuccessAlert() {
			return successAlert.getText();
		}
}
