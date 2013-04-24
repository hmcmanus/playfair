playfair
========

Repo for the playfair encryption program


Building the code
-----------------

The code is built with maven as a build tool. You can download it from [here](http://maven.apache.org/download.cgi)

When downloaded you can then build, test and run the code with the following:

`
mvn clean package exec:java
`

This will produce a command prompt into which you can enter a keyword and a message

Testing
---------

The testing for this code is completed through cucumber. It is driven by feature files which are just input into the
system in order to drive different code paths so that the examples can be exercised.