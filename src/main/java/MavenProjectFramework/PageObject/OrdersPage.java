package MavenProjectFramework.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenProjectFramework.reusablecomponents.Reusable;

public class OrdersPage  extends Reusable{
	WebDriver driver;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> prodname;
	
	public OrderSummary productname(String productname) {
		WebElement x=prodname.stream().filter(s->s.getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
		x.findElement(By.xpath(".//following-sibling::td[3]")).click();
		OrderSummary os=new OrderSummary(driver);
		return os;
	}
	
	
}
