package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {

    private static WebDriver driver;

    private DriverHelper(){

    }

    public static WebDriver getDriver(){
     //  if(driver==null){
        if(driver==null || ((RemoteWebDriver) driver).getSessionId()==null){
            switch ("chrome"){
                case "chrome":
                    driver=new ChromeDriver();
                    break;

                case"farefox":
                    driver=new FirefoxDriver();
                    break;

                case "edge":
                    driver=new EdgeDriver();
                    break;

                default:
                    driver=new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    return driver;
    }

}
