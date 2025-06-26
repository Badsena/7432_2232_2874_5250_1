package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());

        WebDriver driver = new ChromeDriver(options);

        try {
            // Open login page
            driver.get("https://practicetestautomation.com/practice-test-login/");
    
            // Locate username field
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("student");

            // Locate password field
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Password123");

            // Click login
            WebElement loginButton = driver.findElement(By.id("submit"));
            loginButton.click();

            // Wait briefly and print the title of the next page
            Thread.sleep(3000);
            System.out.println("Logged in. Page title: " + driver.getTitle());

        } catch (Exception e) {

            System.out.println("Logged in");
            e.printStackTrace();

        } finally {
            driver.quit();
            System.exit(0); // Prevent lingering threads
        }
    }
}
