package stepdef;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.baseclasscucumber;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homepage;
import utilities.excelcode;
public class definitions extends baseclasscucumber {
	WebDriver driver;
	static Scenario scenario;
	String name;
	private homepage page;
	@Before
	public void start(Scenario sc) {
		scenario = sc;
	}
	@After
	public void close() {
		driver.quit();
	}
	@AfterStep
	public void addscreen(Scenario scenario) {
		final byte[] shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(shot, "image/png", "image");
	}

	@Given("User navigating to the given website")
	public void user_navigating_to_the_given_website() throws IOException {
		this.driver = navigateTo();
		page = new homepage(driver);
	}
	@When("User click on the Customer Login button")
	public void user_click_on_the_customer_login_button() {
		page.clickcustomerlogin();
	}
	@Then("User should be on the Customer Login page")
	public void user_should_be_on_the_customer_login_page() {
		String actualurl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer";
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlMatches(actualurl));
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, actualurl);
	}
	@And("User select the name from the dropdown list")
	public void user_select_the_name_from_the_dropdown_list() {
		page.selectname();
	}
	@And("User click on the Login button")
	public void user_click_on_the_login_button() {
		page.clkloginbutton();
	}
	@Then("User should see the welcome message, account number, and balance")
	public void user_should_see_the_welcome_message_account_number_and_balance() {

		Assert.assertEquals("Welcome  !!", page.getwelcomemsg());

	}
	// ------------------------------------------------logincomplted---------------------------------//
	@When("User click on the Deposit tab")
	public void user_click_on_the_deposit_tab() {
		page.clickcustomerlogin();
		page.selectname();
		page.clkloginbutton();
		page.clickDepositTab();
	}
	@And("User click on the Deposit button")
	public void user_click_on_the_deposit_button() {
		page.clickSubmitbutton();
	}
	@And("User enter {string} in deposit input box")
	public void user_enter_in_deposit_input_box(String string) {
		System.out.println(string);
		page.entermount(string);
	}
	@Then("User should see the message as Deposit Succesful for valid {string} and no result for invalid amount")
	public void user_should_see_the_message_as_deposit_succesful_for_valid_and_no_result_for_invalid_amount(
			String string) {
		if (Integer.parseInt(string) > 0) {
			Assert.assertEquals("Deposit Successful", page.getDepositMsg());
		} else {
			Assert.assertEquals(page.getDepositMsg(), null);
		}
	}
	// ----------------------------------------------------deposit-completed----------------------------------------//
	@And("User enter {string} in the withdraw input box")
	public void user_enter_in_the_withdraw_input_box(String string) {
		page.entermount(string);
	}
	@Then("User should see the message as Withdraw Succesful for valid {string} and no result for invalid amount")
	public void user_should_see_the_message_as_withdraw_succesful_for_valid_and_no_result_for_invalid_amount(
			String string) {
		if (Integer.parseInt(string) > 0) {
			Assert.assertEquals("Transaction successful", page.getDepositMsg());
		} else {
			Assert.assertEquals(page.getDepositMsg(), null);
		}
	}
	@When("User click on the Withdraw tab")
	public void user_click_on_the_withdraw_tab() {
		page.clickcustomerlogin();
		page.selectname();
		page.clkloginbutton();
		page.clickWithdrawTab();
	}
	@And("User click on the Withdraw button")
	public void user_click_on_the_withdraw_button() {
		page.clickSubmitbutton();
	}
	// ---------------------------------------------deposit-scenario-completed-----------------------------//
	// ----------------------------------------------transactions------------------------------------------//
	@When("User click on the Transactions button")
	public void user_click_on_the_transactions_button() {
		page.clickcustomerlogin();
		page.selectname();
		page.clkloginbutton();
		page.transactionTabClk();
	}
	@Then("User should be on the Transactions page")
	public void user_should_be_on_the_transactions_page() {
		Assert.assertEquals("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx",
				driver.getCurrentUrl());
	}
	@And("User should see the transaction details in a table")
	public void user_should_see_the_transaction_details_in_a_table() {
		Assert.assertTrue(page.validateTable());
	}
	// ---------------------------------------Transactions-completed--------------------------------------//
	@When("User click on the logout button")
	public void user_click_on_the_logout_button() {
		page.clickcustomerlogin();
		page.selectname();
		page.clkloginbutton();
		page.logoutclk();
	}
	@Then("User should be on the login page")
	public void user_should_be_on_the_login_page() {
		Assert.assertEquals("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer",
				driver.getCurrentUrl());
	}
	// -----------------------------home-button-----------------------------------------------//
	@When("User click on the home button")
	public void user_click_on_the_home_button() {
		page.clickcustomerlogin();
		page.selectname();
		page.clkloginbutton();
		page.logoutclk();
		page.homeButtonClk();
	}
	@And("User should be on the landing page and click on the Bank Manager Login button")
	public void user_should_be_on_the_landing_page_and_click_on_the_bank_manager_login_button() {
		page.managerLoginClk();
	}
	@Then("User should be on the Manager page")
	public void user_should_be_on_the_manager_page() {
		Assert.assertEquals("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager",
				driver.getCurrentUrl());
	}
	// ------------------------------------add-customer------------------------------------------//
	@When("User click on the Add Customer button")
	public void user_click_on_the_add_customer_button() {
		page.managerLoginClk();
	}
	@And("User fill the input elements with data from the {string} excel sheet")
	public void user_fill_the_input_elements_with_data_from_the_excel_sheet(String string) throws IOException {
		excelcode read = new excelcode();
		String[][] data = read.testdata(string);
		page.addCustomerClk();
		page.EnterCustomerDetails(data[0][0], data[0][1], data[0][2]);
	}
	@Then("User should see the customer id in the alert box along with a success message")
	public void user_should_see_the_customer_id_in_the_alert_box_along_with_a_success_message() {
		page.clickSubmitbutton();
		String txt = page.alerthandling();
		txt = txt.replace("Customer added successfully with customer id :", "");
		System.out.println(txt);
		Assert.assertEquals("6", txt);

	}
	// --------------------------------------add-customer-closed-----------------------------------------//
	// ---------------------------------------------------open-account------------------------------------//
	@When("User click on the Open Account button with existing data from {string}")
	public void user_click_on_the_open_account_button_with_existing_data_from(String string) throws IOException {
		page.managerLoginClk();
		excelcode read = new excelcode();
		String[][] data = read.testdata(string);
		page.addCustomerClk();
		page.EnterCustomerDetails(data[0][0], data[0][1], data[0][2]);
		page.clickSubmitbutton();
		page.alerthandling();
		page.openAccountClk();
	}
	@And("User fill the input elements with data from the {string}")
	public void user_fill_the_input_elements_with_data_from_the(String string) throws IOException {
		excelcode read = new excelcode();
		String[][] data = read.testdata(string);
		page.selectNameForManager(data[0][0] + " " + data[0][1]);
		page.currencySelect(data[0][3]);
	}
	@Then("User should see the account details")
	public void user_should_see_the_account_details() {
		page.clickSubmitbutton();
		System.out.println(page.alerthandling());
	}
	// ----------------------------------------------------open-account-------------------------------//
	// -----------------------------------------------------------customer---------------------//
	@When("User click on the Customers button")
	public void user_click_on_the_customers_button() {
		page.managerLoginClk();
		page.customersClk();
	}
	@Then("User should see the customer details in a table")
	public void user_should_see_the_customer_details_in_a_table() {
		Assert.assertTrue(page.validateTable());
	}
	@And("User should see the search input box functionality")
	public void user_should_see_the_search_input_box_functionality() {
		Assert.assertTrue(page.validateSearchbox());
	}
	// -----------------------------------------------------------customers-closed----------------------------------------//
	// -------------------------------------------------------------delete---------------------------------------------------//
	@When("User click on the delete button against the newly added customer from the {string}")
	public void user_click_on_the_delete_button_against_the_newly_added_customer_from_the(String string)
			throws IOException {
		page.managerLoginClk();
		excelcode read = new excelcode();
		String[][] data = read.testdata(string);
		page.addCustomerClk();
		page.EnterCustomerDetails(data[0][0], data[0][1], data[0][2]);
		page.clickSubmitbutton();
		page.alerthandling();
		page.openAccountClk();
		page.selectNameForManager(data[0][0] + " " + data[0][1]);
		page.currencySelect(data[0][3]);
		page.clickSubmitbutton();
		page.alerthandling();
		page.customersClk();
		name = data[0][0];
		page.Entersearchbox(data[0][0]);
		System.out.println(page.elementpresent());
		page.clickdelete();
	}
	@Then("User should see the customer removed from the table")
	public void user_should_see_the_customer_removed_from_the_table() {
		page.Entersearchbox(name);
		Assert.assertFalse(page.elementpresent());
	}
}




//// Write code here that turns the phrase above into concrete actions
//throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the Customer Login button")
//public void user_click_on_the_customer_login_button() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should be on the Customer Login page")
//public void user_should_be_on_the_customer_login_page() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User select the name from the dropdown list")
//public void user_select_the_name_from_the_dropdown_list() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User click on the Login button")
//public void user_click_on_the_login_button() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should see the welcome message, account number, and balance")
//public void user_should_see_the_welcome_message_account_number_and_balance() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the Deposit tab And User enter {string} in deposit input box")
//public void user_click_on_the_deposit_tab_and_user_enter_in_deposit_input_box(String string) {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the Deposit button")
//public void user_click_on_the_deposit_button() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should see the message as Deposit Succesful for valid {string} and no result for invalid amount")
//public void user_should_see_the_message_as_deposit_succesful_for_valid_and_no_result_for_invalid_amount(String string) {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the Withdraw tab")
//public void user_click_on_the_withdraw_tab() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User enter {string} in the withdraw input box")
//public void user_enter_in_the_withdraw_input_box(String string) {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the Withdraw button")
//public void user_click_on_the_withdraw_button() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should see the message as Withdraw Succesful for valid {string} and no result for invalid amount")
//public void user_should_see_the_message_as_withdraw_succesful_for_valid_and_no_result_for_invalid_amount(String string) {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the Transactions button")
//public void user_click_on_the_transactions_button() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should be on the Transactions page")
//public void user_should_be_on_the_transactions_page() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should see the transaction details in a table")
//public void user_should_see_the_transaction_details_in_a_table() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the logout button")
//public void user_click_on_the_logout_button() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should be on the login page")
//public void user_should_be_on_the_login_page() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the home button")
//public void user_click_on_the_home_button() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User should be on the landing page and click on the Bank Manager Login button")
//public void user_should_be_on_the_landing_page_and_click_on_the_bank_manager_login_button() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should be on the Manager page")
//public void user_should_be_on_the_manager_page() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the Add Customer button And User fill the input elements with data from the {string} excel sheet Then User should see the customer id in the alert box along with a success message")
//public void user_click_on_the_add_customer_button_and_user_fill_the_input_elements_with_data_from_the_excel_sheet_then_user_should_see_the_customer_id_in_the_alert_box_along_with_a_success_message(String string) {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the Open Account button with existing data from {string}")
//public void user_click_on_the_open_account_button_with_existing_data_from(String string) {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User fill the input elements with data from the {string}")
//public void user_fill_the_input_elements_with_data_from_the(String string) {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should see the account details")
//public void user_should_see_the_account_details() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the Customers button")
//public void user_click_on_the_customers_button() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should see the customer details in a table")
//public void user_should_see_the_customer_details_in_a_table() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@Then("User should see the search input box functionality")
//public void user_should_see_the_search_input_box_functionality() {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//@When("User click on the delete button against the newly added customer from the {string}")
//public void user_click_on_the_delete_button_against_the_newly_added_customer_from_the(String string) {
//	// Write code here that turns the phrase above into concrete actions
//	throw new io.cucumber.java.PendingException();
//}
//
//
//// Write code here that turns the phrase above into concrete actions
//throw new io.cucumber.java.PendingException();
//}
//
//
//"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/ListTx". Current url:
//	"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx"