package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage{

	By byUserId = By.id(APP_PACKAGE_NAME + "email");
	By byPassword = By.id(APP_PACKAGE_NAME + "password");
	By byLogin_Button = By.id(APP_PACKAGE_NAME + "email_sign_in_button");
	By byToken_Button = By.id(APP_PACKAGE_NAME + "token_button");

	public LoginPage(AndroidDriver driver) {
		super(driver, true);
	}

	private void doLoginTest(String user, String password, String token, boolean successfull){
		clearAndSendKeys(byUserId, user);
		clearAndSendKeys(byPassword, password);

		driver.findElement(byLogin_Button).click();

		try{
			driver.findElement(byToken_Button).click();
			if(!successfull) {
				org.testng.Assert.fail("Successful login with wrong credentials...");
			}
		}catch (NoSuchElementException e) {
			if(successfull) {
				org.testng.Assert.fail("Something is wrong with the LoginPage...");
			}
		}
	}

	public void successfullLoginAdmin() {
		doLoginTest("admin@example.com", "nmT8bSVJepgWrryx", "123456789", true);
	}

	public void successfullLoginUser1() {
		doLoginTest("user1@example.com", "password", "abcdefghi", true);
	}

	public void unSuccessfullLogin() {
		doLoginTest("pepe@example.com", "password", "", false);
	}

	protected void clearAndSendKeys(By by, String string){
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(string);
	}

}
