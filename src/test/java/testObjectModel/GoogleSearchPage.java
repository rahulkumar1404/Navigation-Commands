package testObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GoogleSearchPage {
    public WebDriver driver;
    
    //Locators
    By searchBox = By.name("q");
    
    //Constructor
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    //Action Methods
    public void enterSearchText(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }

    public void submitSearch() {
        driver.findElement(searchBox).submit();
    }
}

