package manage;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManage {

    static WebDriver driver;
    DesiredCapabilities capabilities=new DesiredCapabilities();



    public WebDriver setupChromeDriver(){
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("126.0.6478.127");

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.merge(capabilities);
        try {
            driver= new RemoteWebDriver(new URL("http://192.168.2.98:4444"),chromeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Remote Chrome Driver ");
        return driver;
    }

    public WebDriver setupFirefoxDriver (){
        capabilities.setPlatform(Platform.ANY);
        capabilities.setVersion("128.0");
        FirefoxOptions firefoxOptions=new FirefoxOptions();

        firefoxOptions.merge(capabilities);

        try {
            driver=new RemoteWebDriver(new URL("http://192.168.2.98:4444"),firefoxOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Remote Firefox Driver ");
        return driver;
    }


    public WebDriver setupEdgeDriver(){

        capabilities.setPlatform(Platform.WIN11);
        capabilities.setBrowserName("edge");
        capabilities.setVersion("126.0.2592.87");


        EdgeOptions edgeOptions = new EdgeOptions();

        edgeOptions.merge(capabilities);


        try {
            driver = new RemoteWebDriver(new URL("http://192.168.2.98:4444"), edgeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        System.out.println("***** Remote Edge Driver *****");

        return driver;



    }
}
