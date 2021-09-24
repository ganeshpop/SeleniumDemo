package com.bmi.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaloriePage {

	//identify elements of this page
	public WebElement ageTextbox;
	public List<WebElement> genderList;
	public WebElement heightfeetTextbox;
	public WebElement weightTextbox;
	public WebElement BMILink;
	public WebDriver driver ;

	public CaloriePage(WebDriver driver) {
		this.driver = driver;
	}

	//define the behaviors of this page
	public void EnterCalorieDetails(String age,String sex,String heightfeet,String weight){
		ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear();
		ageTextbox.sendKeys(age);

		List<WebElement>genderList = driver.findElements(By.name("csex"));
		System.out.println("Size of the List = " + genderList.size());
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

	heightfeetTextbox = driver.findElement(By.id("cheightfeet"));
	heightfeetTextbox.clear();
	heightfeetTextbox.sendKeys(heightfeet);

	WebElement weightTextbox = driver.findElement(By.id("cpound"));
	weightTextbox.clear();
	weightTextbox.sendKeys(weight);
	}

	public void BMILinkClick(){
		BMILink = driver.findElement(By.linkText("BMI"));
		BMILink.click();
	}
}
