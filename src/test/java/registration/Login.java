package registration;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.config;

public class Login
{
	config drive = new config();
	Alert alert;
	WebDriver driver = drive.setupDriver();
	AddCart cart = new AddCart();

	@Parameters({"browser","userName", "password"})
	@Test(priority=1)
	public void login(String url,String user, String pwd)
	{
		driver.get(url);
		WebElement login= driver.findElement(By.xpath("//a[@id='login2']"));
		login.click();
		WebElement userName= driver.findElement(By.xpath("//input[@id='loginusername']"));
		WebElement password= driver.findElement(By.xpath("//input[@id='loginpassword']"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		userName.sendKeys(user);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		password.sendKeys(pwd);

		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
		try
		{
			drive.alertHandle(driver, alert);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			driver.findElement(By.xpath("//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']")).click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		String CUrl = driver.getCurrentUrl();
		cart.sendUrl(CUrl);
	}

	}
