# PizzaProcessor

Problem Domain : 
Pizza shop receives order and saves them in a text file however they are not in correct order.
Tasks is to arrange the list in correct order 
Write results to destination file in human readable format.

Input Data : 

Order		time
bread		1477232687
bread		1474640687
meatMeaT	1474295087
VegVeg		1474295087
Meat		1506176687
pizza		1477578287
p1zza		1477491887
Bread		1477405487
Pizza		1477319087

OutPut Data  (Assumed Shorted in Lexical Order of Pizza Name)

Your Orders Are Placed in Shorted/Readable Format 
Bread Pizza Is Ordered @  : 1970-01-18T07:53:25.487
Meat Pizza Is Ordered @  : 1970-01-18T15:52:56.687
Pizza Pizza Is Ordered @  : 1970-01-18T07:51:59.087
VegVeg Pizza Is Ordered @  : 1970-01-18T07:01:35.087
bread Pizza Is Ordered @  : 1970-01-18T07:07:20.687
meatMeaT Pizza Is Ordered @  : 1970-01-18T07:01:35.087
p1zza Pizza Is Ordered @  : 1970-01-18T07:54:51.887
pizza Pizza Is Ordered @  : 1970-01-18T07:56:18.287



Solution Approach
Solution POC contains below Features
Technical
1.	Standalone mavenized Spring Boot application that can be deployed in isolation
2.	Ability to run test cases from command line
3.	FrontController design patter.
4.	Java 8 lamda, stream and internal loop features incorporation
5.	Dynamic dependency injection 
6.	NIO features for file writing and reading
7.	Support for Future requirements, i.e. DB interaction with embedded DB (Derby) with help of Spring JPA
8.	Custom exception Propagation
9.	Support for Upload File size with properties configuration
10.	Custom port binding with externalized properties
Functional
11.	Provided the user interface (HTML view) that is used for uploading raw input file
12.	Once user uploads the file, then he can download file in shorted and also in human redeable format.
13.	System is capable of holding multiple files.
14.	System is capable of showing and downloading multiple processed files.



Executing Executable Jar

Prerequisite : 
1.	JAVA 8
2.	Maven
3.	Git Client For Pulling the STS (Optional)
4.	IDE STS (Optional) 


Running Instruction: Copy jar (pizzaProcessor-0.1.0.jar) in folder and execute below command. 
C:\>java -jar pizzaProcessor-0.1.0.jar
Above command will start the spring boot of 8081 port (As mentioned in Application.properties)
Running on some other port you can run below command
C:\>java -jar  -Dserver.port=8888 pizzaProcessor-0.1.0.jar 
