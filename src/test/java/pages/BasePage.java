package pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author oscar
 *
 */
public class BasePage {


	public static final String ANDROID_PACKAGEINSTALLER = "com.android.packageinstaller:id/";
	public static final String APP_PACKAGE_NAME = "com.cabify.qabify:id/";

	protected AndroidDriver driver;
	private boolean autoAcceptPermissions;

	public BasePage(AndroidDriver driver, boolean autoAcceptPermissions) {
		this.driver = driver;
		this.autoAcceptPermissions = autoAcceptPermissions;

		if(autoAcceptPermissions) {
			unlockPermissions();
		}
	}

	private void unlockPermissions() {
		driver.findElement(By.id(ANDROID_PACKAGEINSTALLER + "permission_allow_button")).click();
	}

	public boolean isAutoAcceptPermissions() {
		return autoAcceptPermissions;
	}

	public void setAutoAcceptPermissions(boolean autoAcceptPermissions) {
		this.autoAcceptPermissions = autoAcceptPermissions;
	}
}