package exception;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingFrames {
	public static WebDriver webDriver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get("https://jqueryui.com/droppable/");
		webDriver.manage().window().maximize();
		//identify frame element
		WebElement frameElement = webDriver.findElement(By.className("demo-frame"));

		webDriver.switchTo().frame(frameElement);
//		webDriver.switchTo().frame(1); //NoSuchFrameException
		WebElement source = webDriver.findElement(By.id("draggable"));
		WebElement destination = webDriver.findElement(By.id("droppable"));
		Thread.sleep(2000);
		//Scroll the destination element into view
		JavascriptExecutor js  = (JavascriptExecutor) webDriver;
		Actions actions = new Actions(webDriver);
		actions.dragAndDrop(source, destination).build().perform();
		if(destination.getText().equals("Dropped!")){
			System.out.println("Drop successful");
		}
		else
			System.out.println("Drop was not successful");
		Thread.sleep(2000);
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		webDriver.switchTo().defaultContent();
		js.executeScript("arguments[0].scrollIntoView();", webDriver.findElement(By.cssSelector("#content > div.view-source > a")));
		Thread.sleep(2000);
		webDriver.close();
		//js.executeScript("window.scrollTo(0, 300)");

	}
}
