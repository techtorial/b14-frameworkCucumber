@regression
Feature: Testing the login positive and negative functionalities

  Scenario: Validating the successful login for OpenMrs
    Given User navigates to the OpenMrs website and provides credentials and location 'Inpatient Ward'
    Then User validates the title 'Home' and url 'https://demo.openmrs.org/openmrs/referenceapplication/home.page'

  Scenario Outline: Validating the negative login for OpenMrs
    Given User navigates to the OpenMrs website and provides credentials '<username>','<password>' and location '<location>'
    Then User validates the error message 'Invalid username/password. Please try again.'
    Examples:
      | username | password | location       |
      | Ahmet    | Admin123 | Inpatient Ward |
      | admin    | admin123 | Isolation Ward |
      |          | Admin123 | Laboratory     |
      | admin    |          | Pharmacy       |





