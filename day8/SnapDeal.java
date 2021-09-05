package assignment8.day8;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement mensFashion = driver.findElementByLinkText("Men's Fashion");
		Actions builder=new Actions(driver);
		builder.moveToElement(mensFashion).perform();
		
		//driver.findElementById("pushDenied").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='Sports Shoes']").click();
		Thread.sleep(2000);
		
		String SHOESCOUNT = driver.findElementByXPath("(//span[@class='category-count'])[1]").getText();
		System.out.println("COUNT OF SPORTS SHOES:" + SHOESCOUNT);
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[text()='Training Shoes']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']").click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		Thread.sleep(2000);
		
		List<WebElement> price = driver.findElements(By.xpath("//span[contains(@id,'display-price')]"));
		for (WebElement eachpr : price) {
			System.out.println(eachpr.getText());
			
		}
		List<String> pricelist = new ArrayList<String>();
		List<Integer>  priceval = new ArrayList<Integer>();
		for(int i = 0 ;i<price.size();i++)
		{
			String eachprice = price.get(i).getText().replaceAll("[^0-9]", "");
			pricelist.add(eachprice);
			priceval.add(Integer.parseInt(eachprice));
									
		}
		System.out.println(pricelist);
		Integer min = Collections.min(priceval);
		System.out.println(min);
		Collections.sort(priceval);
		System.out.println(priceval);
		if(priceval.get(0).equals(min))
		{
			System.out.println("values sorted");
		}
		else
		{
			System.out.println("value not sorted");
		}
		
		WebElement hoverOnShoe = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[3]"));
		Actions builder1=new Actions(driver);
		builder1.moveToElement(hoverOnShoe).perform();
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		//driver.findElement(By.xpath("(//p[@title='VSS Blue Training Shoes'])[1]")).click();
		//Set<String> windowHandlesset1 = driver.getWindowHandles();
		//List<String> windowhandleList1 = new ArrayList<String>(windowHandlesset1);
		//driver.switchTo().window(windowhandleList1.get(1));
		WebElement price1 = driver.findElement(By.xpath("//span[@class='payBlkBig']/parent::div"));
		String text = price1.getText();
		text.replaceAll("[^0-9]", " ");
		System.out.println(text);
		WebElement discount = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		String text2 = discount.getText();
		System.out.println(text2);
		//snapshot
		//System.err.println("The price of first duke brand is : " +price);
				File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			    File dst = new File("./snapdeal/vss.png");
			    FileUtils.copyFile(screenshotAs, dst);
			    driver.close();
			    driver.quit();
		


}
}
