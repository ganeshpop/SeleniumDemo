package com.bmi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bmi.objectmap.ObjectRepos;

public class BMIPage2 {

	//@FindBy(xpath="//*[@id='cage']")
	@FindBy(xpath=ObjectRepos.BMIPage.bp_age_xpath)
	public WebElement ageTextbox;

	public WebDriver driver;
	public BMIPage2(WebDriver driver) {
		this.driver  = driver;
		//PageFactory.initElements(driver, this);
	}

	public void setAge(String age){
		ageTextbox.clear();
		ageTextbox.sendKeys(age);

	}

	public String getAge(){
		return ageTextbox.getAttribute("value");
	}
}
