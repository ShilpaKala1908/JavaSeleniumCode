package MavenProjectFramework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import MavenProjectFramework.PageObject.LoginPage;

public class BaseTest1 {
	public  WebDriver driver;
	public LoginPage p;

	public void initilaisebrowser() throws IOException {

		Properties p = new Properties();
		FileInputStream f = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\MavenProjectFramework\\pro\\GlobalData.properties");
		p.load(f);
		String x = System.getProperty("browser") != null ? System.getProperty("browser") : p.getProperty("browser");
		if (x.contains("chrome")) {
			ChromeOptions a = new ChromeOptions();

			if (x.contains("headless")) {
				a.addArguments("headless");
				driver = new ChromeDriver(a);
			} else {
				driver = new ChromeDriver();
			}

		}

		else if (x.contains("firefox")) {
			FirefoxOptions options = new FirefoxOptions();

			if (x.contains("headless")) {
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
			} else 
				driver = new FirefoxDriver();
			

		} else if (x.contains("edge")) {
			EdgeOptions options = new EdgeOptions();

			if (x.contains("headless")) {
				options.addArguments("headless");
				driver = new EdgeDriver(options);
			} else 
				driver = new EdgeDriver();
		}

		driver.manage().window().setSize(new Dimension(1600, 1000));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage loginMethod() throws IOException {
		initilaisebrowser();
		p = new LoginPage(driver);
		p.goTo();
		return p;
	}

	public List<HashMap<String, String>> Datavaluesfromjson(String s) throws IOException {

		String value = FileUtils.readFileToString(new File(s));

		ObjectMapper m = new ObjectMapper();
		List<HashMap<String, String>> list = m.readValue(value, new TypeReference<List<HashMap<String, String>>>() {
		});
		return list;
	}

	public String screenshottaking(String testcasename, WebDriver driver) throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir") + "\\reports" + testcasename + ".png";
		FileUtils.copyFile(f, new File(filepath));
		return filepath;
	}

	//@AfterMethod(alwaysRun = true)
	public void afterMethod1() {
		driver.close();
	}
}