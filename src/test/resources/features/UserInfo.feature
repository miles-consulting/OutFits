Feature: User Information
  As an customer, I want to be able to edit/delete my information

  Background: Resetting all user data
    Given I reset all user data including(Address/Phone number/password)

  Scenario: Edit Phone number
    Given I logged in to outfittery portal

    When I edit phone number to "123456789"
    Then Phone number should be updated successfully


#  Scenario: Edit User address
#    Given I logged in to outfittery portal
#
#    When I edit address with below details
#      | Street     | StreetNo | Zip     | City   | Country |
#      | TestStreet | 99       | 9999999 | Boston | US      |
#    Then User's address should be updated
#
#
#  Scenario: Edit Password
#    Given I logged in to outfittery portal
#
#    When I edit password
#    Then password should be updated on next login
