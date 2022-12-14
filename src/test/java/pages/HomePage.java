package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage{

    private WebElement menuButton;
    private WebElement shoppingKart;
    private WebElement addToKart;
    private WebElement removeButton;
    private WebElement checkout;
    private WebElement logout;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getMenuButton() {
        return getDriver().findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement getShoppingKart() {
        return getDriver().findElement(By.id("//*[@id=\"shopping_cart_container\"]/a"));
    }

    public WebElement getAddToKart() {
        return getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getRemoveButton() {
        return getDriver().findElement(By.id("remove-sauce-labs-backpack"));
    }

    public WebElement getCheckout() {
        return getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]"));
    }

    public WebElement getLogout() {
        return getDriver().findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"));
    }
}
