package Pages;

import Utilities.DriverClass;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ViewAllOrders extends _01_Parent {

    public ViewAllOrders(){

        PageFactory.initElements(DriverClass.getDriver(),this);

    }

    @FindAll({
            @FindBy(xpath = "//table[@class='SampleTable']//tr//td[2]")
    })
    private List<WebElement> NameList;
    @FindAll({
            @FindBy(xpath = "//table[@class='SampleTable']//tr//td[3]")
    })
    private List<WebElement> ProductList;

    @FindAll({
            @FindBy(xpath = "//table[@class='SampleTable']//tr//td[6]")
    })
    private List<WebElement> StreetList;
    @FindAll({
            @FindBy(xpath = "//table[@class='SampleTable']//tr//td[7]")
    })
    private List<WebElement> Citylist;
    @FindAll({
            @FindBy(xpath = "//table[@class='SampleTable']//tr//td[8]")
    })
    private List<WebElement> StateList;
    @FindAll({
            @FindBy(xpath = "//table[@class='SampleTable']//tr//td[9]")
    })
    private List<WebElement> ZipList;
    @FindAll({
            @FindBy(xpath = "//table[@class='SampleTable']//tr//td[10]")
    })
    private List<WebElement> CardList;
    @FindAll({
            @FindBy(xpath = "//table[@class='SampleTable']//tr//td[11]")
    })
    private List<WebElement> CardNumberList;
    @FindAll({
            @FindBy(xpath = "//table[@class='SampleTable']//tr//td[12]")
    })
    private List<WebElement> ExpList;


    @FindBy(xpath = "//a[text()='Check All']")
    private WebElement checkAll;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    private WebElement deleteSelected;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    private WebElement productDropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    private WebElement priceperUnit;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement CustomerName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement street;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement City;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement State;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement Zip;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    private WebElement Visa;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    private WebElement MasterCard;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    private WebElement AmericanExpress;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement CardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement ExpireDate;

    @FindBy(linkText = "Order")
    private WebElement OrderButton;

    @FindBy(linkText = "View all orders")
    private WebElement ViewAllOrders;

    @FindBy(linkText = "Process")
    private WebElement Process;

    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement Calculate;

    @FindBy(xpath = "//span[@style='color: red; display: inline;']")
    public WebElement redText;




    public void matchTheCount(int expected){


        Assert.assertTrue(NameList.size()==expected);
    }

    WebElement myElement;

    public void findElementAndClickFunction(String ElementName){

        switch (ElementName) {
            case "checkAll":
                myElement = checkAll;
                break;
            case "deleteSelected":
                myElement = deleteSelected;
                break;
            case "Visa":
                myElement = Visa;
                break;
            case "MasterCard":
                myElement = MasterCard;
                break;
            case "American Express":
                myElement = AmericanExpress;
                break;
            case "OrderButton":
                myElement = OrderButton;
                break;
            case "ViewAllOrders":
                myElement = ViewAllOrders;
                break;
            case "Calculate":
                myElement = Calculate;
                break;
            case "Process":
                myElement = Process;
                break;

        }

        clickFunction(myElement);
    }

    public void findElementAndSendKeysFunction(String ElementName , String value){

//        Find the element in this class and send the element to sendKeysFunction
        switch (ElementName){
            case "quantity":
                myElement = quantity;
                break;
            case "priceperUnit":
                myElement = priceperUnit;
                break;
            case "CustomerName":
                myElement = CustomerName;
                break;
            case "street":
                myElement = street;
                break;
            case "City":
                myElement = City;
                break;
            case "State":
                myElement = State;
                break;
            case "Zip":
                myElement = Zip;
                break;
            case "CardNumber":
                myElement = CardNumber;
                break;
            case "ExpireDate":
                myElement = ExpireDate;
                break;


        }
//            Create a method in parentClass which is going to wait first and sendKeys
        sendKeysFunction(myElement , value);

    }

    public void verifyTheDataFromTheTableAccodingToName(String Name , List<String> ExpectedText){

        ArrayList<String> actualText = new ArrayList<>();

        for(int i = 0 ; i <NameList.size() ; i++){

            System.out.println(NameList.get(i).getText() + "<<----nameList is here ");
            System.out.println(Name + "<-- name is here ");
            if (NameList.get(i).getText().contains(Name)){

                actualText.add(ProductList.get(i).getText());
                actualText.add(StreetList.get(i).getText());
                actualText.add(Citylist.get(i).getText());
                actualText.add(StateList.get(i).getText());
                actualText.add(ZipList.get(i).getText());
                actualText.add(CardList.get(i).getText());
                actualText.add(CardNumberList.get(i).getText());
                actualText.add(ExpList.get(i).getText());
                System.out.println(actualText + "<<<------- actual text list is here ");
                break;

            }


        }

        for(int i = 0 ; i < ExpectedText.size() ; i++){

            System.out.println(actualText.size());
            System.out.println(ExpectedText.size());
            Assert.assertEquals(actualText.get(i) , ExpectedText.get(i));

        }


    }

    public void handleDropdwon(String whichValue){

        waitUntilVisible(productDropdown);

        Select select = new Select(productDropdown);

        select.selectByVisibleText(whichValue);

    }

}
