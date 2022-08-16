package com.example.test;

import com.example.pages.BuscadorPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    public BuscadorPage buscadorPage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void inicializar() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        buscadorPage = new BuscadorPage(driver);
    }

    @AfterMethod
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

}
