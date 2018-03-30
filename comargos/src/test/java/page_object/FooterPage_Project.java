package page_object;

import mydriver.BaseTest_Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FooterPage_Project extends BaseTest_Driver
{
    public void footerpage(String FooterOptions){
        List<WebElement> footerElements= driver.findElements(By.cssSelector(".footer__link"));
        for (WebElement element:footerElements){
            if (element.getText().equalsIgnoreCase(FooterOptions)){
                element.click();
                break;
            }
        }

    }
    public void sideBar_Footer(String SidebarOption){
        List<WebElement>Sidebar=driver.findElements(By.cssSelector(".sidebar__link.sidebar__link"));
        for(WebElement element: Sidebar){
            if (element.getText().equalsIgnoreCase(SidebarOption)){
                element.click();
                break;
            }
        }

    }
}
