package MavenProjectFramework.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectDemo_streams {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tarun\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://rahulshettyacademy.com/client/");
		
		driver.findElement(By.id("userEmail")).sendKeys("reddy.shilpa@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Dob@1908");
		driver.findElement(By.id("login")).click();
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	Thread.sleep(1000);
		WebElement prod=products.stream().filter(product-> 
		product.findElement(By.xpath(".//div/div/h5/b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
	
	
		prod.findElement(By.xpath(".//div/div/button[2]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
		driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")).click();
		
		List<WebElement> checkoutproducts=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		boolean f=checkoutproducts.stream().allMatch(s->s.getText().equals("IPHONE 13 PRO"));
		System.out.println(f);
		driver.findElement(By.cssSelector(".totalRow .btn.btn-primary")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
		List<WebElement> x=driver.findElements(By.cssSelector(".list-group-item span"));
		WebElement m= x.stream().filter(z->z.getText().equals("India")).findFirst().orElse(null);
		m.click();

		System.out.println(driver.findElement(By.xpath("//input[@placeholder='Select Country']")).getAttribute("value"));
	
		//WebElement submit = driver.findElement(By.cssSelector(".action__submit"));

	

		js.executeScript("document.querySelector('.action__submit').click()");
		
		
	

	
	
	
		
	}

}
