package page_object;

import mydriver.BaseTest_Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HeaderPage_Project extends BaseTest_Driver {

    public void hooverToMd_Row(){

    }

    public void doSearch(String searchTerm){
        driver.findElement(By.cssSelector("input[id=\"searchTerm\"]")).sendKeys(searchTerm);
        driver.findElement(By.cssSelector(".argos-header__search-button")).click();
        ScreenShotsTaken.captureScreenshot("Searchname");
    }
    public void hooverToSubHeaderElements(String SubHeaderName){

        List<WebElement> SubHeaderElements  = driver.findElements(By.cssSelector(".lg-row.meganav__level-1-list li"));
        for (WebElement element:SubHeaderElements){
            if ( element.getText().equalsIgnoreCase(SubHeaderName)){
                new Actions(driver).moveToElement(element).build().perform();
                break;
            }
        }
    }
    public void selectItemFromSubHeader(String Category){
         List<WebElement> SubHeaderOptions = driver.findElements(By.cssSelector(".meganav__level-3-title"));

         for (WebElement element:SubHeaderOptions){
             new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(element));

             if (element.getText().equalsIgnoreCase(Category)){
                 element.click();
                 break;
             }
         }

    }
    public void selectFromSideBarPage(String SubCategory){
        List<WebElement> sideBar= driver.findElements(By.cssSelector(".sidebar__link.sidebar__link--category"));
        for (WebElement sidebarProducts: sideBar){
            if (sidebarProducts.getText().equalsIgnoreCase(SubCategory)){
                sidebarProducts.click();
                break;
            }
        }
    }
}
