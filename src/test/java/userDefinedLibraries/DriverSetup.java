package userDefinedLibraries;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import testObjectModel.MainTest;
 
 
//Initialize the driver
public class DriverSetup {
	public static WebDriver driver;
	public static String url = "https://google.com";
	public static String browsertype;
	public static WebDriver driverInstantiate(String browser) {
		browsertype = browser;
		try {
		if (browsertype.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Try again!!");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	//driver.navigate().to(url);
	return driver;
	}
	//Closing the driver
	public static void driverTearDown() {
		System.out.println("Browser closed");
		driver.quit();
	}
 
 
}