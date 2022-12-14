package stepDefinitions;


import com.selenium.cbh.Utilities;
import com.selenium.cbh.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
public class StepDefinition extends base {


    HomePage hp;


    public StepDefinition() {
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
        String url = config.URL();
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
       hp.click(hp.getHamburgerMenu());

    }

    @And(": Scrolls to {string} Section")
    public void scrollsToSection(String section) {

       hp.scrollToElement(hp.getToSection(section));
        String actual = hp.getToSection(section).getText();
        Assert.assertTrue(section.equalsIgnoreCase(actual));
    }

    @And(": Clicks on {string} link")
    public void clicksOnLink(String link) {
       hp.scrollToElement(hp.getToLink(link));
        System.out.println(hp.getToLink(link).getText());
        hp.click(hp.getToLink(link));
    }

    @And(": wait for {string} min")
    public void waitForMin(String min) throws InterruptedException {
        long minute = Long.parseLong(min);
        long wait = Utilities.minutesToMilliSecond(minute);
        Thread.sleep(wait);
    }

    @And(": Clicks on {string} sub link")
    public void clicksOnSubLink(String subLink) {
       hp.scrollToElement(hp.getToSubLink(subLink));
        System.out.println(hp.getToSubLink(subLink).getText());
       hp.click(hp.getToSubLink(subLink));
    }

    @And(": Scrolls to {string} area")
    public void scrollsToArea(String area) {

       hp.scrollToElement(hp.getToArea(area));
        String actual = hp.getToArea(area).getText();
        Assert.assertTrue(area.equalsIgnoreCase(actual));
    }

    @And(": Checks {string} check box")
    public void checksCheckBox(String checkBox) {
       hp.scrollToElement(hp.getTheCheckbox(checkBox));
        System.out.println(hp.getTheCheckbox(checkBox).getText());
        hp.click(hp.getTheCheckbox(checkBox));
    }

    @And(": Selects {string} from Sort by dropdown")
    public void selectsFromSortByDropdown(String sortBy) {
        hp.click(hp.getSortByDropdown());
        hp.click(hp.getTheSortByValue(sortBy));
    }

    @And(": Clicks on the second highest price item")
    public void clicksOnTheSecondHighestPriceItem() {

//        int k=Integer.parseInt(value);


        List<WebElement> itemsList = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

//its already sorted , hence removing 1st element

        itemsList.remove(0);

        for (WebElement item : itemsList) {
            System.out.println(item.getText());

            String price = item.getText();

            hp.click(By.xpath("//span[normalize-space()='" + price + "']"));
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
                System.out.println(" \t Window ID 1:\t " + windowHandle +
                        "\n \t URL : \t \t " + driver.getCurrentUrl() +
                        "\n \t Title : \t \t " + driver.getTitle());
            } else {
                driver.switchTo().window(windowHandle);

                System.out.println(" \t Window ID 2:\t " + windowHandle +
                        "\n \t URL : \t \t " + driver.getCurrentUrl() +
                        "\n \t Title : \t \t " + driver.getTitle());
            }

        }

    }

    @Then(": Checks if About this item section is present")
    public void checksIfAboutThisItemSectionIsPresent() {

//        Utilities.isElementExists(hp.getAboutThisItemSection());

        boolean isPresent = Utilities.isByExists(By.xpath("//h1[normalize-space()='About this item']"), driver);
        if(isPresent){
          hp.scrollToElement(hp.getAboutThisItemSection());
            Assert.assertTrue(true);
          String text= hp.getAboutThisItemTextSection().getText();
            System.out.println(text);
        }else{
            Assert.fail("About this item Section is Not Present");
        }

    }
}