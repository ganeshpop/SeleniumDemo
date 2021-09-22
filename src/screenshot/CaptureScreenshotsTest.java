package screenshot;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshotsTest {

    public static WebDriver webDriver = null;

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.online.citibank.co.in/personal-banking/internet-banking");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/a")).click(); //Login Button
        Set<String> windowHandles = webDriver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String mainWindowId = iterator.next();
        String subWindowId = iterator.next();
        webDriver.switchTo().window(subWindowId);
        CaptureScreenshot.capture(webDriver, "LoginPage");
    }

}
