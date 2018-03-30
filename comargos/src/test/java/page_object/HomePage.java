package page_object;

import mydriver.BaseTest_Driver;
import org.openqa.selenium.By;

public class HomePage extends BaseTest_Driver
{

    public void isOnHomePage() {

        driver.getCurrentUrl().endsWith(".co.uk/");
    }


    public void doSearch(String searchTerm) {
        driver.findElement(By.id("small-searchterms")).sendKeys(searchTerm);
        driver.findElement(By.cssSelector(".search-box-button")).click();
    }

    public String getHomePageCurrentURl() {
        return driver.getCurrentUrl();
    }
}