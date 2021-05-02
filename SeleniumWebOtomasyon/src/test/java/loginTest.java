import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;


public class loginTest extends mainTest {


    @Test
    public void checkLogin() {

       // driver.findElement(By.xpath("//div[@data-cy='header-user-menu']// input[@class='gekhq4-5 grTfZj']"));
       // WebDriverWait wait = new WebDriverWait(driver, 3);
       // WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myBtn")));

        WebElement loginButton = driver.findElement(By.id("myBtn"));
        driver.findElement(By.id("myBtn"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        WebElement email = driver.findElement(By.id("L-UserNameField"));
        email.click();
        email.sendKeys("namelastname@mail.com");




        WebElement password = driver.findElement(By.id("L-PasswordField"));
        password.click();
        password.sendKeys("asdfgh");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.id("gg-login-enter")).click();



        //Login işlemi kontrol edilir.
        Assertions.assertEquals("namelastname@mail.com",email.getText());
        Assertions.assertEquals("asdfgh",password.getText());
    }



}
