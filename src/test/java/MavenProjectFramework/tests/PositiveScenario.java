package MavenProjectFramework.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MavenProjectFramework.PageObject.CheckoutPage;
import MavenProjectFramework.PageObject.ConfirmationPage;
import MavenProjectFramework.PageObject.OrderSummary;
import MavenProjectFramework.PageObject.OrdersPage;
import MavenProjectFramework.PageObject.PlaceOrder;
import MavenProjectFramework.PageObject.ProductsPage;
import MavenProjectFramework.base.BaseTest1;

public class PositiveScenario extends BaseTest1 {
	
	

	@Test(dataProvider="getData1")
	public void AlaceOrder1(String email,String password,String product) throws IOException {
		ProductsPage pp = p.SubmitMethod(email,password );
		OrdersPage o=pp.Orderclick();
		OrderSummary os=o.productname(product);
		Assert.assertTrue(product.equalsIgnoreCase(os.OrderSummaryProduct()));		
	}
	
	
	@Test(dataProvider= "getData1")
	public void PlaceOrder(String email,String password,String product) throws IOException {
		ProductsPage pp = p.SubmitMethod(email, password);
		pp.AddtoCart(product);
		
		CheckoutPage c = pp.cartclick();
		boolean f = c.checkoutproduct(product);
		Assert.assertTrue(f);
		PlaceOrder po = c.checkoutbutton();
		po.PlaceOrderMethod("Ind", "India");
		ConfirmationPage cp = po.PlaceOrderbutton();
		Assert.assertEquals(cp.MessageConfirm(), "THANKYOU FOR THE ORDER.");
	}
	
	//@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>> s=Datavaluesfromjson(System.getProperty("user.dir")+"\\src\\test\\java\\MavenProjectFramework\\data\\GlobalData.json");
		return new Object[][] {{s.get(0)},{s.get(1)}};
	}
	
	
	@DataProvider
	public Object[][] getData1() throws IOException  {
		//List<HashMap<String,String>> s=Datavaluesfromjson(System.getProperty("user.dir")+"\\src\\test\\java\\MavenProjectFramework\\data\\GlobalData.json");
		return new Object[][] {{"reddy.shilpa@gmail.com","Dob@1908","IPHONE 13 PRO"}};
	}
	

}
