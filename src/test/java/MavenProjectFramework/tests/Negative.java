package MavenProjectFramework.tests;

import org.testng.annotations.Test;

import MavenProjectFramework.base.BaseTest;

public class Negative extends BaseTest{
	
	@Test
	public void value() {
		driver.get("https://www.google.com");
		
	}

}
