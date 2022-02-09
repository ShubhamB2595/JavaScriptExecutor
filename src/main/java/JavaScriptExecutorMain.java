import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class JavaScriptExecutorMain {

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavaScriptUtil.drawBorder(logo, driver);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File trgFile = new File(".\\screenshots\\logo.png");
        FileUtils.copyFile(srcFile, trgFile);
    }
}
