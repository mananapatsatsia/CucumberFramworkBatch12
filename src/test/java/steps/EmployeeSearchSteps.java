package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

import java.util.concurrent.TimeUnit;

public class EmployeeSearchSteps  extends CommonMethods {
    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        openBrowserAndLaunchApplication();
    }
    @When("user enters valid admin credentials")
    public void user_enters_valid_admin_credentials() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        WebElement usernamefield=driver.findElement(By.id("txtUsername"));
        usernamefield.sendKeys(ConfigReader.getPropertyValue("username"));

        WebElement passwordfield=driver.findElement(By.id("txtPassword"));
       // passwordfield.sendKeys(ConfigReader.getPropertyValue("password"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);

        sendText(usernamefield,ConfigReader.getPropertyValue("username"));
    }
    @And("user clicks on loggin button")
    public void user_clicks_on_loggin_button() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        WebElement loginButton=driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }
    @And("user navigated to employee list page")
    public void user_navigated_to_employee_list_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        WebElement pimOption=driver.findElement(By.id("menu_pim_viewPimModule"));
        pimOption.click();

        WebElement empListOption=driver.findElement(By.id("menu_pim_viewEmployeeList"));
        empListOption.click();
    }
    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        WebElement searchId = driver.findElement(By.id("empsearch_id"));
        searchId.sendKeys("8510142");

    }
    @And("user clicks on search button")
    public void user_clicks_on_search_button() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        WebElement searchButton = driver.findElement(By.id("searchBtn"));
        searchButton.click();
    }
    @Then("user is able to see employee information")
    public void user_is_able_to_see_employee_information() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("Result displayed");
        tearDown();//to close window
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT,TimeUnit.SECONDS);
        WebElement searchName=driver.findElement(By.id("empsearch_employee_name_empName"));
        searchName.sendKeys("Zubair");
    }


}
