package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.TestUtil;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();


    public Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
            prop.load(fp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/ganesh.jadhav/Downloads/chromedriver_win32 (5)/chromedriver.exe");
            driver.set(new ChromeDriver());
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/ganesh.jadhav/Downloads/geckodriver-v0.31.0-win64/geckodriver.exe");
            driver.set(new FirefoxDriver());
        } else if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "/Users/ganesh.jadhav/Downloads/edgedriver_win64/msedgedriver.exe");
            driver.set(new EdgeDriver());
        } else {
            System.out.println("Please select the correct browser name");
        }
        getDriver().navigate().to(prop.getProperty("url"));
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITE_WAIT));
    }
}
