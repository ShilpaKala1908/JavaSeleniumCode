package MavenProjectFramework.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MavenProjectFramework.reusablecomponents.Reusable;

public class LoginPage extends Reusable {

	WebDriver driver;
	

	public LoginPage(WebDriver x) {
		super(x);
		
		driver = x;
		PageFactory.initElements(x, this);
	}

	@FindBy(id = "userEmail")
	WebElement username;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(id = "toast-container")
	WebElement error;
	
	By val=By.id("toast-container");

	public ProductsPage SubmitMethod(String a,String b) {
		username.sendKeys(a);
		password.sendKeys(b);
		submit.click();
		ProductsPage pp = new ProductsPage(driver);
		return pp;
	}
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	
	}
	
	public String LoginError() {
		visiwaits(val);
		return error.getText();
	}

}
