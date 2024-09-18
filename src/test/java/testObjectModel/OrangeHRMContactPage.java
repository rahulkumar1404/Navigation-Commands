package testObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRMContactPage {
    WebDriver driver;
    
    //Locators
    By contactSalesButton = By.linkText("Contact Sales");
    By fullName = By.name("FullName");
    By contact = By.name("Contact");
    By email = By.name("Email");
    By country = By.name("Country");
    By noOfEmployees = By.name("NoOfEmployees");
    By jobTitle = By.name("JobTitle");
    By recaptchaFrame = By.xpath("//iframe[@title='reCAPTCHA']");
    By recaptchaCheckbox = By.cssSelector(".recaptcha-checkbox-border");
    By comment = By.id("Form_getForm_Comment");
    By actionButton = By.className("action");
    
    //	Constructor
    public OrangeHRMContactPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    //Action Methods
    public void clickContactSales() {
        driver.findElement(contactSalesButton).click();
    }

    public void fillContactForm(String name, String contactNumber, String emailAddress, String countryName, String employees, String jobTitleText) {
        driver.findElement(fullName).sendKeys(name);
        driver.findElement(contact).sendKeys(contactNumber);
        driver.findElement(email).sendKeys(emailAddress);
        Select drpCountry = new Select(driver.findElement(country));
        drpCountry.selectByVisibleText(countryName);
        Select drpEmployee = new Select(driver.findElement(noOfEmployees));
        drpEmployee.selectByVisibleText(employees);
        driver.findElement(jobTitle).sendKeys(jobTitleText);
    }

    public void scrollToRecaptcha() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,400)", "");
    }

    public void switchToRecaptchaFrame() {
        driver.switchTo().frame(driver.findElement(recaptchaFrame));
    }

    public void clickRecaptchaCheckbox() {
        driver.findElement(recaptchaCheckbox).click();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void enterComment(String message) {
        driver.findElement(comment).sendKeys(message);
    }

    public void clickActionButton() {
        WebElement element = driver.findElement(actionButton);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
