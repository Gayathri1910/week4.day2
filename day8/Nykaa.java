
package assignment8.day8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).perform();
		Thread.sleep(2000);

		WebElement popular = driver.findElement(By.xpath("//a[text()='Popular']"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(popular).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//li[@class='brand-logo menu-links'])[5]")).click();
		Set<String> lorealParisWindow = driver.getWindowHandles();
		List<String> lorealParis1 = new ArrayList<String>(lorealParisWindow);
		lorealParis1.get(1);
		driver.switchTo().window(lorealParis1.get(1));

		String pageTitle = driver.findElement(By.linkText("L'Oreal Paris")).getText();
		System.out.println("The title is : " + pageTitle);
		Thread.sleep(2000);

		// driver.findElement(By.xpath("//span[@class='pull-left']")).click();

		driver.findElementByXPath("//span[contains(text(),'popularity')]").click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(text(),'Category')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//li[@class='filter-list-header  '])[1]")).click();
		Thread.sleep(2000);

		driver.findElementByXPath("//span[text()='Hair Care']").click();

		driver.findElementByXPath("(//div[@class='control__indicator'])[1]").click();
		Thread.sleep(2000);

		WebElement shampoo = driver.findElement(By.xpath("//div[@class='filter-applied']//following::li[1]"));
		String shampooFilterVal = shampoo.getText();

		if (shampooFilterVal.contains("Shampoo")) {
			System.out.println("Filter contains Shampoo");
		} else {
			System.out.println("Filter does not contain shampoo");
		}

		driver.findElement(By.xpath("(//div[@class='m-content__product-list__title'])[12]")).click();
		Set<String> shampooWindow = driver.getWindowHandles();
		List<String> shampooWindow1 = new ArrayList<String>(shampooWindow);
		shampooWindow1.get(2);
		driver.switchTo().window(shampooWindow1.get(2));

		driver.findElement(By.xpath("//span[text()='175ml']")).click();
		System.out.println("Quantity is clicked");
		
		String priceOfShampoo = driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText();
		System.out.println("The price of shampoo is : " +priceOfShampoo);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(2000);
		
		String text2 = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
		String REPITEM1 = text2.replaceAll("[^0-9]", "");
		int COUNT1 = Integer.parseInt(REPITEM1);
		System.out.println("GRAND TOTAL IS:" + COUNT1);
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Proceed']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//button[text()='CONTINUE AS GUEST']").click();
		Thread.sleep(2000);
		
		String text3 = driver.findElementByXPath("//div[@class='payment-details-tbl grand-total-cell prl20']/div[2]")
				.getText();
		String REPITEM2 = text3.replaceAll("[^0-9]", "");
		int COUNT2 = Integer.parseInt(REPITEM2);
		System.out.println("GRAND 2 TOTAL IS:" + COUNT2);
		if (COUNT1 == COUNT2) {
			System.out.println("THEY ARE SAME");
		
		driver.quit();

	}
}
}
