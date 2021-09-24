package testng;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BMICalculatorExcelTestCase {
	WebDriver driver = null;

	@BeforeClass
	public void LaunchBrowser(){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/bmi-calculator.html");
		driver.manage().window().maximize();
	}

	@Test(dataProvider="getBMIData")
	public void EnterBMIDetails(String age,String sex, String height) throws InterruptedException{
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear();
		ageTextbox.sendKeys(age);
		List<WebElement>genderList = driver.findElements(By.name("csex"));
		if(genderList.size()>0){
			for(WebElement gender : genderList){
				if(gender.getAttribute("value").equals(sex)){
					if(!gender.isSelected()){
						gender.click();
						break;
					}
				}
			}
	   }
		WebElement heightTextbox = driver.findElement(By.id("cheight"));
		heightTextbox.clear();
		heightTextbox.sendKeys(height);
		Thread.sleep(4000);
	}
	@DataProvider
	public Object[][] getBMIData() throws IOException{
		String filepath = System.getProperty("user.dir") + "/src/testdata";
		String filename  = "BMITestData.xlsx";
		String sheetname = "BMIDataSet";
		System.out.println(Arrays.deepToString(ExcelReader.ReadFromExcelToObjectArr(filepath, filename, sheetname)));
		return ExcelReader.ReadFromExcelToObjectArr(filepath, filename, sheetname);
	}


	@AfterClass
	public void CloseBrowser(){
		if(driver!=null){
			driver.quit();
		}
	}
}
