package com.bmi.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmi.objectmap.ObjectRepos;

public class CaloriePage2 {

	//identify elements of this page
	//@FindBy(id="cage")
	@FindBy(id=ObjectRepos.CaloriePage.cp_age_id)
	public WebElement ageTextbox;

	//@FindBy(name="csex")
	@FindBy(name=ObjectRepos.CaloriePage.cp_genderList_name)
	public List<WebElement> genderList;

	//@FindBy(id="cheightfeet")
	@FindBy(id=ObjectRepos.CaloriePage.cp_heightfeet_id)
	public WebElement heightfeetTextbox;

	//@FindBy(id="cpound")
	@FindBy(id=ObjectRepos.CaloriePage.cp_weight_id)
	public WebElement weightTextbox;

	//@FindBy(linkText="BMI")
	@FindBy(linkText=ObjectRepos.CaloriePage.cp_bmilink_linktext)
	public WebElement BMILink;

	public WebDriver driver ;

	public CaloriePage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//define the behaviors of this page
	public void EnterCalorieDetails(String age,String sex,String heightfeet,String weight){
		ageTextbox.clear();
		ageTextbox.sendKeys(age);

		//genderList = driver.findElements(By.name("csex"));
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

	heightfeetTextbox.clear();
	heightfeetTextbox.sendKeys(heightfeet);

	weightTextbox.clear();
	weightTextbox.sendKeys(weight);
	}

	public BMIPage2 BMILinkClick(){
		BMILink.click();
		return new BMIPage2(driver);
	}
}
