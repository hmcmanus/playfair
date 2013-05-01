playfair
========

Repo for the playfair encryption program


Building the code
-----------------

Option 1 - Using a build tool (maven)

The code is built with maven as a build tool. You can download it from [here](http://maven.apache.org/download.cgi)

When downloaded you can then build, test and run the code with the following:

`
mvn clean package exec:java
`

This will produce a command prompt into which you can enter a keyword and a message

Option 2 - Plain old Java

You can also compile the code with the java compiler and run with java. In the directory src/main/java build the code with the following command:

`
javac com/crypto/PlayFair.java
`

And then run it with the following command:

`
java com/crypto/PlayFiar
`

(Replace the / with \ for windblows)

This will produce a command prompt into which you can enter a keyword and a message

Testing
---------

The testing for this code is completed through cucumber. It is driven by feature files which are just input into the
system in order to drive different code paths so that the examples can be exercised.
