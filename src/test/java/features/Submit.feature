Feature: verify warning text in follow us section on main page for all fields
@all @Submit
Scenario: Click on submit button adn see warning text for all fields(first name,second name,email)
Given i go to app Vega
When i accept alert on app
And i click on submit button
Then i see proper warning text for every field
