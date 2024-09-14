# Test Scenarios for CURA Healthcare Service

## Test Case 1: Login to CURA Healthcare Service

### Steps

1. **Go to URL**:  
   Navigate to [https://katalon-demo-cura.herokuapp.com](https://katalon-demo-cura.herokuapp.com)  
   **Expected Result**: The CURA Healthcare Service page will be displayed.

2. **Click the menu toggle** (top-right of the page):  
   **Expected Result**: The sidebar menu will be displayed.

3. **Select "Login"**:  
   **Expected Result**: The user will be redirected to the login screen.

4. **Login**:
   - Enter the **username** and **password** of the demo account.
   - Click the **Login** button.  
   **Expected Result**: The user can log in successfully.

5. **Click the menu toggle** (top-right of the page):  
   **Expected Result**: The sidebar menu will be displayed.

6. **Click "Logout"**:  
   **Expected Result**: The user will be logged out.

---

## Test Case 2: Make an Appointment

### Steps

1. **Go to URL**:  
   Navigate to [https://katalon-demo-cura.herokuapp.com](https://katalon-demo-cura.herokuapp.com)  
   **Expected Result**: The CURA Healthcare Service page will be displayed.

2. **Click "Make Appointment"** button:  
   **Expected Result**: The user will be redirected to the login screen.

3. **Login**:
   - Enter the **username** and **password** of the demo account.
   - Click the **Login** button.  
   **Expected Result**: The user can log in successfully.

4. **Fill in Appointment Details**:
   - Select **"Seoul CURA Healthcare Center"** in the **Facility** dropdown.
   - Click the **"Apply for hospital readmission"** checkbox.
   - Select the **"Medicaid"** radio button for the Healthcare Program.
   - Enter the date and time in the **Visit Date** field.
   - Enter the comment **"This is test comment"** in the comments box.

5. **Click "Book Appointment"**:  
   **Expected Result**: The user will be redirected to the Appointment Confirmation screen.

6. **Verify the information**:  
   **Expected Result**: The information displayed on the screen will match the input from Step 4.
