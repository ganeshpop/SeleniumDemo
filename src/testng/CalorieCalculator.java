package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalorieCalculator {
    WebDriver webDriver;
    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.calculator.net/calorie-calculator.html");
        webDriver.manage().window().maximize();

    }
    @Test(priority=1)
    public void enterCalorieDetails() throws InterruptedException {
        WebElement ageLabel = webDriver.findElement(By.id("cage"));
        ageLabel.clear();
        ageLabel.sendKeys("45");
        WebElement heightLabel = webDriver.findElement(By.id("cheightmeter"));
        heightLabel.clear();
        heightLabel.sendKeys("160");
        WebElement weightLabel = webDriver.findElement(By.id("ckg"));
        weightLabel.clear();
        weightLabel.sendKeys("55");
        Select dropDown = new Select(webDriver.findElement(By.id("cactivity")));
        dropDown.selectByVisibleText("Extra Active: very intense exercise daily, or physical job");
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("#content > div.panel2 > table:nth-child(4) > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=image]:nth-child(2)")).click();
        Thread.sleep(3000);

    }

    @AfterMethod
    public void closeBrowser(){
        if(webDriver != null) webDriver.quit();
    }
}
