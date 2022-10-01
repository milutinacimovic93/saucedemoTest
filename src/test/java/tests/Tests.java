package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutInformation;
import pages.HomePage;
import pages.LoginPage;
import pages.YourKartPage;

public class Tests {

    private LoginPage loginPage;
    private HomePage homePage;
    private YourKartPage yourKartPage;
    private CheckoutInformation checkInformationPage;
    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://Users//ROG//IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        yourKartPage = new YourKartPage(driver, driverWait);
        checkInformationPage = new CheckoutInformation(driver, driverWait);

    }

    @BeforeMethod
    public void load() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void testLogin() {
        loginPage.login("standard_user", "secret_sauce");
        String expectedResult = "PRODUCTS";
        String actualResult = loginPage.getDriver().findElement(By.className("title")).getText();
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test(priority = 2)
    public void testAddToKart() {
        loginPage.login("standard_user", "secret_sauce");
        homePage.getAddToKart().click();
        homePage.getCheckout().click();
        Assert.assertTrue(homePage.getRemoveButton().isDisplayed());
    }

    @Test(priority = 3)
    public void checkout() {
        loginPage.login("standard_user", "secret_sauce");
        WebElement kasa = homePage.getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        kasa.click();
        homePage.getCheckout().click();
        yourKartPage.getCheckout().click();
        String expectedResult = "CHECKOUT: YOUR INFORMATION";
        String actualResult = loginPage.getDriver().findElement(By.className("title")).getText();
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test(priority = 4)
    public void fillInformationTest() {
        loginPage.login("standard_user", "secret_sauce");
        WebElement kasa = homePage.getDriver().findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        kasa.click();
        homePage.getCheckout().click();
        yourKartPage.getCheckout().click();
        checkInformationPage.getFirstName().sendKeys("User");
        checkInformationPage.getLastName().sendKeys("Pass");
        checkInformationPage.getPostalCode().sendKeys("23233");
        checkInformationPage.getContinueButton().click();
        Assert.assertTrue(checkInformationPage.getFinish().isDisplayed());
        checkInformationPage.getFinish().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(checkInformationPage.getFinalPic().isDisplayed());
    }

    @Test(priority = 5)
    public void logOut() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        homePage.getMenuButton().click();
        Thread.sleep(2000);
        homePage.getLogout().click();
        Thread.sleep(1000);
        driver.get("https://www.saucedemo.com/cart.html");
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        String actualResult = errorMessage.getText();
        String expectedResult = "Epic sadface: You can only access '/cart.html' when you are logged in.";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterClass
    public void afterClass() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loginPage.getDriver().quit();
    }

}
