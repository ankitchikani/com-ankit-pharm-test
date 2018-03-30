package page_object;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class ScreenShotsTaken {
    public static WebDriver driver;


    public static void captureScreenshot( String screenshotName ){
        try {
            driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File("./Screenshot/"+screenshotName+".png"));
        System.out.println(screenshotName+"  : Screenshot is taken");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception while taking screenshot"+ e.getMessage());
        }

    }
}


