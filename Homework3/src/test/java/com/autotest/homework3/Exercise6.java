package com.autotest.homework3;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.ExcelUtils;
import setup.SetupBrowser;

public class Exercise6 extends SetupBrowser {


    @DataProvider(name = "campaignData")
    public Object[][] getCampaignData() {
        String filePath = "NewCampaigns.xlsx"; // file name in src/test/resources folder
        ClassLoader classLoader = Exercise5.class.getClassLoader();
        return ExcelUtils.getExcelData(classLoader.getResource( filePath).getFile() ,"CampaignData");
    }

    @Test(dataProvider = "campaignData")
    public void createCampaignTest(String username, String password, String campaignName, String description) {
        // Step 1: Login
        driver.get("https://admin-demo.nopcommerce.com/login");
        WebElement emailField = driver.findElement(By.id("Email"));
        WebElement passwordField = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.cssSelector(".button-1.login-button"));

        emailField.clear();
        emailField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();

        // Step 2: Go to Promotions/Campaigns
        driver.findElement(By.xpath("//p[normalize-space()='Promotions']")).click();
        //driver.get("https://admin-demo.nopcommerce.com/Admin/Campaign/List");
        driver.findElement(By.xpath("//a[@href='/Admin/Campaign/List']")).click();

        // Step 3: Click "Add new" button
        driver.findElement(By.xpath("//a[@href='/Admin/Campaign/Create']")).click();

        // Step 4: Fill all required fields
        driver.findElement(By.xpath("//input[@id='Name']")).sendKeys(campaignName);
        driver.findElement(By.xpath("//input[@id='Subject']")).sendKeys(campaignName);
        driver.findElement(By.xpath("//textarea[@id='Body']")).sendKeys(description);
        // Step 5: Click Save
        driver.findElement(By.name("save")).click();

        // Step 6: Verify success message
        String successMessage = driver.findElement(By.className("alert-success")).getText();
        assertTrue(successMessage.contains("The new campaign has been added successfully."));
    }


}
