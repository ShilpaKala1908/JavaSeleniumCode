package MavenProjectFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenProjectFramework.reusablecomponents.Reusable;

public class OrderSummary extends Reusable{
	
	WebDriver driver;
	public OrderSummary(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div.title")
	WebElement product;
	
	public String OrderSummaryProduct() {
		return product.getText();
	}

}
