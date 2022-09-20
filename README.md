
# SeleniumFramework CBH

This Framework is created as a part of Assignment For Web Automation.

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

***Execution By Command line***

By one of the three ways:

1)mvn clean verify

OR

2)mvn clean verify-Dcucumber.filter.tags="@FullRegression and
not @Ignore"

OR

3)mvn test
mvn verify -DskipTests





