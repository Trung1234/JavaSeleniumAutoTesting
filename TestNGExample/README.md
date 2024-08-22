
###  **TestNG** is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use, such as:
+ Annotations.
+ Run your tests in arbitrarily big thread pools with various policies available (all
+ methods in their own thread, one thread per test class, etc...).
+ Test that your code is multithread safe.
+ Flexible test configuration.
+ Support for data-driven testing (with @DataProvider).
+ Support for parameters.
+ Powerful execution model (no more TestSuite).
+ Supported by a variety of tools and plug-ins (Eclipse, IDEA, Maven, etc...).


TestNG is designed to cover all categories of tests: unit, functional, end-to-end, integration, etc...
![image](https://github.com/user-attachments/assets/2fd48f7c-6886-4a91-85f6-ad79a292cd40)

###  TestNG Annotation is a piece of code which is inserted inside a program or business logic used to control the flow of execution of test methods.
+  **@BeforeSuite**: The annotated method will be run before all tests in this suite have run.
+  **@AfterSuite**: The annotated method will be run after all tests in this suite have run.
+  **@BeforeTest**: The annotated method will be run before any test method belonging to the classes inside the
<test> tag is run.
+  **@AfterTest**: The annotated method will be run after all the test methods belonging to the classes inside the
<test> tag have run.
+  **@BeforeGroups**: The list of groups that this configuration method will run before. This method is guaranteed t
run shortly before the first test method that belongs to any of these groups is invoked.
+  **@AfterGroups**: The list of groups that this configuration method will run after. This method is guaranteed to ru shortly after the last test method that belongs to any of these groups is invoked.
+  **@BeforeClass**: The annotated method will be run before the first test method in the current class is invoked.
+  **@AfterClass**: The annotated method will be run after all the test methods in the current class have been run.
+  **@BeforeMethod**: The annotated method will be run before each test method.
+  **@AfterMethod**: The annotated method will be run after each test method.




