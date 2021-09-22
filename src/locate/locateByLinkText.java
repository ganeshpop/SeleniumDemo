package locate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locateByLinkText {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/bmi-calculator.html");
		driver.manage().window().maximize();
		System.out.println("Title of BMI Page = " + driver.getTitle());
		System.out.println("Current URL of BMI Page = " + driver.getCurrentUrl());
		String BMIPageSource = driver.getPageSource();
		System.out.println("BMI Page Source = " + BMIPageSource);
		WebElement CalorieLink = driver.findElement(By.linkText("Calorie"));
		CalorieLink.click();
		//Back Arrow is enabled -Click on Back to navigate back to BMI Page
		Thread.sleep(3000);
		System.out.println("Title of Calorie Page = " + driver.getTitle());
		System.out.println("Current URL of Calorie Page = " + driver.getCurrentUrl());

		driver.navigate().back();
		Thread.sleep(3000);
		//BMI Page
		System.out.println("Title of BMI Page = " + driver.getTitle());
		System.out.println("Current URL of BMI Page = " + driver.getCurrentUrl());
		Thread.sleep(3000);
		driver.navigate().forward();
		System.out.println("Title of Calorie Page = " + driver.getTitle());
		System.out.println("Current URL of Calorie Page = " + driver.getCurrentUrl());
		//Identify Calorie Home Page by Partial Link Text Weight to point to thr first element match which ideal Weight
		WebElement IdealWeight = driver.findElement(By.partialLinkText("Weight"));
		IdealWeight.click();
		Thread.sleep(3000);
		System.out.println("Title of Ideal Weight Page = " + driver.getTitle());
		System.out.println("Current URL of Ideal Weight Page = " + driver.getCurrentUrl());
		//identify age element Ideal Weight
		WebElement ageTextBox = driver.findElement(By.id("cage"));
		ageTextBox.sendKeys("56");
		driver.navigate().refresh(); //it will reload the page
		Thread.sleep(3000);;
		ageTextBox = driver.findElement(By.id("cage"));//Identifying again after reloading page
		ageTextBox.clear(); //This step will throw StaleElementReference Exception -
		//after the page is reloaded due to refresh - it will not longer be able to identify the element because element has become stale
		//and requires fresh identification to perform operation on that element
		ageTextBox.sendKeys("67");
	}
}
