package stepdefinations;

import org.junit.Assert;

import com.massmutual.factory.DriverFactory;
import com.massmutual.pages.TransactionalDataPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransactionalData {

	private TransactionalDataPage tdpage = new TransactionalDataPage(DriverFactory.getDriver());

	@Given("user lands on the {string}")
	public void user_lands_on_the(String actualtitle) {
		// to check if user has landed on the correct page
		Assert.assertEquals(tdpage.getPageTitle(),actualtitle);
	}

	@When("user verifies the count of values and value_lables")
	public void user_verifies_the_count_of_values_and_value_lables() {
		// to check if the first and last label/values are displayed
		Assert.assertTrue(tdpage.isTotalBalanceDisplayed());
		Assert.assertTrue(tdpage.isFirstLableDisplayed());
	}

	@Then("total count of values should be {int}")
	public void total_count_of_values_should_be(Integer countValue) {
		int value_count = tdpage.getValuesCount();
		Assert.assertEquals(value_count, (int)countValue);
	}

	@Then("total count of value_lables should be {int}")
	public void total_count_of_value_lables_should_be(Integer countLable) {
		int label_count = tdpage.getLablesCount();
		Assert.assertEquals(label_count, (int)countLable);
	}

	@When("user verifies the transactional values")
	public void user_verifies_the_transactional_values() {
		// to check if the first and last label/values are displayed
		Assert.assertTrue(tdpage.isTotalBalanceDisplayed());
		Assert.assertTrue(tdpage.isFirstLableDisplayed());
	}

	@Then("values should be greater than {int}")
	public void values_should_be_greater_than(Integer int1) {
		Assert.assertTrue(tdpage.rangeOfVlaues());
	}

	@When("user verifies the total balance and transactional values")
	public void user_verifies_the_total_balance_and_transactional_values() {
		// to check if the first and last label/values are displayed
		Assert.assertTrue(tdpage.isTotalBalanceDisplayed());
		Assert.assertTrue(tdpage.isFirstLableDisplayed());
	}

	@Then("total balance should be equal to the sum of values listed")
	public void total_balance_should_be_equal_to_the_sum_of_values_listed() {
		Assert.assertTrue(tdpage.verifyTotalBalance());
	}

	@Then("prefix should be {string}")
	public void prefix_should_be_$() {
		Assert.assertTrue(tdpage.verify$CurrencyFormat());
	}

	@Then("values should have digit decimal value")
	public void values_should_have_digit_decimal_value() {
		Assert.assertTrue(tdpage.verifyDecimalCurrencyFormat());
	}

}
