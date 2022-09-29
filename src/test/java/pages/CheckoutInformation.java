package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInformation extends BasePage{

    private WebElement firstName;
    private WebElement lastName;
    private WebElement postalCode;
    private WebElement continueButton;
    private WebElement finish;
    private WebElement finalPic;

    public CheckoutInformation(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstName() {
        return getDriver().findElement(By.id("first-name"));
    }

    public WebElement getLastName() {
        return getDriver().findElement(By.id("last-name"));
    }

    public WebElement getPostalCode() {
        return getDriver().findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton() {
        return getDriver().findElement(By.id("continue"));
    }

    public WebElement getFinish() {
        return getDriver().findElement(By.id("finish"));
    }

    public WebElement getFinalPic() {
        return getDriver().findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/img"));
    }

}
