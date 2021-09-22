package locate;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByCssPatternMatch2 {

	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.calculator.net/calorie-calculator.html");
		 driver.manage().window().maximize();
		 System.out.println("Identify all elements having attribute id starting with c");
		 List<WebElement> startswithidccss = driver.findElements(By.cssSelector("[id^='c']"));
		 System.out.println("Number of elements with attribute id starting with c = " +startswithidccss.size() );
		 for(WebElement element : startswithidccss)
		 {
			 System.out.println(element.getAttribute("id"));
		 }
		 System.out.println("Identify all elements having attribute name containing height");
		 List<WebElement> containsnameheightcss = driver.findElements(By.cssSelector("[name*='height']"));
		 System.out.println("Number of elements with attribute name containing height = " +containsnameheightcss.size() );
		 for(WebElement element : containsnameheightcss)
		 {
			 System.out.println(element.getAttribute("name"));
		 }
		 System.out.println("identify all elements havign attribute id ending with weight");
		 List<WebElement> endswithidweightcss = driver.findElements(By.cssSelector("[id$='weight']"));
		 System.out.println("Number of elements with attribute id ending with weight = " +endswithidweightcss.size() );
		 for(WebElement element : endswithidweightcss)
		 {
			 System.out.println(element.getAttribute("id"));
		 }
	}
}
