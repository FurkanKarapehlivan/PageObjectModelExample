package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "login-email")
    public WebElement usernameInput;

    @FindBy(id = "login-password-input")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@class='q-primary q-fluid q-button-medium q-button submit']")
    public WebElement loginButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookiesButton;

    public String successLogin() {
        usernameInput.sendKeys("test@test.com");
        passwordInput.sendKeys("test123");
        acceptCookiesButton.click(); // çıkan cookies showcase'inde Kabul et butonuna tıklar
        loginButton.click();
        wait.until(ExpectedConditions.urlToBe("https://www.trendyol.com/"));
        return driver.getCurrentUrl();
    }
}
