package MavenProjectFramework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import MavenProjectFramework.PageObject.CheckoutPage;
import MavenProjectFramework.PageObject.ProductsPage;
import MavenProjectFramework.base.BaseTest1;

public class ErrorValidation extends BaseTest1 {

	//@Test(groups= {"error"})
	public void LoginError1()  {
	
		p.SubmitMethod("reddy.shilpa@gmail.com", "abc");
		System.out.println(p.LoginError());
		Assert.assertTrue(p.LoginError().equalsIgnoreCase("Incorrect email or password."));

	}

	@Test(groups= {"smoke1"})
	public void productError() {
		String productname = "IPHONE 13 PRO";

		ProductsPage pp = p.SubmitMethod("reddy.shilpa@gmail.com", "Dob@1908");
		pp.AddtoCart(productname);
		CheckoutPage c = pp.cartclick();
		boolean f = c.checkoutproduct("IPHONE 13");
		Assert.assertFalse(f);

	}
}
