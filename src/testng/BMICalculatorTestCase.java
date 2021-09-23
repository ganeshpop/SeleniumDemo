package testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BMICalculatorTestCase {
	WebDriver driver = null;

	@BeforeClass
	public void LaunchBrowser(){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/bmi-calculator.html");
		driver.manage().window().maximize();
	}

	@Test(dataProvider="getBMIData")
	public void EnterBMIDetails(String age, String sexname) throws InterruptedException{
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		System.out.println("attribute value of value = "+ageTextbox.getAttribute("value"));
		ageTextbox.clear();
		ageTextbox.sendKeys(age);
		List<WebElement>genderList = driver.findElements(By.name("csex"));
		System.out.println("Size of the List = " + genderList.size());
		if(genderList.size()>0){
			for(WebElement gender : genderList){
				if(gender.getAttribute("value").equals(sexname)){
					if(!gender.isSelected()){
						gender.click();
						break;
					}
				}
			}
	   }
		Thread.sleep(10000);
	}
	@DataProvider
	public Object[][] getBMIData(){
		String[][] bmidata = new String[3][2];
		//3 sets of testdata + 2 cols in each data set - age and gender
		bmidata[0][0] = "45";
		bmidata[0][1] = "f";
		bmidata[1][0] = "56";
		bmidata[1][1] = "m";
		bmidata[2][0] = "67";
		bmidata[2][1] = "f";
		return bmidata;
	}


	@AfterClass
	public void CloseBrowser(){
		if(driver!=null){
			driver.quit();
		}
	}
}
