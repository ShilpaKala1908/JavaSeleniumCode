package MavenProjectFramework.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenProjectFramework.reusablecomponents.Reusable;

public class PlaceOrder extends Reusable{
WebDriver driver;
	
	public PlaceOrder(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".list-group-item span")
	List<WebElement> countrieslist;
	
	By listitems=By.cssSelector(".ta-item");
	
	
	public void PlaceOrderMethod(String c,String countryvalue) {
	country.sendKeys(c);
	//visiwaits(listitems);
	List<WebElement> x = countrieslist;
	WebElement m = x.stream().filter(z -> z.getText().equals(countryvalue)).findFirst().orElse(null);
	m.click();
	}
}
