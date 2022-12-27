import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

     /*
         https://www.teknosa.com/ adresine gidin
         Arama cubuguna "oppo" yazin
         Cikan sonuc sayisini yazdirin
         Cikan ilk urune tiklayin
         Sepete ekleyiniz
         Sepetime git'e tiklayin
         consol da "Siparis Ozeti" webelementinin text'ini yazdirin
         Alisverisi tamamlayin'a tikla
         Son olarak "Teknosa'ya hos geldiniz" webelementinin text'ini yazdirin
      */

public class A01 {

    public class soru1 {

        WebDriver driver;

        @Before
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        }

        @After
        public void teardown() {
            driver.close();
        }

        @Test
        public void test() {

            driver.get("https://www.teknosa.com/");

            driver.findElement(By.id("search-input")).sendKeys("oppo" + Keys.ENTER);

            WebElement sonucSayisi = driver.findElement(By.className("plp-info"));
            System.out.println("Sonuc sayisi : " + sonucSayisi.getText());

            driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();

            WebElement sepeteEkle= driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]"));
            sepeteEkle.sendKeys(Keys.PAGE_DOWN);
            sepeteEkle.click();

            driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();

            WebElement siparisOzet = driver.findElement(By.xpath("//div[@class='cart-sum-body']"));
            System.out.println("Siparis Ozeti : " + siparisOzet.getText());

            driver.findElement(By.xpath("//*[text()='Alışverişi Tamamla']")).click();

            System.out.println(driver.findElement(By.xpath("//*[text()='Teknosa’ya Hoş Geldiniz']")).getText());

        }
    }
}
