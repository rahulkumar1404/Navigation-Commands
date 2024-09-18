package testObjectModel;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ScreenShot;

public class MainTest {
    static WebDriver driver;
    static GoogleSearchPage googleSearchPage;
    static OrangeHRMContactPage orangeHRMContactPage;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the browser name (either chrome or edge):");
        String browserName = scanner.nextLine();
        driver = DriverSetup.driverInstantiate(browserName);

        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.enterSearchText("Orange HRM demo");
        googleSearchPage.submitSearch();

        // Wait for the search results to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20, 5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fprs\"]/span[1]")));

        // Navigate back to the Google search page
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver.getTitle().contains("Google")) {
            System.out.println("Google page is displayed.");
        }

        // Navigate forward to the search results page
        driver.navigate().forward();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fprs\"]/span[1]")));

        // Verify if the search results page is displayed
        if (driver.getTitle().contains("Orange HRM demo")) {
            System.out.println("Search results page is displayed.");
        }

        // Navigate to the OrangeHRM website
        driver.navigate().to("https://www.orangehrm.com/");

        orangeHRMContactPage = new OrangeHRMContactPage(driver);
        orangeHRMContactPage.clickContactSales();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact Sales")));

        orangeHRMContactPage.fillContactForm("Vikram Rathode", "1234567890", "rathodeitsolutions.test@test.com", "India", "11 - 15", "Fresher");
        orangeHRMContactPage.scrollToRecaptcha();
        orangeHRMContactPage.switchToRecaptchaFrame();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orangeHRMContactPage.clickRecaptchaCheckbox();
        orangeHRMContactPage.switchToDefaultContent();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orangeHRMContactPage.clickActionButton();
        try {

            ScreenShot.screenShotTC(driver, "ScreenShot1");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        orangeHRMContactPage.enterComment("This is a test message.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orangeHRMContactPage.clickActionButton();

        DriverSetup.driverTearDown();
    }
}
