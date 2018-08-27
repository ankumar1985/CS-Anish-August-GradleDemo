# CS-Anish-August-GradleDemo
Pre-requisite for this project

1. The system is having JDK 1.8 version 
2.Environmental variables are set for JAVA_HOME

Steps to execute this project

1. Extract the hsqldb-2.4.1 from (https://sourceforge.net/projects/hsqldb/files/latest/download)to any location. 
2. Start the HSQL server database.

3.GO to the command prompt and to the path hsqldb-2.4.1\hsqldb\lib And provide the below command to execute the database server. C:<system location>\hsqldb-2.4.1\hsqldb\lib>java -cp hsqldb.jar org.hsqldb.Server

4. Start the HSQL Database manager interface. Open a new command prompt and go to the below path. C:<system location>\hsqldb-2.4.1\hsqldb\lib>java -cp hsqldb.jar org.hsqldb.util.DatabaseManager

It will open window. Please change the URL to your localhost URL as - jdbc:hsqldb:hsql://localhost:9001/

Clicking on ok will show you all the table.

5. To execute any table, write the command in the console.

6.Execution of project using Gradle using the command line

7. If Gradle is not installed and not been set a path variable in your environment variables please use the below steps.

9. Download the source from the git hub from below location to your system Use below command to get the latest branch from git.

  git clone -c core.longpaths=true https://github.com/ankumar1985/CS-Anish-August-GradleDemo.git

  cd CS-Anish-August-GradleDemo

  git status

  Git checkout master

10.go to the source location through command prompt. C:<system path>\GradleDemo

11. Execute the below command make sure your HSQL server database is running.

  C:<system path>\GradleDemo>gradlew task

  C:<system path>\GradleDemo>gradlew build

  C:<system path>\GradleDemo>gradlew run

And if the build is successful, the project is completed and you can verify the results in the database.

12. Go to the HSQL Database manager console. Refresh the data and by select query verify the result.

*************END OF THE PROJECT***********






