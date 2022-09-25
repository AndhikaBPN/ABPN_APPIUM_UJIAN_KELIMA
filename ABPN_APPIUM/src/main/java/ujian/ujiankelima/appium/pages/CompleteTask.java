package ujian.ujiankelima.appium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CompleteTask {
	public AndroidDriver<MobileElement> driver;
	public CompleteTask(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	Page Factory
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/tasks_item_completed_check")
	private MobileElement radioButton;
	
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/snackbar_text")
	private MobileElement txtComplete; //Task completed
	
//	Page Object
	public void testCompleted() throws InterruptedException {
		Thread.sleep(1000);
		radioButton.click();
		Thread.sleep(500);
	}
	
	public String getTxtComplete() {
		return txtComplete.getText();
	}
}
