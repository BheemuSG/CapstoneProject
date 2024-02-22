package registration;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import driver.config;

public class AddCart
{
	WebDriver drivers;
	Alert alert;
	config drive = new config();
	@Test
	public void sendUrl(String url)
	{
		drivers=drive.setupDriver();
		drivers.get(url);
		drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		drivers.findElement(By.xpath("//a[normalize-space()='Samsung galaxy s6']")).click();
		try
		{
			drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			drivers.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
			
			drive.alertHandle(drivers, alert);
			drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			drivers.findElement(By.xpath("//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']")).click();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		


	}

}
