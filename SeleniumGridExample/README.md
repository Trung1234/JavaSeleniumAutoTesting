### What is Selenium Grid
+ Selenium Grid is a part of the Selenium Suite that specializes in running multiple tests across different browsers, operating systems, and machines in parallel.

+  Selenium Grid uses a hub-node concept where you only run the test on a single machine called a hub, but the execution will be done by different machines called nodes.
![image](https://github.com/user-attachments/assets/25c1cce2-f4b5-4e14-9c64-f14e186c4d20)

 #### For Selenium Grid 4: 
  -  Launching Hub
  java -jar selenium-server-<version>.jar hub 
  -  Register a node to Hub
  java -jar selenium-server-<version>.jar node
![image](https://github.com/user-attachments/assets/31ccb4fd-847e-4760-90e8-acccd080c91a)

## References:
https://www.selenium.dev/documentation/grid/getting_started/ 
Download server: https://www.selenium.dev/downloads/ 
