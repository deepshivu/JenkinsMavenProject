package com.deepika.jenkins4;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleSeleniumTest {
    
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeClass
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait with 10 seconds timeout
    }
    
    @Test
    public void validateGoogleId() throws Exception {
        System.out.println("Opening Browser");
        driver.get("http://www.google.com");

        System.out.println("Clicking Gmail Link");
        WebElement gmailLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Gmail")));
        gmailLink.click();

        System.out.println("Clicking Sign In link");
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
        signInLink.click();

        System.out.println("Entering username");
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        usernameField.sendKeys("deepika9785");

        System.out.println("Clicking Next button");
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='identifierNext']/div/button/span")));
        nextButton.click();

     
    }
    
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
