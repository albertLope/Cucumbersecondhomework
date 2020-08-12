package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {

    private static WebDriver driver;

    public static WebDriver getDriver(){

//        if the driver is == null then create a driver if not then give me current driver
        if(driver==null){
            WebDriverManager.chromedriver().setup(); // this line is for System.setproperty
            driver = new ChromeDriver();
        }

        return driver;

    }



    /*
        We are going to call this method after each scenario.

     */
    public static void QuitDriver(){

        if(driver!=null){
            driver.quit();
            driver=null; // if we dont type this line next scenario will fail error is NoSuchSessionException
        }
    }

}
