package page.objects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
	 WebDriver driverN;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driverN = driver;
		wait = new WebDriverWait(driver,10);
		PageFactory.initElements(driver, this);
	}


	public void clearAndSendKeys(WebElement element, String value) {
		element = waitForElementVisibility(element);
		element.clear();
		element.sendKeys(value);
	}

	public void click(WebElement element) {
		waitForElementToBeClickable(element).click();
	}

	public void click(By by) {
		waitForElementToBeClickable(by).click();
	}


	public WebElement waitForElementToBeClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForElementToBeClickable(By by) {
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public WebElement waitForElementVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driverN).executeScript("arguments[0].scrollIntoView(true);", element);
	}



}
