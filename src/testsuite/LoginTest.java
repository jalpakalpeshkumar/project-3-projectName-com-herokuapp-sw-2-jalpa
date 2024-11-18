package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    // open browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter username and password into email and password field
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Click on the ‘Login’ button
        driver.findElement(By.xpath("//button")).click();

        //Verify the text “Secure Area”
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//div[@id='content']//h2")).getText();
        Assert.assertEquals("Text Secure Area not displayed",expectedText,actualText);

        //Click on the ‘Logout’ button
        driver.findElement(By.xpath("//div[@id='content']//a")).click();

        //Verify the text ‘You logged out of the secure area!’
        String expectedLogOutMessage = "You logged out of the secure area!";
        String actualLogOutMessage = driver.findElement(By.id("flash")).getText().trim().split("\n")[0];
        // System.out.println(actualLogOutMessage);
        Assert.assertEquals("Logout message not displayed", expectedLogOutMessage, actualLogOutMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter username and password into email and password field
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Click on the ‘Login’ button
        driver.findElement(By.xpath("//button")).click();

        //Verify the error message “Your username is invalid!”
        String expectedInvalidUsernameMessage = "Your username is invalid!";
        String actualInvalidUsernameMessage = driver.findElement(By.id("flash")).getText().trim().split("\n")[0];
        Assert.assertEquals("Invalid username error message not displayed ", expectedInvalidUsernameMessage, actualInvalidUsernameMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter username and password into email and password field
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        //Click on the ‘Login’ button
        driver.findElement(By.xpath("//button")).click();

        //Verify the error message “Your username is invalid!”
        String expectedInvalidPasswordMessage = "Your password is invalid!";
        String actualInvalidPasswordMessage = driver.findElement(By.id("flash")).getText().trim().split("\n")[0];
        Assert.assertEquals("Invalid password error message not displayed ", expectedInvalidPasswordMessage, actualInvalidPasswordMessage);

    }


    //Close browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
