package scenarios;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class AppiumTest extends AndroidSetup {

	@BeforeMethod
	public void setUp() throws Exception {
		prepareAndroidForAppium();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void successfullLogin1() throws InterruptedException {
		new LoginPage(driver).successfullLoginAdmin();
	}

	@Test
	public void successfullLogin2() throws InterruptedException {
		new LoginPage(driver).successfullLoginUser1();
	}

	@Test
	public void unSuccessfullLogin() throws InterruptedException {
		new LoginPage(driver).unSuccessfullLogin();
	}

}