package testng;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BMICalculatorHTTestCase {
	WebDriver driver = null;

	@BeforeClass
	public void LaunchBrowser(){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/bmi-calculator.html");
		driver.manage().window().maximize();
	}

	@Test(dataProvider="getBMIData")
	public void EnterBMIDetails(Hashtable<String,String> data) throws InterruptedException{
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear();
		ageTextbox.sendKeys(data.get("age"));
		List<WebElement>genderList = driver.findElements(By.name("csex"));
		if(genderList.size()>0){
			for(WebElement gender : genderList){
				if(gender.getAttribute("value").equals(data.get("sex"))){
					if(!gender.isSelected()){
						gender.click();
						break;
					}
				}
			}
	   }
		Thread.sleep(4000);
	}
	@DataProvider
	public Object[][] getBMIData(){
/*		String[][] bmidata = new String[3][2];
		//3 sets of testdata + 2 cols in each data set - age and gender
		bmidata[0][0] = "45";
		bmidata[0][1] = "f";
		bmidata[1][0] = "56";
		bmidata[1][1] = "m";
		bmidata[2][0] = "67";
		bmidata[2][1] = "f";
		return bmidata;
*/
		Hashtable<String,String> rec1 = new Hashtable<>();
		rec1.put("age","45");
		rec1.put("sex","f");

		Hashtable<String,String> rec2 = new Hashtable<>();
		rec2.put("age","56");
		rec2.put("sex","m");

		Hashtable<String,String> rec3 = new Hashtable<>();
		rec3.put("age","67");
		rec3.put("sex","f");

		Object[][] bmidata = new Object[3][1];
		bmidata[0][0] = rec1;
		bmidata[1][0] = rec2;
		bmidata[2][0] = rec3;

		return bmidata;
	}


	@AfterClass
	public void CloseBrowser(){
		if(driver!=null){
			driver.quit();
		}
	}
}
