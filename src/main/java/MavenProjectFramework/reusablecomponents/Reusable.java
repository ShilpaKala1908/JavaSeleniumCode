package MavenProjectFramework.reusablecomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MavenProjectFramework.PageObject.CheckoutPage;
import MavenProjectFramework.PageObject.ConfirmationPage;
import MavenProjectFramework.PageObject.OrdersPage;

public class Reusable {

	WebDriver driver;
	WebDriverWait 	w ;
	JavascriptExecutor js;
	
	By cart=By.cssSelector("button[routerlink*='cart']");
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderslink;


	public Reusable(WebDriver driver) {
		this.driver = driver;
		 	w = new WebDriverWait(driver, Duration.ofSeconds(5));
		 	js=(JavascriptExecutor)driver;
		 	PageFactory.initElements(driver, this);
		
	}

	public void visiwaits(By toast) {
		
		w.until(ExpectedConditions.visibilityOfElementLocated(toast));
	}

	public void etobeclickwaits(By cartbutton) {
		
		w.until(ExpectedConditions.elementToBeClickable(cartbutton));
	}

	public void invisiwaits(By toast) {
		
		w.until(ExpectedConditions.invisibilityOfElementLocated(toast));
	}
	
	public CheckoutPage cartclick() {
		driver.findElement(cart).click();
		CheckoutPage c = new CheckoutPage(driver);
		return c;
	}
	
	public ConfirmationPage PlaceOrderbutton() {
		js.executeScript("document.querySelector('.action__submit').click()");
		ConfirmationPage cp=new ConfirmationPage(driver);
		return cp;
	}
	
	public OrdersPage Orderclick() {
		orderslink.click();
		OrdersPage orders=new OrdersPage(driver);
		return orders;
	}
}