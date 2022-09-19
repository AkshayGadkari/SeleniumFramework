package stepDefinitions;


import com.selenium.cbh.Utilities;
import com.selenium.cbh.base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;



public class Hooks extends base {


    public Hooks() {
    }


    // Following method will run Before  Every Scenario having tag @DesktopBrowser
    @Before("@DesktopBrowserStart")
    public void setupWebBrowser() {

        System.out.println("Test");

        if (runOnBs.contains("YES")) {
            DesiredCapabilities caps = new DesiredCapabilities();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("incognito");  // ChromeOptions for starting chrome in incognito mode
//        caps.setCapability(ChromeOptions.CAPABILITY, options);
// other capability declarations

            caps.setCapability("browser_version", "latest");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("build", "Web Test BS");
            caps.setCapability("name", "Kibana");

//                       To accept the untrusted certificate
            caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            // To Handle Queue
            caps.setCapability("newCommandTimeout", "960");
            caps.setCapability("browserstack.idleTimeout", "180");

            final String URL = "https://" + base.bsUser + ":" + base.bsAccessKey + "@hub-cloud.browserstack.com/wd/hub";

            WebDriverManager.chromedriver().setup();
            caps.setCapability("browser", "Chrome");
            try {
                driver = new RemoteWebDriver(new URL(URL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else if (runOnLt.contains("YES")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("build", "Web Test LT");
            caps.setCapability("name", "Kibana");
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("version", "100.0");

//            To accept the untrusted certificate
            caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            // To Handle Queue
            caps.setCapability("newCommandTimeout", "960");
            caps.setCapability("idleTimeout", "180");

            final String URL = "https://" + base.ltUser + ":" + base.ltAccessKey + "@hub.lambdatest.com/wd/hub";

            WebDriverManager.chromedriver().setup();
            caps.setCapability("browser", "Chrome");
            try {
                driver = new RemoteWebDriver(new URL(URL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            WebDriverManager.chromedriver().setup();

        }

    }

    // Following method will run After Every Scenario
    @After(order = 1)
    public void tearDown(Scenario scenario) {


        if (scenario.isFailed()) {


            try {

                System.out.println("Scenario is Failed Taking ScreenShot..For Web!!!");
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshot, "image/png"); embed depricated
                String name = scenario.getName();
                screenshot = Utilities.scale(screenshot, 800, 650);
                scenario.attach(screenshot, "image/png", name);

            } catch (TimeoutException toe) {
                System.out.println("Exception in driver");
            }

        }

    }


    @After(value = "@DesktopBrowserEnd", order = 0)
    public void quiteBrowser() {

        if(!Utilities.hasQuit(driver)) {
            driver.quit();
        }
    }



    @Before("@first")
    public static void beforeAll()  {
        // Placeholder For Before Class methods if needed
    }

    @After("@last")
    public static void afterAll() {

        // Placeholder For After Class methods if needed
    }

}
