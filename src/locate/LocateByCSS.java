package locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByCSS {
    public static WebDriver webDriver = null;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.calculator.net/calorie-calculator.html");
        webDriver.manage().window().maximize();
        WebElement AgeLabelByRelCss = webDriver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(1) > td:nth-child(1)"));
        System.out.println("AgeLabel by Rel Css = " + AgeLabelByRelCss.getText());
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector(".panel > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > input:nth-child(2)")).click();
        Thread.sleep(2000);
		webDriver.close();
    }
}
