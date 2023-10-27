package StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import MavenProjectFramework.PageObject.CheckoutPage;
import MavenProjectFramework.PageObject.ConfirmationPage;
import MavenProjectFramework.PageObject.LoginPage;
import MavenProjectFramework.PageObject.PlaceOrder;
import MavenProjectFramework.PageObject.ProductsPage;
import MavenProjectFramework.base.BaseTest1;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MyFirstStepDefinition extends BaseTest1 {
	
public LoginPage loginPage;
public ProductsPage pp;
CheckoutPage c;
PlaceOrder po;
ConfirmationPage cp;
	@Given("I landed on the ecommerce page")
	public void I_landed_on_the_ecommerce_page() throws IOException {
		loginPage=loginMethod();
	}
	
	 @Given("^I logged in with username (.+) and password (.+)$")
		 
	public void  I_logged_in_with_username_and_password(String email,String password) {
		 
			 pp = p.SubmitMethod(email, password);
	 }
	 
	 @When("^I add product (.+) to the cart$")
	 public void I_add_product_to_the_cart(String product) {
		 pp.AddtoCart(product);
		 c = pp.cartclick();
		 
	 }
	 
	 @And("^checkout (.+) and submit the order$")
	 public void checkout_product_and_submit_the_order(String product) {
			boolean f = c.checkoutproduct(product);
			Assert.assertTrue(f);
			 po = c.checkoutbutton();
			 po.PlaceOrderMethod("Ind", "India");
			 cp = po.PlaceOrderbutton();
	 }
	 
	

	
	 
	 
	  @Then("{string} message is displayed on the confirmationPage")
	  public void message_is_displayed_on_the_confirmationPage(String s) {
		  Assert.assertEquals(cp.MessageConfirm(), s);
	  }
}
