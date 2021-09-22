package locate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByIdNameClass {

    static WebDriver webDriver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.calculator.net/bmi-calculator.html");
        webDriver.manage().window().maximize();
        //Importing all packages Ctrl+Shift+O
        //Identify Element ageTextBox by id Locator Strategy using findElement method
        //getAttribute + getTagName + clear + sendKeys + getCssValue
        WebElement webElementAgeTextBox = webDriver.findElement(By.id("cage"));
        System.out.println("attribute value of value = " + webElementAgeTextBox.getAttribute("value"));
        webElementAgeTextBox.clear();
        webElementAgeTextBox.sendKeys("50");
        //Retrieve all information pertaining ageTextBox
        System.out.println("attribute value of type = " + webElementAgeTextBox.getAttribute("type"));
        System.out.println("attribute value of id = " + webElementAgeTextBox.getAttribute("id"));
        System.out.println("attribute value of name = " + webElementAgeTextBox.getAttribute("name"));
        System.out.println("attribute value of class = " + webElementAgeTextBox.getAttribute("class"));
        System.out.println("attribute value of value = " + webElementAgeTextBox.getAttribute("value"));
        System.out.println("Tag name of age TextBox = " + webElementAgeTextBox.getTagName());
        System.out.println("Get css value of width = " + webElementAgeTextBox.getCssValue("width"));
        //Identify elements by name Locator Strategy + findElements + isSelected
        List<WebElement> genderList = webDriver.findElements(By.name("csex"));
        System.out.println("Size of the List = " + genderList.size());
        if (genderList.size() > 0) {
            for (WebElement gender : genderList) {
                if (gender.getAttribute("value").equals("f")) {
                    if (!gender.isSelected()) {
                        gender.click();
                        break;
                    }
                }
            }
            System.out.println("================================");
            //Identify elements by class + tagName + findElements + Extract WebTable
            WebElement Table = webDriver.findElement(By.className("cinfoT"));
            //w.r.t - we need to get rows - we are not getting all rows of all tables
            List<WebElement> Rows = Table.findElements(By.tagName("tr"));
            for (WebElement Row : Rows) {
                List<WebElement> Cols = Row.findElements(By.tagName("td"));
                for (WebElement Col : Cols) {
                    System.out.print(Col.getText() + "\t");
                }
                System.out.println("");
            }
            System.out.println("================================");
        }
        Thread.sleep(3000);
        webDriver.close();
    }
}
