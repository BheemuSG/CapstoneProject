package driver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class config
{
	public WebDriver driver;
	
	
	public WebDriver setupDriver() 
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		return driver;
	}
	public void alertHandle(WebDriver driver, Alert alert)
	{
		//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		String alertMessage=alert.getText();
		alert.accept();
		System.out.println("Alert message: " + alertMessage);
	}
	
	

}
