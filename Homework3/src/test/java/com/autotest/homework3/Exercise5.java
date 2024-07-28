package com.autotest.homework3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import setup.SetupBrowser;

public class Exercise5 extends SetupBrowser {



    @DataProvider(name = "testdata")
    public Object[][] testData() throws IOException {
    	String filePath = "testdata.xlsx"; // file name in src/test/resources folder
        ClassLoader classLoader = Exercise5.class.getClassLoader();
        File file = new File(classLoader.getResource( filePath).getFile());
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook  workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        System.out.println("sheet.getRow(1) "+sheet.getRow(1));
        System.out.println("sheet.getRow(2) "+sheet.getRow(2));
        int columnCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][columnCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        workbook.close();
        fileInputStream.close();
        return data;      
    }

    @Test(dataProvider = "testdata")
    public void createUser(String username, String password, String employeeName, String userRole, String status) throws InterruptedException {
    	driver.get("https://opensource-demo.orangehrmlive.com/");
        // Login
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Navigate to User Management
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#']//span[text()='Admin']")));
        driver.findElement(By.xpath("//a[@href='#']//span[text()='Admin']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/admin/viewSystemUsers']")));
        driver.findElement(By.xpath("//a[@href='/web/index.php/admin/viewSystemUsers']")).click();

        Thread.sleep(3000);
        // Click Add button
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']//i[@class='oxd-icon bi-plus']")));
        driver.findElement(By.xpath("//button[@type='button']//i[@class='oxd-icon bi-plus']")).click();

        // Fill required fields
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='User Role']/following::div")));
        WebElement userRoleDropdown = driver.findElement(By.xpath("//label[text()='User Role']/following::div"));
        userRoleDropdown.click();
        Thread.sleep(3000);
       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span[text()='" + userRole + "']")));
        driver.findElement(By.xpath("//div[@role='option']//span[text()='" + userRole + "']")).click();

        WebElement employeeNameInput = driver.findElement(By.xpath("//label[text()='Employee Name']/following::input"));
        employeeNameInput.sendKeys(employeeName);
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span[text()='" + employeeName + "']")));
        driver.findElement(By.xpath("//div[@role='option']//span[text()='" + employeeName + "']")).click();

        WebElement usernameInput = driver.findElement(By.xpath("//label[text()='Username']/following::input"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.xpath("//label[text()='Password']/following::input"));
        passwordInput.sendKeys(password);

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input"));
        confirmPasswordInput.sendKeys(password);

        WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Status']/following::div"));
        statusDropdown.click();
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span[text()='" + status + "']")));
        driver.findElement(By.xpath("//div[@role='option']//span[text()='" + status + "']")).click();
//        driver.findElement(By
}

}