import PageObjects.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void before() {
        super.before();
        loginPage = new LoginPage(driver,wait);
    }

    @Test
    public void successLogin() {
        String currentUrl=loginPage.successLogin();
        assertEquals("Fail","https://www.trendyol.com/" , currentUrl);

    }
}
