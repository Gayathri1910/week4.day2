package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectMyntra {

	public static void main(String[] args) throws InterruptedException, IOException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		
		WebElement webMen=driver.findElement(By.className("desktop-main"));
		Actions builder=new Actions(driver);
		builder.moveToElement(webMen).perform();
		
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		
		
		//WebElement totalItems = driver.findElement(By.className("title-count"));
		//totalItems.getAttribute("value");
		//System.out.println("Total shown is : " +value);
		
		
		
		String value = driver.findElement(By.className("title-count")).getText();
		String replaceValue=value.replaceAll("[^0-9]", "");
		int total=Integer.parseInt(replaceValue);
		System.out.println("Total is : "+total);
		
		String jacketValue = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String replaceJValue=jacketValue.replaceAll("[^0-9]", "");
		int totalJValue=Integer.parseInt(replaceJValue);
		System.out.println("Total Jacket Value is : "+totalJValue);
		
		String rainJacketValue=driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String replaceRJValue=rainJacketValue.replaceAll("[^0-9]", "");
		int totalRJValue=Integer.parseInt(replaceRJValue);
		System.out.println("Total Rain Jacket is : "+totalRJValue);
		
		int sum=totalJValue+totalRJValue;
		if(total==sum)
		{
			System.out.println("Total value is matching the sum");
		}
		else
		{
			System.out.println("Total value is not matching the sum");
		}
		
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
		//driver.findElement(By.className("common-checkboxIndicator")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Duke')]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		Thread.sleep(5000);
		List<WebElement> brandFind=driver.findElements(By.tagName("h3"));
		//System.out.println("Brand is : "+brandFind);
		for(int i=0;i<brandFind.size();i++)
		{
			String brandSize=brandFind.get(i).getText();
			Thread.sleep(1000);
			if(brandSize.equals("Duke"))
			{
				System.out.println("Product is Duke brand");
			}
			else
			{
				System.out.println("Product is not Duke");
			}
		}
			
			WebElement sortBy = driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']"));
			builder.moveToElement(sortBy).perform();
			driver.findElement(By.xpath("//input[@value='discount']/parent::label")).click();
			
			Thread.sleep(5000);
			
			String firstPrice = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
			System.out.println("The price of first product is : "+firstPrice);
			
			Thread.sleep(5000);
			
			WebElement firstProduct = driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]"));
			firstProduct.click();
			
			Set<String> productWindow=driver.getWindowHandles();
			List<String> productWindow1=new ArrayList<String>(productWindow);
			productWindow1.get(1);
			driver.switchTo().window(productWindow1.get(1));
			
			//WebElement productClick = driver.findElement(By.xpath("//button[@id='Click']"));
			File src1 = driver.getScreenshotAs(OutputType.FILE);
			File dst = new File("./snaps/seat2.png");
			FileUtils.copyFile(src1, dst);
			
			driver.findElement(By.xpath("//span[@class='myntraweb-sprite pdp-notWishlistedIcon sprites-notWishlisted pdp-flex pdp-center ']")).click();
			
			driver.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

