package com.bmi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BMIPage {

	public WebElement ageTextbox;
	public WebDriver driver;
	public BMIPage(WebDriver driver) {
		this.driver  = driver;
	}

	public void setAge(String age){
		ageTextbox = driver.findElement(By.id("cage"));
		ageTextbox.clear();
		ageTextbox.sendKeys(age);

	}

	public String getAge(){
		return ageTextbox.getAttribute("value");
	}
}
