Feature: As a user to check the recharge option in Undostres

  Scenario: Verify the user is in payment page
    Given User should be navigated in Undostres homepage
    When User must gives the valid credentials
    And Select the siguiente option
    Then The user should navigated to payment page

  Scenario: To verify the user should recharged successfully
    Given User must be in payment page
    When User must gives the valid card credentials
    And User proceed the recharge option
    And User must provide the login credentials and Click the captcha manually
    Then The user should gets successful message
     