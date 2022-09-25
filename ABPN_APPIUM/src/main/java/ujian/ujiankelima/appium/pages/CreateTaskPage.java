package ujian.ujiankelima.appium.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateTaskPage {
	public AndroidDriver<MobileElement> driver;
	
	public CreateTaskPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	Page Factory
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/welcome_get_started")
	private MobileElement btnStarted;
	
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/tasks_fab")
	private MobileElement btnCreate;
	
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/add_task_title")
	private MobileElement taskTitle;
	
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/add_task_done")
	private MobileElement btnDone;
	
	@AndroidFindBy(id = "com.google.android.apps.tasks:id/task_name")
	private MobileElement txtTaskList;
	
//	Page Object
	public void testCreate(String taskTitle) throws InterruptedException {
		Thread.sleep(2000);
		btnStarted.click();
		Thread.sleep(2000);
		btnCreate.click();
		Thread.sleep(1000);
		this.taskTitle.sendKeys(taskTitle);
		Thread.sleep(1000);
		btnDone.click();
		Thread.sleep(2000);
	}
	
	public String getTxtTaskList() {
		return txtTaskList.getText();
	}
}
