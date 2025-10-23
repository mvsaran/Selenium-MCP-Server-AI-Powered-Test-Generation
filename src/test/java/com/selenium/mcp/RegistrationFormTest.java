package com.selenium.mcp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class RegistrationFormTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testRegistrationForm() {
        // Navigate to the registration page
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        // Fill in the registration form
        driver.findElement(By.id("customer.firstName")).sendKeys("John");
        driver.findElement(By.id("customer.lastName")).sendKeys("Doe");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Fake Street");
        driver.findElement(By.id("customer.address.city")).sendKeys("Faketown");
        driver.findElement(By.id("customer.address.state")).sendKeys("FT");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("5551234567");
        driver.findElement(By.id("customer.ssn")).sendKeys("123-45-6789");
        driver.findElement(By.id("customer.username")).sendKeys("johndoe123");
        driver.findElement(By.id("customer.password")).sendKeys("password123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("password123");

        // Submit the form
        driver.findElement(By.xpath("//input[@value='Register']")).click();

        // Wait for and verify successful registration
        WebElement welcomeMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h1[contains(text(),'Welcome') or contains(text(),'success')]")));

        Assert.assertTrue(welcomeMessage.isDisplayed(), "Registration was not successful");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
