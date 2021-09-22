package locate;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleWindowNav {
	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.online.citibank.co.in/personal-banking/internet-banking");
		 driver.manage().window().maximize();
		 //Find Parent Window Handle
		 String ParentWindowId = driver.getWindowHandle();
		 System.out.println("Parent Window ID = " + ParentWindowId);
		 //Identify Login NOw button
		 WebElement LoginNow = driver.findElement(By.xpath("//*[@title='LOGIN NOW']"));
		 LoginNow.click();
		 //Now 2 windows are open
		 //To get the current number of open windows - you have to call getWindowHandles - each time
		 Set<String> winids = driver.getWindowHandles();
		 System.out.println("Number of Open Windows = " + winids.size());
		 Iterator<String> iter = winids.iterator();
		 //Get the 2 winids
		 String mainWindowID = iter.next();
		 String subWindowID = iter.next();
		 System.out.println("mainWindowID = " + mainWindowID);
		 System.out.println("subWindowID = " + subWindowID);
		 //switch to the subwindow
		 driver.switchTo().window(subWindowID);
		 WebDriverWait wait = new WebDriverWait(driver,30);
		 try{
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("User_Id")));
		 WebElement User_Id = driver.findElement(By.id("User_Id"));
		 User_Id.sendKeys("Selenium");
		 Thread.sleep(3000);
		 driver.close(); //Close the subwindow
		 //when you have frames in a window
		 driver.switchTo().defaultContent();
		 //driver.switchTo().window(mainWindowID);
		 //identify the Insurance in Main Window
		 driver.findElement(By.id("topMnuinsurance")).click();
		 }catch(NoSuchElementException e){
			e.printStackTrace();
		 }
	}
}
