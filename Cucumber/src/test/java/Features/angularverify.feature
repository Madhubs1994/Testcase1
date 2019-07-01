Feature: Verifying angular is loaded  in a website.

Scenario: navigating to the website and verify angular elements are loaded 
Given launch the URL for angular
When wait for angular elements to load
Then verify that angular elemnts are loaded in the webpage
