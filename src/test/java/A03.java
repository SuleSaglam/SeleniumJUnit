import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class A03 extends TestBase {

    @Test
    public void test01() {
        // amazon sayfasina gidin
        driver.get(https+"amazon.com");

        // Dropdown menuden software'i secin
        WebElement dropdownElementi = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(dropdownElementi);
        select.selectByVisibleText("Software");

        // Dropdown menuden software'in secildigini test edin
        String expectedSecilenOptions = "Software";
        String actualSecilenOptions = select.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedSecilenOptions, actualSecilenOptions);

        // Dropdown menudeki secenek sayisinin 28 oldugunu test edin
        List<WebElement> optionsWebElement = select.getOptions();

        int expectedOptionSayisi = 28;
        int actualOptionSayisi = optionsWebElement.size();

        Assert.assertEquals(expectedOptionSayisi, actualOptionSayisi);

        // Arama kutusuna Selenium yazarak, aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium" + Keys.ENTER);

        // title'in Selenium icerdigini test edin
        String expectedTitle = "Selenium";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
