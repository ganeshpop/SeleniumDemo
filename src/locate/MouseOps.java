package WebDriverAdv;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseOps {

	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://demo.opencart.com/");
		 driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(TimeUnit.SECONDS, 5);
		 //Identify Components Menu
		 WebElement ComponentsMenu = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/a"));
		 ComponentsMenu.click();
		 WebDriverWait wait = new WebDriverWait(driver,30);
		 //check for the presence of Printer Element
		 try
		 {
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/div/div/ul/li[3]/a")));
		 	 WebElement PrinterElement = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/div/div/ul/li[3]/a"));
		 	// PrinterElement.click();
		 	 Actions actions = new Actions(driver);
		 	 //consolidate all mouse operation
		 	 //Build - is used to conolidate all your mouse operations in sequence 
		 	 //perform - trigger the consolidated mouse operations in sequence
		 	 actions.moveToElement(PrinterElement).click().build().perform();
		 }
		 catch(NoSuchElementException e){
			 System.out.println("Printer Element is not found");
		 }
	}

}
