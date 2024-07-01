package org.stepdefinition;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.analysis.function.Exp;
import org.base.BaseClass;
import org.configuration.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pom.MagnetoPom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinition extends BaseClass {
	public static MagnetoPom pom;
	public static String emailValue;

	@Given("user is on the Magento homepage")
	public void user_is_on_the_magento_homepage() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user navigate to the {string} page")
	public void user_navigate_to_the_page(String string) {
		try {
			pom = new MagnetoPom();
			pom.getCreateAccount().click();
			Thread.sleep(2000);
			System.out.println("User succefully navigated to the create account page");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user fill in the account creation form with the following details:")
	public void user_fill_in_the_account_creation_form_with_the_following_details(
			io.cucumber.datatable.DataTable dataTable) {
		try {
			List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
			pom = new MagnetoPom();

			for (Map<String, String> columns : rows) {
				WebElement firstName = pom.getFirstName();
				firstName.sendKeys(columns.get("firstname"));
				WebElement lastName = pom.getLastName();
				lastName.sendKeys(columns.get("lastname"));
				WebElement emailAddress = pom.getEmailAddress();
				String em = columns.get("email");
				emailAddress.sendKeys(em + System.currentTimeMillis() + "@gmail.com");
				emailValue = emailAddress.getAttribute("value");
				WebElement password = pom.getPassword();
				password.sendKeys(columns.get("password"));
				WebElement passwordConfirmation = pom.getPasswordConfirmation();
				passwordConfirmation.sendKeys(columns.get("confirmpassword"));
				Thread.sleep(2000);
			}
			System.out.println("Successfully entered all the details");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user click on the {string} button")
	public void user_click_on_the_button(String string) {
		try {
			pom = new MagnetoPom();
			WebElement createAnAccount = pom.getCreateAnAccount();
			createAnAccount.click();
			Thread.sleep(2000);
			System.out.println("Succesfully Clicked the create aacount");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("user should see a confirmation message that my account has been created")
	public void user_should_see_a_confirmation_message_that_my_account_has_been_created() {
		try {
			pom = new MagnetoPom();
			String text = pom.getAccountCreationConfirmation().getText().trim();
			Assert.assertEquals("Thank you for registering with Main Website Store.", text);
			System.out.println("Account successfully created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user navigate to the Sign In page")
	public void user_navigate_to_the_sign_in_page() {
		try {
			pom = new MagnetoPom();
			pom.getAccountActionSwitch().click();
			Thread.sleep(1500);
			pom.getSignOut().click();
			Thread.sleep(2000);
			pom.getSignIn().click();
			System.out.println("Successfully Navigated to Sigin page");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user fill in the login form with the following details:")
	public void user_fill_in_the_login_form_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
		try {
			List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
			Thread.sleep(1500);
			pom = new MagnetoPom();
			for (Map<String, String> columns : rows) {
				pom.getSignInEmail().sendKeys(emailValue);
				pom.getSignInPass().sendKeys(columns.get("password"));
			}
			pom.getSignButton().click();
			System.out.println("Successfully Filled LogIn Information");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("user should be signed in successfully")
	public void user_should_be_signed_in_successfully() {
		try {
			String title = driver.getTitle().trim();
			if (title.equalsIgnoreCase("My Account")) {
				System.out.println("Signed in Successfully");
			} else {
				System.out.println("Sigin in unsuccessfull");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
