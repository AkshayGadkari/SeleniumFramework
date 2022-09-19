package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    // All th objects & respective Methods belonging to one page will be defined in java class

    WebDriver driverN;

    //Constructor for Assigning current driver session to instance variable driverN
    public HomePage(WebDriver driverWB) {
        this.driverN = driverWB;
        PageFactory.initElements(driverWB, this);
    }


    //Private Elements Area
    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement hamburgerMenu;

//    @FindBy(xpath = "//div[normalize-space()='shop by department']")
//    private WebElement shopByDepartment;


    // Public Methods Area


    public WebElement getHamburgerMenu() {
        System.out.println("trying to get HamburgerMenu");
        waitForVisibility(hamburgerMenu, driverN);
        return hamburgerMenu;
    }

//    public WebElement getShopByDepartment() {
//        System.out.println("trying to get HamburgerMenu");
//        waitForVisibility(shopByDepartment, driverN);
//        return shopByDepartment;
//    }

    public  WebElement getToSection(String section)
    {
        return driverN.findElement(By.xpath("//div[normalize-space()='"+section+"']"));
    }

    public  WebElement getToLink(String link)
    {
        return driverN.findElement(By.xpath("//div[normalize-space()='"+link+"']"));
    }



    private static void waitForVisibility(WebElement element, WebDriver driverWB) throws Error {
        new WebDriverWait(driverWB, 15)
                .until(ExpectedConditions.visibilityOf(element));
    }


}
