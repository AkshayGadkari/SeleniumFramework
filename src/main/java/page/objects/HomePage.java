package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    // All th objects & respective Methods belonging to one page will be defined in java class


    //Private Elements Area
    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//span[@class='a-dropdown-label']")
    private WebElement sortByDropdown;


    @FindBy(xpath = "//h1[normalize-space()='About this item']")
    private WebElement aboutThisItemSection;

    @FindBy(xpath = "//div[@id='feature-bullets']")
    private WebElement aboutThisItemTextSection;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //div[@id='feature-bullets']

//    @FindBy(xpath = "//div[normalize-space()='shop by department']")
//    private WebElement shopByDepartment;


    // Public Methods Area


    public WebElement getHamburgerMenu() {
        System.out.println("trying to get HamburgerMenu");
        waitForElementVisibility(hamburgerMenu);
        return hamburgerMenu;
    }

    public WebElement getSortByDropdown() {
        System.out.println("trying to get sortByDropdown");
        waitForElementVisibility(sortByDropdown);
        return sortByDropdown;
    }

    public WebElement getAboutThisItemSection() {
        System.out.println("trying to get aboutThisItemSection");
        waitForElementVisibility(aboutThisItemSection);
        return aboutThisItemSection;
    }

    public WebElement getAboutThisItemTextSection() {
        System.out.println("trying to get aboutThisItemTextSection");
        waitForElementVisibility(aboutThisItemTextSection);
        return aboutThisItemTextSection;
    }


    public  WebElement getToSection(String section)
    {
        return driverN.findElement(By.xpath("//div[normalize-space()='"+section+"']"));
    }

    public  WebElement getToLink(String link)
    {
        return driverN.findElement(By.xpath("//div[normalize-space()='"+link+"']"));
    }


    public  WebElement getToSubLink(String subLink)
    {
        return driverN.findElement(By.xpath("//a[normalize-space()='"+subLink+"']"));
    }

    public  WebElement getToArea(String area)
    {
        return driverN.findElement(By.xpath("//span[normalize-space()='"+area+"']"));
    }

    public  WebElement getTheCheckbox(String checkBox)
    {
        return driverN.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='"+checkBox+"']"));
    }

    public  WebElement getTheSortByValue(String sortValue)
    {
        return driverN.findElement(By.xpath("//a[normalize-space()='"+sortValue+"']"));
    }


}
