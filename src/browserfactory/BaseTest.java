package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 *  1. Create the package ‘browserfactory’ and create the
 * class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup
 * code inside the class ‘Base Test’.
 * 2. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 *
 * 1. LoginTest
 * 3. Write down the following test in the ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials()
 * Enter “tomsmith” for the username
 * Enter “SuperSecretPassword!” for the
 * password
 * Click on the ‘Login’ button
 * Verify the text “Secure Area”
 * Click on the ‘Logout’ button
 * Verify the text ‘You logged out of the secure area!’
 *
 * 2. verifyTheUsernameErrorMessage()
 *
 * Enter “tomsmith1” for the username
 * Enter “SuperSecretPassword!” for the
 * password
 * Click on the ‘Login’ button
 * Verify the error message “Your username is invalid!”
 *  *
 * 3. verifyThePasswordErrorMessage()
 *
 * Enter “tomsmith” for the username
 * Enter “SuperSecretPassword” for the
 * password
 * Click on the ‘Login’ button
 * Verify the error message “Your password is invalid!”
 */

public class BaseTest {


    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit();
    }
}
