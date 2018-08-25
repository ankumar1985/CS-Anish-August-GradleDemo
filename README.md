# CS-Anish-August-GradleDemo

Pre-requiste for this project

1.System is having JDK 1.8 version
2.Environmental variables are set for JAVA_HOME


Steps to execute this project

1.Extract the hsqldb-2.4.1  from (https://sourceforge.net/projects/hsqldb/files/latest/download)to any location.
2. Start the HSQL server data base.
3.GO to the command prompt and to the path  hsqldb-2.4.1\hsqldb\lib
  And provide the below command to execute the data base server.
  C:\<system location>\hsqldb-2.4.1\hsqldb\lib>java -cp hsqldb.jar org.hsqldb.Server

4.Start the table interface.
C:\<system location>\hsqldb-2.4.1\hsqldb\lib>java -cp hsqldb.jar org.hsqldb.util.DatabaseManager

It will open window.
 Please change the URl to your loacl host url as -    jdbc:hsqldb:hsql://localhost:9001/  

Clicking on ok will show you all the table.

5.To execute any table ,write the command in the console.

7.Execution of project using gradle using command line

8.If Gradle is not installed and not been set as path variable in your environment variables please use the below steps.

9.Down load the source from the git hub from below location to your system
Use below command to get the latest branch from git.

git clone -c core.longpaths=true https://
Git checkout master

10.go to the source location through command promt.
C:\<system path>\GradleDemo

11.Execute the below command make sure your HSQL server data base is runing .

C:\<system path>\GradleDemo>gradlew task
C:\<system path>\GradleDemo>gradlew build
C:\<system path>\GradleDemo>gradlew run

And if build is succesfull,the project is completed and you can verify the results in database.

**********************************END OF THE PROJECT*************************************************






 






