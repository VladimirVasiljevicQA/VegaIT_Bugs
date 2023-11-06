Feature:  Explore application and try some functionalities

@all @Search
Scenario Outline: Go to search option, in search field input dots and click on search icon
Given i go to app VegaIT
When i accept alert
And i click on Menu button
And i enter "<data>" in search field
And i click on search icon
Then i see search results

Examples:
    | data  |
    | ..    |
    | ...   |
    

 