package assignment8.day8;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableCode {
	
	public static void main(String[] args) throws InterruptedException, IOException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		
		
		WebElement itemOneLocate = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement itemFiveLocate = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		Point Location=itemFiveLocate.getLocation();
		int x=Location.getX();
		int y=Location.getY();
		
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(itemOneLocate, x, y).perform();
		

}
	
}
