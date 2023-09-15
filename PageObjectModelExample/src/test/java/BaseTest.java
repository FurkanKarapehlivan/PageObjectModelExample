import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    public WebDriverWait wait;


    @BeforeEach
    public void before() {
        driver = createDriver("https://www.trendyol.com/giris");
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void afterTest() {
        driver.quit();
    }


    public WebDriver createDriver(String url) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        options.addArguments("--remote-allow-origins=*");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
