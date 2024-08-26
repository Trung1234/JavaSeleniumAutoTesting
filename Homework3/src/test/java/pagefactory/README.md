### Page Object Model
1.  Page Object Model is a design pattern to create Object Repository for web UI elements. Under this model, for each web page in the application, there should be corresponding page class. This Page class will find the WebElements of that web page and also contains Page methods which perform operations on those WebElements.
2. Advantages:
 - Reduces the duplication of code
 - UI changes only affect to a single Page Object, not to the actual test codes
 - Makes tests more readable
 - Improves the maintainability of tests

   ![image](https://github.com/user-attachments/assets/401b5335-3c96-4ebe-a1a4-68b464febe90)

# Practice 1:

1. Navigate to http://demo.guru99.com/v4/index.php
2. Login with valid account
3. Verify login successful or not
4. Log out
5. Verify logout successful or not
 Guru99 Bank Home Page 
 
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
2. Validate 2 fields Username and password with 4 cases:<space><space>
	 - blank user, blank pass.		 <space><space>
	 - invalid user, valid pass	.	<space><space> 
	 - invalid pass, valid user	.<space><space> 
	 - valid user, valid pass.

### Reference: https://www.browserstack.com/guide/dataprovider-in-selenium-testng
	 
# Exercise 5: DATA DRIVEN TEST using external file
1.	Go to https://opensource-demo.orangehrmlive.com/
2.	Get username and password to perform login
3.	Click “Admin” on the left-side menu
4.	Go to User Management
5.	Click Add button
6.	Fill all required fields to create new user (Data to input must be read from Excel file)
7.	In list user table, search created username at step 6
8.	select search result
9.	verify created user info (compare with step 6)

# Exercise 6: DATA DRIVEN TEST using external file 
Data to input must be read from Excel file.
Steps:
1. https://admin-demo.nopcommerce.com/login
2. Get username and password to perform login
3. Go to Promotions/ Campaigns
4. Click "Add new" button
5. Fill all required fields to create new campaign
6. Click Save
7. Verify the success message will be displayed
### Reference
   + https://www.browserstack.com/guide/dataprovider-in-selenium-testng
   + https://toolsqa.com/testng/testng-data-provider-excel/


