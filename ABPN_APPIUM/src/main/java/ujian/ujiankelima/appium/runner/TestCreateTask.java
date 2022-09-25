package ujian.ujiankelima.appium.runner;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ujian.ujiankelima.appium.pages.CompleteTask;
import ujian.ujiankelima.appium.pages.CreateTaskPage;
import ujian.ujiankelima.appium.pages.EditTaskPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestCreateTask {
	private static AndroidDriver<MobileElement> driver;
	private static AndroidDriver driver1;
	private CreateTaskPage createTask;
	private EditTaskPage editTask;
	private CompleteTask completeTask;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ASUS_Z01QD");
		capabilities.setCapability("uuid", "127.0.0.1:21513");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("appPackage", "com.google.android.apps.tasks");
		capabilities.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@BeforeMethod
	public void pageObject() {
		driver.rotate(ScreenOrientation.PORTRAIT);
		createTask = new CreateTaskPage(driver);
		editTask = new EditTaskPage(driver);
		completeTask =  new CompleteTask(driver);
	}
	
	@AfterTest
	public void closeApp() {
		driver.quit();
	}
	
	@Test(priority = 0)
	public void testCreate() throws Exception {
		String title = "Game Dev";
		createTask.testCreate(title);
		assertTrue(createTask.getTxtTaskList().contains(title));
	}
	
	@Test(priority = 1)
	public void testEdit() throws Exception {
		String detail = "Game core";
		editTask.testEdit(detail);
		assertTrue(editTask.getTxtDetails().contains(detail));
	}
	
	@Test(priority = 2)
	public void testCompleted() throws Exception {
		completeTask.testCompleted();
		assertTrue(completeTask.getTxtComplete().contains("completed"));
	}
}
