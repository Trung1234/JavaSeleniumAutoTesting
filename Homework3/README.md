
# Exercise 3: Automated this test case using POM
1. Go to https://www.saucedemo.com/
2. Login with valid account
3. Verify login successful or not
4. Click top left menu
5. Click Logout
6. Verify logout successful or not

### What is Page Object Model in Selenium?
 - Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements. 
It helps reduce code duplication and improves test case maintenance.
 - Reference: https://www.browserstack.com/guide/page-object-model-in-selenium
 
# Exercise 4: DATA DRIVEN TEST using DataProvider
1. Go to https://www.saucedemo.com/
2. Validate 2 fields Username and password with 4 cases:
•	blank user, blank pass
•	invalid user, valid pass
•	invalid pass, valid user
•	valid user, valid pass
