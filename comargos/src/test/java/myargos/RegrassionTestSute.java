package myargos;

import mydriver.BaseTest_Driver;
import mydriver.Hooks;
import org.hamcrest.core.Every;
import org.hamcrest.number.OrderingComparison;
import org.junit.Assert;
import org.junit.Test;
import page_object.*;

import java.util.List;


import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.CombinableMatcher.both;

public class RegrassionTestSute extends Hooks {


    @Test
    public void toFindCustomerRating()  {
        new HeaderPage_Project().hooverToSubHeaderElements("TOYS");
        new HeaderPage_Project().selectItemFromSubHeader("Roleplay");
        new SelectionFilterPage().expandFilterTypes("Customer Rating");
        new SelectionFilterPage().expandShowMore();
        new SelectionFilterPage().selectFilterOptions("4or more");
        List<Double> ActualRatingList=new SelectionFilterPage().getRatingForProducts();
        assertThat(ActualRatingList, everyItem(greaterThanOrEqualTo(4.0)));

    }
    @Test
    public void toFindRating(){
        new HeaderPage_Project().hooverToSubHeaderElements("Technology");
        new HeaderPage_Project().selectItemFromSubHeader("Televisions & accessories");
        new HeaderPage_Project().selectFromSideBarPage("Televisions");
        new SelectionFilterPage().expandFilterTypes("Customer Rating");
        new SelectionFilterPage().expandShowMore();
        new SelectionFilterPage().selectFilterOptions("3or more");
        List<Double> ActualRatingList=new SelectionFilterPage().getRatingForProducts();
        assertThat(ActualRatingList, everyItem(greaterThanOrEqualTo(3.0)));

    }
    @Test
    public void findFooterPage(){
        new FooterPage_Project().footerpage("Product care");
        new FooterPage_Project().sideBar_Footer("Gift cards");
    }
    @Test
    public void PriceTag(){
        new HeaderPage_Project().hooverToSubHeaderElements("Technology");
        new HeaderPage_Project().selectItemFromSubHeader("Televisions & accessories");
        new HeaderPage_Project().selectFromSideBarPage("Televisions");
        new SelectionFilterPage().expandFilterTypes("PRICE");
        new SelectionFilterPage().expandShowMore();
        new SelectionFilterPage().selectFilterOptions("£100 - £150");
        new SelectionFilterPage().getPricesForProducts(150.00,100.00);

    }

}
