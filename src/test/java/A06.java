import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class A06 extends TestBase {

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText = "Opening a new window";
        String actualText = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();

        Assert.assertEquals(expectedText, actualText);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitleIlkSayfa = "The Internet";
        String actualTitleIlkSayfa = driver.getTitle();
        String ilkSayfaWHD = driver.getWindowHandle();

        Assert.assertEquals(expectedTitleIlkSayfa, actualTitleIlkSayfa);

        // Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        Set<String> tumSayfalarWHD = driver.getWindowHandles();

        String ikinciSayfaWHD="";

        for (String eachWHD: tumSayfalarWHD) {
            if (!eachWHD.equals(ilkSayfaWHD)) {
                ikinciSayfaWHD=eachWHD;
            }
        }

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu doğrulayın
        driver.switchTo().window(ikinciSayfaWHD);

        String expectedTitlelIkinciSayfa = "New Window";
        String actualTitleIkinciSayfa = driver.getTitle();

        Assert.assertEquals(expectedTitlelIkinciSayfa, actualTitleIkinciSayfa);

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    }
}
