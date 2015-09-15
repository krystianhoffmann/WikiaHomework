# WikiaHomework
Repository for Wikia QA Homework

To run tests from the command line, please follow instructions:

1.Configuration - make sure that you have installed:
- Java 1.8
- Maven
- Firefox
For Chrome you also need:
- installed Chrome
- have correct version of Chromedriver for your OS somwhere in the filesystem


2.To run tests:
- clone repository
- through command line, navigate to WikiaHomework directory
  For Firefox
- run "mvn clean test -Dtestsuite=HomeworkSuite.xml -Ddrivertype=firefox"
  For Chrome
- run "mvn clean test -Dtestsuite=HomeworkSuite.xml -Ddrivertype=chrome -Dchromedriverpath=PATH/TO/CHROMEDRIVER
