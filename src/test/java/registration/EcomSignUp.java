package registration;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.config;

public class EcomSignUp
{
	
	config drive = new config();
	Alert alert;
	
	WebDriver driver;
	@Parameters("browser")
	@Test
	public void getdriver()
	{
		this.driver=drive.setupDriver();
	}
	@Parameters({"userName", "password"})
	@Test
	public void singUp(String user, String pwd) throws InterruptedException
	{
		WebElement signup= driver.findElement(By.id("signin2"));
		WebElement userName= driver.findElement(By.xpath("//input[@id='sign-username']"));
		WebElement password= driver.findElement(By.xpath("//input[@id='sign-password']"));
		
		signup.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		userName.sendKeys(user);
		password.sendKeys(pwd);
		
		driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
		
		
		
		drive.alertHandle(driver, alert);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']")).click();
	}
	
	public void tearDown()
	{
		driver.close();
	}
}
