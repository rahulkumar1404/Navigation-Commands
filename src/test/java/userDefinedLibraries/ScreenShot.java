package userDefinedLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class ScreenShot {
	public static String filepath = ".\\screenshot\\";
	public static WebDriver driver;
	public static void screenShotTC(WebDriver scdriver,String fileName)throws IOException{
		File src=((TakesScreenshot)scdriver).getScreenshotAs(OutputType.FILE);       
		try {
			FileUtils.copyFile(src, new File(filepath+fileName+".png"));
        }
		catch (IOException e)      
		{
			System.out.println(e.getMessage());      
		}
  }
 
}