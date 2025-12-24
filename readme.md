# ToolsQA
ToolsQA is a website for testing purposes where the main goal is to test as many various functionalities as possible.



## Dependencies
* Run on Windows 11 OS
* IntelliJ IDEA 2025.2.3 (Community Edition)
* Browsers needed is Chrome



## Installation
* Open terminal in IDE and git clone the repository
  https://github.com/darkojank/Zavrsni-Projekat---ITBootcamp-septembar-2025.git
* java version: 11
* Apache Maven 4.0
## Executing program
Run all tests from terminal with:

mvn test

Run specific class from terminal with:

mvn test -Dtest="TextBoxTest"

Run specific xml file from terminal with:

mvn clean test -DsuiteXmlFile="testng.xml"

## Framework Walkthrough
Packages:

* Base - Contains classes used throughout the app
* Pages - Contains classes for each page
* Tests - Contains test classes

Files: 

* pom.xml - Contains all dependencies used in the project (last updated: 05/02/2024)
* AppData.xlsx - Excel file used to read some data for DDT as an alternative
* .gitignore - File used to store all items that are not pushed to gitHub


## Naming Conventions
* Classes are written in camel case with first character in upper case
* Methods are written in camel case with first character in lower case
* Class objects are named the same as a class name with lower case for first character

## Other
* Test methods are kept clean
* Priorities are set with an increment of 10. If higher priority occurs later in testing, the priority of such a test is placed between two priorities
