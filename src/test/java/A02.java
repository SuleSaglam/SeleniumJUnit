import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class A02 {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void tes01() throws InterruptedException {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirst).perform();

        // 3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();

        // 4- Popup mesajini yazdirin
        String popupMesaji = driver.switchTo().alert().getText();
        System.out.println(popupMesaji);

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.id("click-box"));

        actions.doubleClick(clickAndHold).perform();

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        String clickAndHoldYazisi = driver.findElement(By.id("click-box")).getText();
        System.out.println(clickAndHoldYazisi);

        // 8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMe = driver.findElement(By.id("double-click"));
        Thread.sleep(3000);
        actions.doubleClick(doubleClickMe).perform();
        Thread.sleep(3000);

        // 9- “Double click me" butonunu cift tikladiktan sonra rengin yesil oldugunu test edin
        WebElement yesilDoubleClickMe = driver.findElement(By.xpath("//div[@class='div-double-click double']"));

        Assert.assertTrue(yesilDoubleClickMe.isDisplayed());
    }
}
