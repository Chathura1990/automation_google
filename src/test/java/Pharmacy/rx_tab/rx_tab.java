package Pharmacy.rx_tab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class rx_tab {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chromedriver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch Chrome
		driver.get("https://accounts.google.com"); //Opening the Staging site https://internalsite.staging.itsupportme.com/app.php/security/login
		driver.manage().window().maximize(); //Maximizing the browser window
		
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("chathura@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[2]/div[2]")));
		
	/*	WebElement msg=driver.findElement(By.xpath("//*[@id=\\\"view_container\\\"]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[2]/div[2]"));
		String text= msg.getText();
		if (msg.isEnabled() && text.contains("Не удалось найти аккаунт Google"))
		{ 
		    System.out.println("Invalid email");
		}else{
		    System.out.println("correct email");
		}*/
		//if element found then we will use- In this example I just called isDisplayed method
		boolean status = element.isDisplayed();
 
		// if else condition
		if (status) {
			System.out.println("Invalid email");
		} else {
			System.out.println("===== WebDriver is not visible======");
		}
		
		
		
		
	}

}
