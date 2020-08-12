package StepDefinition;

import Pages.ViewAllOrders;
import Utilities.DriverClass;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class allOrdersStep {

    ViewAllOrders viewAllOrders = new ViewAllOrders();

    @Given("^Navigate to website and login$")
    public void navigate_to_website_and_login() throws Throwable {

        WebDriver driver = DriverClass.getDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        driver.manage().window().maximize();
    }

    @Given("^Verify (\\d+) items are in the page$")
    public void verify_items_are_in_the_page(int num) throws Throwable {

        viewAllOrders.matchTheCount(num);

    }

    @When("^Click on items$")
    public void click_on_items(DataTable ElementFromFeature)  {

        List<String> eachElement =  ElementFromFeature.asList(String.class);

        for(int i =0 ; i<eachElement.size() ; i++){

            viewAllOrders.findElementAndClickFunction(eachElement.get(i));

        }
    }


    @When("^I delete the \"([^\"]*)\" and click on the delete selected$")
    public void i_delete_the_and_click_on_the_delete_selected(String arg1)   {

        viewAllOrders.findElementAndClickFunction("checkAll");
        viewAllOrders.findElementAndClickFunction("checkAll");
    }


    @When("^Verify data for \"([^\"]*)\"$")
    public void verify_data_for(String name, DataTable ElementFromFeature){

        List<String> eachElement =  ElementFromFeature.asList(String.class);


        viewAllOrders.verifyTheDataFromTheTableAccodingToName(name, eachElement);
    }


    @When("^Fill the order form$")
    public void fill_the_order_form(DataTable elements) throws Throwable {

        List<List<String>> AllElementsNameAndValue= elements.asLists(String.class);

        for(int i =0 ; i <AllElementsNameAndValue.size() ; i++){

            System.out.println(AllElementsNameAndValue.get(i).get(0));
            System.out.println(AllElementsNameAndValue.get(i).get(1));

            viewAllOrders.findElementAndSendKeysFunction(AllElementsNameAndValue.get(i).get(0) ,AllElementsNameAndValue.get(i).get(1));

        }




    }

    @And("^HandleDropdown \"([^\"]*)\"$")
    public void handledropdown(String dropdownName) throws Throwable {

        viewAllOrders.handleDropdwon(dropdownName);
    }

    @Then("^Verify red text is displayed$")
    public void verifyRedTextIsDisplayed() {

        viewAllOrders.waitUntilVisible(viewAllOrders.redText);
        viewAllOrders.redText.isDisplayed();
    }
}
