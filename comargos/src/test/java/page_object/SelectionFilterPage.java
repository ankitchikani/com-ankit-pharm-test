package page_object;

import mydriver.BaseTest_Driver;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;

public class SelectionFilterPage extends BaseTest_Driver {
    public String actualPrice;
    public String PricewithoutSymbol;
    public List<Double> ProductAcualPriceList;

    public void selectFilterBy(String Type, String FilterOptions) {
        expandFilterTypes(Type);
        expandShowMore();


    }

    public void expandFilterTypes(String Type) {
        List<WebElement> ExpandFilter = driver.findElements(By.cssSelector(".ac-accordion__expand-button"));
        for (WebElement element : ExpandFilter) {
            if (element.getText().equalsIgnoreCase(Type)) {
                if (element.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
                    element.click();
                    break;
                }
            }
        }
    }

    public void expandShowMore() {
        WebElement showmore = driver.findElement(By.cssSelector(".ac-accordion__show-more.ac-facet__show-more.button-link"));
        if (showmore.getAttribute("data-expanded").equalsIgnoreCase("false")) {
            showmore.click();
        }
    }

    public void selectFilterOptions(String FilterOption) {

        List<WebElement> FilterOptions = driver.findElements(By.cssSelector(".ac-facet__label"));
        for (WebElement filteroption : FilterOptions) {
            if (filteroption.getText().equalsIgnoreCase(FilterOption)) {
                filteroption.click();
                break;
            }
        }
    }

    public List<Double> getRatingForProducts() {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> CustomerRatings = driver.findElements(By.cssSelector(".ac-star-rating"));
        List<Double> CollectedRating = new ArrayList<>();
        System.out.println("collected total raring: " + CustomerRatings.size());

        for (WebElement Rating : CustomerRatings) {
            String abc = Rating.getAttribute("data-star-rating");
            CollectedRating.add(Double.parseDouble(abc));
        }
        System.out.println("all ratings: " + CollectedRating);
        return CollectedRating;
    }

    public void getPricesForProducts(double highPrice, double lowPrice) {
        try {
            Thread.sleep(8000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> ProductPrices = driver.findElements(By.cssSelector(".ac-product-price__amount"));
        System.out.println("product Prices size: " + ProductPrices.size());
        Iterator<WebElement> itr = ProductPrices.iterator();
        while (itr.hasNext()) {
            String actualPrice = itr.next().getText();
            //System.out.println(actualPrice);
            //String PricewithoutSymbol = actualPrice.replace("£", "");   //System.out.println(PricewithoutSymbol);
            String PricewithoutSymbol = actualPrice.substring(1)  ; //System.out.println(PricewithoutSymbol);
            List<Double> ProductAcualPriceList = new ArrayList<>();
           // double ProductAcualPriceList = Double.parseDouble(PricewithoutSymbol);
            ProductAcualPriceList.add(Double.parseDouble(PricewithoutSymbol));
            System.out.print(ProductAcualPriceList+" ");
            assertThat(ProductAcualPriceList,everyItem(both(greaterThanOrEqualTo(lowPrice)).and (lessThanOrEqualTo(highPrice))));
        }
    }

    public void assertThat(List<Double> productAcualPriceList, Matcher<Iterable<Double>> iterableMatcher) {
       // assertThat(ProductAcualPriceList,everyItem(both(greaterThanOrEqualTo(100)).and (lessThanOrEqualTo(150))));
    }
}

   
   





