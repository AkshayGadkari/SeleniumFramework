package stepDefinitions;


import com.selenium.cbh.Utilities;
import com.selenium.cbh.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import page.objects.HomePage;

import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
public class stepDefinition extends base {


//    Utilities u;

    HomePage hp;


    public stepDefinition() {
    }

    @Given(": Amazon is Open")
    public void amazonIsOpen() {


        if (runOnBs.contains("YES") || runOnLt.contains("YES")) {

            System.out.println("Driver is initiated in before hooks for the Cloud ");
        } else {
            ChromeOptions handlingSSL = new ChromeOptions();

            //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
            handlingSSL.setAcceptInsecureCerts(true);

            //Creating instance of Chrome driver by passing reference of ChromeOptions object
            driver = new ChromeDriver(handlingSSL);


        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String url = (String) prop.get("URL");
        driver.get(url);
        String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(expectedTitle,title);
        driver.manage().window().maximize();

    }


    @And(": User Clicks on hamburger menu")
    public void userClicksOnHamburgerMenu() {

        //Important step: only 1 time Object Creation. Same Reference can be used in further methods in other Scenarios
        hp = new HomePage(driver);
        hp.getHamburgerMenu().click();

    }

    @And(": Scrolls to {string} Section")
    public void scrollsToSection(String section) throws InterruptedException {

        u = new Utilities(driver);
       u.scrollToViewWeb(hp.getToSection(section));

    }
}
