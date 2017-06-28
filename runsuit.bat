set projectLocation=/Users/stanislav.peshkur/Documents/TestNG
cd %projectLocation%
set classpath=%projectLocation%\bin;/Users/stanislav.peshkur/.m2/repository/org/testng/testng/6.11*
java org.testng.TestNG /Users/stanislav.peshkur/Documents/TestNG/src/test/java/stgwp/stg/m27613/com/TestDemoSiteSuit.xml
pause

java -cp ".: C:\Program Files\jbdevstudio4\studio\plugins\*" org.testng.TestNG testng.xml


java -cp "/Users/stanislav.peshkur/Documents/TestNG/src/test/java/TestDemoSite" org.testng.TestNG Template.xml