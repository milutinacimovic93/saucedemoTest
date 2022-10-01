package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourKartPage extends BasePage{

    private WebElement continueShoppingButton;
    private WebElement checkout;
    private WebElement quantity;



    public YourKartPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getContinueShoppingButton() {
        return getDriver().findElement(By.id("continue-shopping"));
    }

    public WebElement getCheckout() {
        return getDriver().findElement(By.id("checkout"));
    }

    public WebElement getQuantity() {
        return getDriver().findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]"));
    }
}
