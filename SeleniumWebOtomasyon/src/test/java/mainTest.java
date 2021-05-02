import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class mainTest {
    protected WebDriver driver ;

    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ümran\\IdeaProjects\\SeleniumWebOtomasyon\\drivers\\chromedriver1.exe");
        driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }

}
