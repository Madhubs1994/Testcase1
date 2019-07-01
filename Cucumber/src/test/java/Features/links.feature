Feature: Verifying the links in a website.

Scenario: navigating to the website and verify the links in the website
Given launch the URL
When links are verified with the status code
Then links are validated with their respective status codes
