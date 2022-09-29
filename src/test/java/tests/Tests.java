package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.YourKartPage;

public class Tests {

    private LoginPage loginPage;
    private HomePage homePage;
    private YourKartPage yourKartPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://Users//ROG//IdeaProjects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        yourKartPage = new YourKartPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.login("standard_user", "secret_sauce");
        String expectedResult = "PRODUCTS";
        String actualResult = loginPage.getDriver().findElement(By.className("title")).getText();
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testAddToKart() {
        testLogin();
        homePage.getAddToKart().click();
        Assert.assertTrue(homePage.getRemoveButton().isDisplayed());
    }

    @Test
    public void checkout() {
        testAddToKart();
        homePage.getCheckout().click();
        yourKartPage.getCheckout().click();
        String expectedResult = "PRODUCTS";
        String actualResult = loginPage.getDriver().findElement(By.className("title")).getText();
        Assert.assertEquals(expectedResult,actualResult);
    }

    @AfterClass
    public void afterClass() {
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loginPage.getDriver().quit();
    }

}
