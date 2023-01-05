import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class A09 extends TestBase {

    @Test
    public void test01() {
        // Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        // Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));

        Assert.assertTrue(home.isDisplayed());

        // Scroll down to footer
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        // Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//*[text()='Subscription']"));

        Assert.assertTrue(subscription.isDisplayed());

        // Enter email address in input and click arrow button
        WebElement emailBox = driver.findElement(By.id("susbscribe_email"));
        emailBox.sendKeys("sglm@gmail.com");

        WebElement okayButton = driver.findElement(By.id("subscribe"));
        okayButton.click();

        // Verify success message 'You have been successfully subscribed!' is visible
        WebElement successMessage = driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));

        Assert.assertTrue(successMessage.isDisplayed());
    }
}
