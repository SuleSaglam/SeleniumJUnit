import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class A04 extends TestBase {

    @Test
    public void test01() {
        // Kiwi anasayfa adresine gidin.
        driver.get(https+"kiwi.com");
        String  kiwiWHD = driver.getWindowHandle();

        // Sayfa title’nin “kiwi” icerdigini test edin
        String expectedTitleKiwi = "Kiwi";
        String actualTitleKiwi = driver.getTitle();

        Assert.assertTrue(actualTitleKiwi.contains(expectedTitleKiwi));

        // Yeni bir tab olusturup, acilan tab’da amazon adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(https+"amazon.com");

        String amazonWHD="";

        Set<String> tumSayfalarWHD = driver.getWindowHandles();

        for (String eachWHD: tumSayfalarWHD) {
            if (!eachWHD.equals(kiwiWHD)) {
                eachWHD = amazonWHD;
            }
        }

        // Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitleAmazon = "Amazon";
        String actualTitleAmazon = driver.getTitle();

        Assert.assertTrue(actualTitleAmazon.contains(expectedTitleAmazon));

        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(https+"walmart.com");

        String walmartWHD="";

        for (String eachWHD: tumSayfalarWHD) {
            if (!eachWHD.contains(amazonWHD) && eachWHD.contains(amazonWHD)) {
                eachWHD = walmartWHD;
            }
        }

        // Sayfa title’nin “Walmart” icerdigini test edin
        String expectedTitleWalmart = "Walmart";
        String actualTitleWalmart = driver.getTitle();

        Assert.assertTrue(actualTitleAmazon.contains(expectedTitleAmazon));

        // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWHD);

        String expectedAmazonUrl = "amazon";
        String actualAmazonUrl = driver.getCurrentUrl();

    }
}
