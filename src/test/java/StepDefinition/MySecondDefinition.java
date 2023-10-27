package StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import MavenProjectFramework.PageObject.CheckoutPage;
import MavenProjectFramework.PageObject.ConfirmationPage;
import MavenProjectFramework.PageObject.LoginPage;
import MavenProjectFramework.PageObject.PlaceOrder;
import MavenProjectFramework.PageObject.ProductsPage;
import MavenProjectFramework.base.BaseTest1;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MySecondDefinition extends BaseTest1 {
	
public LoginPage loginPage;
public ProductsPage pp;
CheckoutPage c;
PlaceOrder po;
ConfirmationPage cp;
	@Given("I am on landing page")
	public void  I_am_on_landing_page() throws IOException {
		loginPage=loginMethod();
	}
	
	 @When("^I logged in with usernames (.+) and password (.+)$")
		 
	public void  I_logged_in_with_username_and_password(String email,String password) {
		 
			 pp = p.SubmitMethod(email, password);
	 }
	 
	 @Then("{string} message is displayed on the LoginPage")
	 public void message_is_displayed_on_the_LoginPage(String value) {
		 System.out.println(p.LoginError());
			Assert.assertTrue(p.LoginError().equalsIgnoreCase(value));

		 
	 }
	 
	 
	 
	 @Given("^I am on landing page and I logged in with usernames (.+) and password (.+)$")
		public void  I_am_on_landing_page_logged_in(String email,String password) throws IOException {
			loginPage=loginMethod();
			 pp = p.SubmitMethod(email, password);
		}
		
		 @When("^I add product (.+) to the carts$")
			 
		public void  I_add_product_to_the_carts(String product) {
			 System.out.println(product);
				pp.AddtoCart(product);
				
	
		 }
		 
		 @When("^checkout (.+)$")
		 public void  checkout(String product) {
				 c = pp.cartclick();
		
			 }
		 
		@Then("^(.+) should be displayed on the checkoutpage$")
		 public void message_is_displayed_on_the_LoginPage1(String value) {
				boolean f = c.checkoutproduct("IPHONE 13");
				Assert.assertFalse(f);

			 
		 }
		
		@After
		public  void after_all() {
			driver.close();
		}
	 

}
