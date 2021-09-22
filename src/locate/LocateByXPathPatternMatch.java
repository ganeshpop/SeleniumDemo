package locate;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXPathPatternMatch {

	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.calculator.net/calorie-calculator.html");
		 driver.manage().window().maximize();
		 System.out.println("Identify all elements having attribute id starting with c");
		 //Example of Exception in thread "main" org.openqa.selenium.InvalidSelectorException: invalid selector: Unable to locate an element with the xpath expression //[starts-with(@id,'c')] because of the following error:
		// List<WebElement> startswithidcxpath = driver.findElements(By.xpath("//[starts-with(@id,'c')]"));
		 List<WebElement> startswithidcxpath = driver.findElements(By.xpath("//*[starts-with(@id,'c')]"));
		 System.out.println("Number of elements with attribute id starting with c = " +startswithidcxpath.size() );
		 for(WebElement element : startswithidcxpath)
		 {
			 System.out.println(element.getAttribute("id"));
		 }
		 System.out.println("Identify all elements having attribute name containing height");
		 List<WebElement> containsnameheightxpath = driver.findElements(By.xpath("//*[contains(@name,'height')]"));
		 System.out.println("Number of elements with attribute name containing height = " +containsnameheightxpath.size() );
		 for(WebElement element : containsnameheightxpath)
		 {
			 System.out.println(element.getAttribute("name"));
		 }
		 System.out.println("identify all elements havign attribute id ending with weight");
		 List<WebElement> endswithidweightxpath = driver.findElements(By.xpath("//*[ends-with(@id,'weight')]"));
		 System.out.println("Number of elements with attribute id ending with weight = " +endswithidweightxpath.size() );
		 for(WebElement element : endswithidweightxpath)
		 {
			 System.out.println(element.getAttribute("id"));
		 }
	}
}
