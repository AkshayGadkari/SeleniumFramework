
# SeleniumFramework CBH

This Framework is created as a part of Assignment For Web Automation. (This Framewoek needs improvements related to clean coding practices and coding standards)

(Later can be enhanced to support mobile automation using Appium )


***External dependencies:***
For this project to run, you would need to install below 3 dependencies on your machine:

Java : java version "1.8.0_311" 

Build Tool:Apache Maven 3.8.4 (For Dependency management)

Google Chrome latest version (browser to run your tests)

(Other Dependencies like Selenium,Cucumber etc are available in POM.xml)

**Framework features:**
1. BDD approach using Cucumber java
2. Page Object Model 
3. Supports running on Cloud devices like Browserstack/Lambdatest
4. Captures screenshot on Scenario Failure
5. Supports command line execution using Maven
6. Supports CI/CD integration 


***Execution By IDE***

Find TestRunner file and run

Path:

src/test/java/cucumberOptions/TestRunner.java

![image](https://user-images.githubusercontent.com/113853291/191362660-c5454161-d67e-4543-8b25-052f19d73ba1.png)

Feature File:

![image](https://user-images.githubusercontent.com/113853291/191363111-65c4b062-682a-4a73-bdd6-a18209966936.png)

***Execution By Command line***

By one of the three ways:

1)This will Generate Cucumber HTML Report after performing test

mvn clean verify 



OR

2)(This will Generate Cucumber HTML Report after test, Tag based execution)

mvn clean verify -Dcucumber.filter.tags="@FullRegression and
not @Ignore"


OR

3)(Can run Multiple tests)

mvn test
mvn test
mvn test
..
.

(This will Generate combined Cucumber HTML Report for all tests, Tag based execution)
mvn verify -DskipTests

***Report***:
![image](https://user-images.githubusercontent.com/113853291/191365852-3073d589-acd2-45a6-9d58-941fc56ba9af.png)



