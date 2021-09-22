package locate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlertPopups {
	public static WebDriver webDriver = null;
	public static void main(String[] args) throws InterruptedException {
		JavascriptExecutor js = null;
		Alert alert = null;
		String alertMessage = null;
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		 webDriver = new ChromeDriver();
		 webDriver.get("https://www.google.co.in/");
		 webDriver.manage().window().maximize();
		 //Invoke a JavaScript alert to popUp an information Alert
		 //for this we use an interface named JavascriptExecutor
		 //when we cast the driver object with JavascriptExecutor, it exposes the
		 //method executeScript which is used for executing or invoking javaScripts
		 js = (JavascriptExecutor) webDriver;
		 js.executeScript("alert('This is an information Message');");
		 //Switch to the Alert is necessary to handle the alert - otherwise we cannot perform any operation
		 //on alert
	     alert = webDriver.switchTo().alert();
		 alertMessage = alert.getText();
		 Thread.sleep(3000);
	     alert.accept(); //Click on OK button
		 if(alertMessage.equals("This is an information Message")){
			 System.out.println("Alert Message - Match Found");
		 }
		 else
		 {
			 System.out.println("Alert Message - Match Not Found");
		 }

		 js = (JavascriptExecutor) webDriver;
		 js.executeScript("confirm('Do you want to continue(y/n)?');");
		 //Switch to the Alert is necessary to handle the alert - otherwise we cannot perform any operation
		 //on alert
	     alert = webDriver.switchTo().alert();
		 alertMessage = alert.getText();
		 Thread.sleep(3000);
		 alert.dismiss();; //Click on Cancel button
		 if(alertMessage.equals("This is an information Message")){
			 System.out.println("Alert Message - Match Found");
		 }
		 else
		 {
			 System.out.println("Alert Message - Match Not Found");
		 }
	}
}
