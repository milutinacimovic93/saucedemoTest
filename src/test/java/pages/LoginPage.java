package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class LoginPage extends BasePage{

    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;

    public LoginPage() {

    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUsernameField() {
        return getDriver().findElement(By.id("user-name"));
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(By.id("login-button"));
    }

    public void login(String username, String password) {
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }



}
