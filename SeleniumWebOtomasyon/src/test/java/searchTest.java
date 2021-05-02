import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class searchTest extends mainTest {
    @Test
    public void checkSearch() {

        //Arama kutucuğuna bilgisayar kelimesi girilir.
        WebElement findSearchBox = driver.findElement(By.className("sc-4995aq-4 dNPmGY"));
        findSearchBox.click();
        WebElement fillSearchBox = driver.findElement(By.className("sc-4995aq-0 sc-14oyvky-0 itMXHg"));
        fillSearchBox.sendKeys("bilgisayar");
        driver.findElement(By.className("qjixn8-0 sc-1bydi5r-0 hKfdXF")).click();


        WebDriverWait wait = new WebDriverWait(driver, 3);


        // Arama sonuçları sayfasından 2.sayfa açılır.
        driver.findElement(By.xpath(".//a[@href='https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2'")).click();

        //2.sayfanın açıldığı kontrol edilir.
        Assertions.assertTrue( wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//a[@href='https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2'"))));


        //Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
        driver.findElement(By.className("product-title ")).click();


        //Seçilen ürün sepete eklenir.
        WebElement addBasket = driver.findElement(By.id("add-to-basket"));
        addBasket.click();
        addBasket.clear();
        addBasket.sendKeys("1");

        WebElement goToBasket = driver.findElement(By.className("header-cart-hidden-link"));
        goToBasket.click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);


        //Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        WebElement basketPrice = driver.findElement(By.className("new-price"));
        String bPrice = basketPrice.getText();
        WebElement productPrice = driver.findElement(By.id("sp-price-lowPrice"));
        String pPrice = productPrice.getText();
        bPrice.compareTo(pPrice);

        //Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        WebElement numberOfProducts = driver.findElement(By.className("amount"));
        numberOfProducts.click();
        numberOfProducts.clear();
        numberOfProducts.sendKeys("1");
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("amount"), driver.findElement(By.className("amount")).getText()));
        List<WebElement> values = driver.findElements(By.className("amount"));
        values.get(1).click();

        Assertions.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("amount"), driver.findElement(By.className("amount")).getText())));



        //Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.className("btn-delete btn-update-item")).click();


    }

}