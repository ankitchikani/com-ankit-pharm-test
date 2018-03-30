package com.maven.bdd.training;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import page_object.HeaderPage_Project;
import page_object.HomePage;
import page_object.SelectionFilterPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Stepdefs {
    HomePage homePage = new HomePage();
    HeaderPage_Project headerPage_project=new HeaderPage_Project();
    SelectionFilterPage selectionFilterPage=new SelectionFilterPage();



    @When("^I hover on \"([^\"]*)\"$")
    public void iHoverOn(String SubHeaderName)  {
       headerPage_project.hooverToSubHeaderElements(SubHeaderName);

    }

    @And("^I select a category  \"([^\"]*)\"$")
    public void iSelectACategory(String Category) {
        headerPage_project.selectItemFromSubHeader(Category);

    }

    @And("^I select a subcategory  \"([^\"]*)\"$")
    public void iSelectASubcategory(String Subcategory)  {
        headerPage_project.selectFromSideBarPage(Subcategory);

    }

    @And("^I expand a \"([^\"]*)\" filter type$")
    public void iExpandAFilterType(String Filtertype)  {
        selectionFilterPage.expandFilterTypes(Filtertype);
       selectionFilterPage.expandShowMore();

    }


    @And("^I select a \"([^\"]*)\" filter value$")
    public void iSelectAFilterValue(String Filtertypevalue)  {
        selectionFilterPage.selectFilterOptions(Filtertypevalue);

    }

    @Then("^I should see all respective products set to between (\\d+) and (\\d+)$")
    public void iShouldSeeAllRespectiveProductsSetToBetweenAnd(double highvalue, double lowvalue)  {

        selectionFilterPage.getPricesForProducts(highvalue,lowvalue);

    }

    @Given("^I am homepage$")
    public void iAmHomepage() {

        //assertThat(homePage.isOnHomePage(),is(true));
    }
}
