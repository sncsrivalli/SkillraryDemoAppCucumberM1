package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;


public class AddNewCoursePage {
	
	@FindBy(xpath = "//h4/b[.='Add New Course']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameTF;
	
	@FindBy(xpath = "//select[@id='category']")
	private WebElement categoryDropdown;
	
	@FindBy(xpath = "//input[@id='price']")
	private WebElement priceTF;
	
	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement photoUploadButton;
	
	@FindBy(xpath = "//html/body/p")
	private WebElement descriptionFrame;
	
	@FindBy(xpath = "//button[@name='add']")
	private WebElement saveButton;
	
	public AddNewCoursePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void setNameTF(String name) {
		nameTF.sendKeys(name);
	}
	
	public void selectCategory(WebDriverUtility web, String text) {
		web.selectFromDropdown(text, categoryDropdown);
	}
	
	public void setPriceTF(String name) {
		priceTF.sendKeys(name);
	}
	
	public void setPhotoFilePath(String photoPath) {
		photoUploadButton.sendKeys(photoPath);
	}
	
	public void setDescription(WebDriverUtility web, String description) {
		web.switchToFrame(0);
		descriptionFrame.sendKeys(description);
		web.switchToDefaultWindow();;
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}

	
	
}
