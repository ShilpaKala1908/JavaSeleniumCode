package MavenProjectFramework.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import MavenProjectFramework.PageObject.LoginPage;

public class BaseTest {
 public	WebDriver driver;
 public LoginPage pe;
 

	public void initilaisebrowser() throws IOException {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\MavenProjectFramework\\prop\\GlobalData.properties");
		p.load(fis);
		String b = p.getProperty("browsers");
		if (b.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\tarun\\Downloads\\chromedriver.exe");
			 driver = new ChromeDriver();

		} else if (b.equalsIgnoreCase("edge")) {
			 driver = new EdgeDriver();
		} else if (b.equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
 
	//@BeforeMethod
     public void intillogin() throws IOException {
		 initilaisebrowser();
		  pe = new LoginPage(driver);
		  pe.goTo();
		
 }
	 
	 //@AfterMethod
     public void close1()  {
		driver.close();
 }
	
}
