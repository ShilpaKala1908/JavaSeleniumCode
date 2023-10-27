package MavenProjectFramework.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenProjectFramework.reusablecomponents.Reusable;

public class CheckoutPage extends Reusable {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> checkoutproducts;
	
	@FindBy(css=".totalRow .btn.btn-primary")
	WebElement checkoutbutton1;
	
	By cartproducts=By.xpath("//div[@class='cartSection']/h3");
	public boolean checkoutproduct(String name) {
		visiwaits(cartproducts);
		boolean f = checkoutproducts.stream().allMatch(s -> s.getText().equals(name));
		return f;
	}
	
	public PlaceOrder checkoutbutton() {
		checkoutbutton1.click();
		PlaceOrder po=new PlaceOrder(driver);
		return po;
	}
	
}
