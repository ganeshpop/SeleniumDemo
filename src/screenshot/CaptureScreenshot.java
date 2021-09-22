package screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class CaptureScreenshot {
    public static boolean capture(WebDriver webDriver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) webDriver;
            File file = ts.getScreenshotAs(OutputType.FILE); //Screenshot
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/Screenshots/+ " + screenshotName + ".png"));
            return true;
        } catch (Exception e) {
            System.out.println("Capturing Screenshot Failed");
            return false;
        }
    }
}
