package ujian.ujiankelima.appium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EditTaskPage {
	public AndroidDriver<MobileElement> driver;
	public EditTaskPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	Page Factory
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/task_name")
	private MobileElement btnTask;
	
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/edit_details")
	private MobileElement details;
	
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/edit_due_date_hint")
	private MobileElement btnDate;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"20 September 2022\"]")
	private MobileElement dateValue;
	
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/dtp_done")
	private MobileElement btnDoneEdit;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	private MobileElement btnBack;
	
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/task_details")
	private MobileElement txtDetails;
	
//	Page Object
	public void testEdit(String details) throws Exception {
		btnTask.click();
		Thread.sleep(2000);
		this.details.sendKeys(details);
		Thread.sleep(500);
		btnDate.click();
		Thread.sleep(1000);
		dateValue.click();
		Thread.sleep(500);
		btnDoneEdit.click();
		Thread.sleep(500);
		btnBack.click();
		Thread.sleep(2000);
	}
	
	public String getTxtDetails() {
		return txtDetails.getText();
	}
}
