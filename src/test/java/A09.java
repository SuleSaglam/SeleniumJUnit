import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class A09 extends TestBase {

    @Test
    public void test01() {
        // Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        // Verify that home page is visible successfully
        WebElement anaSayfa = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));

        Assert.assertTrue(anaSayfa.isDisplayed());

        // Scroll down to footer
        anaSayfa.sendKeys(Keys.END);

        // Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//*[text()='Subscription']"));

        // Enter email address in input and click arrow button
        // Verify success message 'You have been successfully subscribed!' is visible
    }
}
