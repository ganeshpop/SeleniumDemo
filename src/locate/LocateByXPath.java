package locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXPath {
    public static WebDriver webDriver = null;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.calculator.net/calorie-calculator.html");
        webDriver.manage().window().maximize();
        WebElement AgeLabelByAbsXPath = webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/table[1]/tbody/tr[1]/td[1]"));
        System.out.println("AgeLabel by Abs XPath = " + AgeLabelByAbsXPath.getText());
        WebElement AgeLabelByRelXPath = webDriver.findElement(By.xpath("//*[@id='calinputtable']/tbody/tr[1]/td[1]"));
        System.out.println("AgeLabel by Rel XPath = " + AgeLabelByRelXPath.getText());
        webDriver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/table[4]/tbody/tr[3]/td[2]/input[2]")).click();
		Thread.sleep(3000);
//		webDriver.close();
    }
}
