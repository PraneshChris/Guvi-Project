package guviAtProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteFunc {
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
			driver.findElement(By.xpath("(//*[@class='oxd-icon-button oxd-table-cell-action-space']//preceding::button)[6]")).click();
			driver.findElement(By.xpath("//*[text()=' Yes, Delete ']")).click();
			
			System.out.println("DELETED SUCCESSFULLY COMPLETED");
			
		  
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
		  //driver.close();
	  }


	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "Admin", "admin123" },
	      
	    };
	  }
	}



