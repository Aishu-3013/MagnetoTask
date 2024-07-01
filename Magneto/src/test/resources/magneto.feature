Feature: Account creation and sign-in on Magento

  Scenario Outline: Create an account and sign in
    Given user is on the Magento homepage
    When user navigate to the "Create an Account" page
    And user fill in the account creation form with the following details:
      | firstname      | lastname       | email              | password        | confirmpassword  |
      | <firstname>    | <lastname>     | <email>            | <password>      | <confirmpassword>|
    And user click on the "Create an Account" button
    Then user should see a confirmation message that my account has been created
    When user navigate to the Sign In page
    And user fill in the login form with the following details:
      | email          | password        |
      | <email>        | <password>      |
    And user click on the "Sign In" button
    Then user should be signed in successfully

  Examples:
    | firstname | lastname    | email    | password   | confirmpassword |
    | Aishu     | Kanthasamy  | Aishu.   | password@123| password@123   |
    
