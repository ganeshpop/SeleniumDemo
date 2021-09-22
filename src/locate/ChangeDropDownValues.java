package locate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChangeDropDownValues {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.calculator.net/calorie-calculator.html");
			driver.manage().window().maximize();
			WebElement Activitydd = driver.findElement(By.id("cactivity"));
			//Create an instance of Select class which takes dropdown element as argument 
			//it exposes 3 methods - selecrByValue, selectByIndex, selectByVisibleText
			Select dd = new Select(Activitydd);
			System.out.println("Default DropDownValue is " + dd.getFirstSelectedOption().getText());
			dd.selectByIndex(1);
			Thread.sleep(2000);
			System.out.println("Changing Dropdown value by index = 1 - Sedentry = " + dd.getFirstSelectedOption().getText());
			dd.selectByValue("1.55");
			Thread.sleep(2000);
			System.out.println("Changing Dropdown value by value = 1.55 - Active = " + dd.getFirstSelectedOption().getText());
			dd.selectByVisibleText("Extra Active: very intense exercise daily, or physical job");
			Thread.sleep(2000);
			System.out.println("Changing Dropdown value by VIsible Text - Extra Active = " + dd.getFirstSelectedOption().getText());
			System.out.println("Is Dropdown Multi select = " + dd.isMultiple()); //returns truw implies it is multiselect
			//Identify using text()
			WebElement ExtraActive = driver.findElement(By.xpath("//*[@id='cactivity']/option[text()='Extra Active: very intense exercise daily, or physical job']"));
			System.out.println(ExtraActive.getText());
			List<WebElement> ActiveoptList = driver.findElements(By.xpath("//*[@id='cactivity']/option[contains(text(),'Active')]"));
			for(WebElement option:ActiveoptList){
				System.out.println(option.getText());
			}
	}

}
