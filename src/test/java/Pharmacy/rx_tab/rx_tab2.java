package Pharmacy.rx_tab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class rx_tab2 {
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void myTest() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromedriver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch Chrome
		driver.get("https://accounts.google.com"); //Opening the Staging site https://internalsite.staging.itsupportme.com/app.php/security/login
		driver.manage().window().maximize(); //Maximizing the browser window
		
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("chathura@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		String actualMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[2]/div[2]"))).getAttribute("innerHTML");
		
		//String actualMsg = driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[2]/div[2]")).getText();
		
		String expected_errorMsg = "Не удалось найти аккаунт Google";
		
		if(actualMsg.equals(expected_errorMsg)) 
		{
		    System.out.println("Test Case Failed");
		}else
		{
		    System.out.println("Test Case Passed");
		};
		Thread.sleep(2000);
		driver.close();
		
	}

}
