package MavenProjectFramework.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenProjectFramework.reusablecomponents.Reusable;

public class ProductsPage extends Reusable{

	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By product1=By.xpath(".//div/div/h5/b");
	By addtocartbutton=By.xpath(".//div/div/button[2]");
	By toast=By.id("toast-container");
	By cartbutton=By.cssSelector("button[routerlink=\"/dashboard/cart\"]");

	
	
	
	public WebElement products(String prodname){
	WebElement prod=products.stream().filter(product-> 
	product.findElement(product1).getText().equals(prodname)).findFirst().orElse(null);
	return prod;	
	}
	
	public void AddtoCart(String prodname) {	
		products(prodname).findElement(addtocartbutton).click();
		visiwaits(toast);
		etobeclickwaits(cartbutton);
		invisiwaits(toast);
	}
}
