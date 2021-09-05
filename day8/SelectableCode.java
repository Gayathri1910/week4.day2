package assignment8.day8;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableCode {
	
	public static void main(String[] args) throws InterruptedException, IOException  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		
		WebElement itemOneSelect = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement itemSixSelect = driver.findElement(By.xpath("//li[text()='Item 6']"));
		Actions builder=new Actions(driver);
		builder.clickAndHold(itemOneSelect).moveToElement(itemSixSelect).release().perform();
		
		
		

}
}
