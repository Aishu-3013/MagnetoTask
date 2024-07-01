package org.pom;

import java.time.Duration;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MagnetoPom extends BaseClass {

	public MagnetoPom() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='panel header']//a[text()='Create an Account']")
	private WebElement createAccount;

	public WebElement getCreateAccount() {
		return createAccount;
	}

	@FindBy(id = "firstname")
	private WebElement firstName;

	public WebElement getFirstName() {
		return firstName;
	}

	@FindBy(id = "lastname")
	private WebElement lastName;

	public WebElement getLastName() {
		return lastName;
	}

	@FindBy(id = "email_address")
	private WebElement emailAddress;

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	@FindBy(id = "password")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(id = "password-confirmation")
	private WebElement passwordConfirmation;

	public WebElement getPasswordConfirmation() {
		return passwordConfirmation;
	}

	@FindBy(xpath = "//button[@title='Create an Account']")
	private WebElement createAnAccount;

	public WebElement getCreateAnAccount() {
		return createAnAccount;
	}

	@FindBy(xpath = "//div[@role='alert']/div/div")
	private WebElement accountCreationConfirmation;

	public WebElement getAccountCreationConfirmation() {
		return accountCreationConfirmation;
	}

	@FindBy(xpath = "//div[@class='panel header']//li[@class='customer-welcome']//button")
	private WebElement accountActionSwitch;

	public WebElement getAccountActionSwitch() {
		return accountActionSwitch;
	}

	@FindBy(xpath = "(//div[@class='customer-menu']//a[contains(text(),'Sign Out')])[1]")
	private WebElement signOut;

	public WebElement getSignOut() {
		return signOut;
	}

	@FindBy(xpath = "//div[@class='panel header']//ul/li/a[contains(text(),'Sign In')]")
	private WebElement signIn;

	public WebElement getSignIn() {
		return signIn;
	}

	@FindBy(id = "email")
	private WebElement signInEmail;

	public WebElement getSignInEmail() {
		return signInEmail;
	}

	@FindBy(id = "pass")
	private WebElement signInPass;

	public WebElement getSignInPass() {
		return signInPass;
	}

	@FindBy(xpath = "//button[@class='action login primary']")
	private WebElement signInButton;

	public WebElement getSignButton() {
		return signInButton;
	}

}
