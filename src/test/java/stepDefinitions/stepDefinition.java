package stepDefinitions;


import com.selenium.cbh.Utilities;
import com.selenium.cbh.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import page.objects.HomePage;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
public class stepDefinition extends base {


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
        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(expectedTitle, title);
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
        String actual = hp.getToSection(section).getText();
        Assert.assertTrue(section.equalsIgnoreCase(actual));
    }

    @And(": Clicks on {string} link")
    public void clicksOnLink(String link) throws InterruptedException {
        u.scrollToViewWeb(hp.getToLink(link));
        System.out.println(hp.getToLink(link).getText());
        hp.getToLink(link).click();
    }

    @And(": wait for {string} min")
    public void waitForMin(String min) throws InterruptedException {
        long minute = Long.parseLong(min);
        long wait = Utilities.minutesToMilliSecond(minute);
        Thread.sleep(wait);
    }

    @And(": Clicks on {string} sub link")
    public void clicksOnSubLink(String subLink) throws InterruptedException {
        u.scrollToViewWeb(hp.getToSubLink(subLink));
        System.out.println(hp.getToSubLink(subLink).getText());
        hp.getToSubLink(subLink).click();
    }

    @And(": Scrolls to {string} area")
    public void scrollsToArea(String area) throws InterruptedException {

        u.scrollToViewWeb(hp.getToArea(area));
        String actual = hp.getToArea(area).getText();
        Assert.assertTrue(area.equalsIgnoreCase(actual));
    }

    @And(": Checks {string} check box")
    public void checksCheckBox(String checkBox) throws InterruptedException {
        u.scrollToViewWeb(hp.getTheCheckbox(checkBox));
        System.out.println(hp.getTheCheckbox(checkBox).getText());
        hp.getTheCheckbox(checkBox).click();
    }

    @And(": Selects {string} from Sort by dropdown")
    public void selectsFromSortByDropdown(String sortBy) {
        hp.getSortByDropdown().click();
        hp.getTheSortByValue(sortBy).click();
    }

    @And(": Click on the second highest priced item")
    public void clickOnTheSecondHighestPricedItem() {

//        int k=Integer.parseInt(value);


        List<WebElement> itemsList = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

//its already sorted , hence removing 1st element

        itemsList.remove(0);

        for (WebElement item : itemsList) {
            System.out.println(item.getText());

            String price = item.getText();


            driver.findElement(By.xpath("//span[normalize-space()='" + price + "']")).click();
            break;

        }


    }

    @And(": Switch to Another Window")
    public void switchToAnotherWindow() {

        //
        String mainHandle = driver.getWindowHandle();
        System.out.println("Main Window ID : " + mainHandle + "\n");

        //

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("Number of Windows Open After Click : " + allHandles.size());

        for (String windowHandle : allHandles) {
            if (mainHandle.equals(windowHandle)) {
                System.out.println(" \t Window ID 1:\t "+windowHandle+
                        "\n \t URL : \t \t "+ driver.getCurrentUrl()+
                        "\n \t Title : \t \t "+ driver.getTitle());
            }
            else {
                driver.switchTo().window(windowHandle);

                System.out.println(" \t Window ID 2:\t "+windowHandle+
                        "\n \t URL : \t \t "+ driver.getCurrentUrl()+
                        "\n \t Title : \t \t "+ driver.getTitle());
            }

        }

    }
}