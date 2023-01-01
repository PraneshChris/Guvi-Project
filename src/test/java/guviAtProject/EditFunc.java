package guviAtProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFunc {
	WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void f(String n, String s) {
			driver.findElement(By.name("username")).sendKeys(n);
			driver.findElement(By.name("password")).sendKeys(s);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertTrue(driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"))
							.isEnabled());
			driver.findElement(By.xpath("//span[text()='PIM']")).click();
			driver.findElement(By.xpath("(//*[@class='oxd-icon-button oxd-table-cell-action-space']//following::button)[1]")).click();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div[2]/input"))
		   // driver.findElement(By.xpath("(//*[text()='Employee Id']//following::div)[1]"));
			.sendKeys("siva");
		    
		    driver.findElement(By.xpath("(//div[@class='oxd-grid-3 orangehrm-full-width-grid']//input)[3]")).sendKeys("552001");
		    Actions EID= new Actions(driver);
	    EID.doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys("552001");
		    
	        driver.findElement(By.xpath("(//*[starts-with(text(),'Driver')]//following::input)[1]")).sendKeys("552001");
	      Actions Drivinglic= new Actions(driver);
		    Drivinglic.doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys("552001");
		    
	        driver.findElement(By.xpath("(//*[starts-with(text(),'License Expiry Date')]//following::input)[1]")).sendKeys("2001-05-05");
	        Actions Exp= new Actions(driver);
		    Exp.doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys("05-05-2001");
	    
		    driver.findElement(By.xpath("(//*[starts-with(text(),'SSN Number')]//following::input)[1]")).sendKeys("86753464238");
		    Actions SSN= new Actions(driver);
		    SSN.doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys("86753464238");
		    
		    driver.findElement(By.xpath("(//*[starts-with(text(),'SIN Number')]//following::input)[1]")).sendKeys("67534");
		    Actions SiN= new Actions(driver);
		    SiN.doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys("67534");
		    
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        WebElement nationality = driver.findElement(By.xpath("(//*[text()='-- Select --']//following::div)[1]"));
			Actions act = new Actions(driver);
			act.sendKeys(nationality , "I").sendKeys(Keys.ARROW_DOWN, Keys.RETURN).sendKeys(Keys.ARROW_DOWN, Keys.RETURN).sendKeys(Keys.ENTER, Keys.RETURN).build().perform();
			
		   
		    WebElement marriedStatus = driver.findElement(By.xpath("(//*[text()='Marital Status']//following::i)[1]"));
			Actions ac = new Actions(driver);
			ac.sendKeys(marriedStatus , "S").sendKeys(Keys.ARROW_DOWN, Keys.RETURN).sendKeys(Keys.ENTER).build().perform();
			
		    driver.findElement(By.xpath("(//*[starts-with(text(),'Date of Birth')]//following::input)[1]"));
		    Actions DOB= new Actions(driver);
		    DOB.doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys("2001-05-05");
		    
			//driver.findElement(By.xpath("(//*[starts-with(text(),'Gender')]//following::span)[1]")).click();
			
			driver.findElement(By.xpath("(//*[starts-with(text(),'Military Service')]//following::input)[1]")).sendKeys("NO");
		    Actions Militry= new Actions(driver);
		    Militry.doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys("NO");
		    
			driver.findElement(By.xpath("(//*[starts-with(text(),'Smoker')]//following::span)[1]")).click();
		
			
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("(//*[text()=' * Required']//following::button)[1]")).click();
			
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 WebElement BloodType = driver.findElement(By.xpath("(//*[starts-with(text(),'Blood Type')]//following::div)[1]"));
				Actions group = new Actions(driver);
				group.sendKeys(BloodType , "A+").sendKeys(Keys.ARROW_DOWN, Keys.RETURN).sendKeys(Keys.ENTER).build().perform();
				
			driver.findElement(By.xpath("(//div[@class='oxd-form-actions']//following::button)[2]")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			System.out.println("EDITED  SUCCESSFULLY ");
			
			
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  WebDriverManager.chromedriver().setup();
		  driver= new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		  
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }


	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "Admin", "admin123" },
	     
	    };
	  }
	}



