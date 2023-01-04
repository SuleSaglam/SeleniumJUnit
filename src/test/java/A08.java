import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class A08 {

    static WebDriver driver;
    static String https = "https://www.";

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- amazon gidin
        driver.get(https+"amazon.com");
    }
    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void test01() {
        // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdownWebElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select = new Select(dropdownWebElementi);

        System.out.println(dropdownWebElementi.getText());

        // dropdown menude 28 eleman olduğunu doğrulayın
        List<WebElement> dropdownMenu = select.getOptions();

        int expectedOption = 28;
        int actualOption = dropdownMenu.size();

        Assert.assertEquals(expectedOption, actualOption);
    }

    @Test
    public void test02() {
        // dropdown menuden elektronik bölümü seçin
        WebElement dropdownWebElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownWebElementi);
        select.selectByVisibleText("Electronics");

        // Arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone" + Keys.ENTER);

        // Sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedsonucSayisiYazisi = "iphone";
        String actualsonucSayisiYazisi =
                driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();

        Assert.assertTrue(actualsonucSayisiYazisi.contains(expectedsonucSayisiYazisi));

        // Ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='s-image'])[9]"));
        WebElement ikinciUrun =
                driver.findElement(RelativeLocator.with(By.xpath("(//img[@class='s-image'])[10]")).toRightOf(ilkUrun));

        ikinciUrun.click();

        // Urünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        WebElement titleElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));
        String expectedTitle = titleElementi.getText();
        WebElement fiyat = driver.findElement(By.xpath("(//span[@aria-hidden='true'])[41]"));
        System.out.println(fiyat.getText());

        driver.findElement(By.id("add-to-cart-button")).click();
    }
}
