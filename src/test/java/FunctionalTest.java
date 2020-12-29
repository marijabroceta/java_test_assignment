import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;


public class FunctionalTest{

    protected static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        Path path = FileSystems.getDefault().getPath("src/test/resources/geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", path.toString());
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("marionette", true);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @AfterEach
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

//    @AfterAll
//    public static void tearDown(){
//        driver.close();
//    }
}
