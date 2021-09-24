package com.bmi.testcases;

import com.bmi.config.EnvSettings;
import com.bmi.pages.BMIPage2;
import com.bmi.pages.CaloriePage2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BMICalculatorPageTestCase {
    WebDriver driver;

    @Test
    public void EnterCalorieDetails() {
        System.setProperty("webdriver.chrome.driver", EnvSettings.QA.chromedriverpath);
        driver = new ChromeDriver();
        driver.get(EnvSettings.QA.appurl);
        driver.manage().window().maximize();
		/*CaloriePage cp = new CaloriePage (driver);
		cp. EnterCalorieDetails ("45", "f", "6", "200");
		cp. BMILinkclick();
		BMI Page bp = new BMI Page (driver);
		bp.setAge("67");
		System.out.println (bp.getAge());
		*/
        CaloriePage2 cp2 = new CaloriePage2(driver);
        cp2.EnterCalorieDetails("56", "m", "4", "160");
        BMIPage2 bp2;
        bp2 = PageFactory.initElements(driver, BMIPage2.class);
        bp2.setAge("78");
        System.out.println(bp2.getAge());
    }
}
