Readme     exam No.114262
Shell Input:
∗ ./compile.sh
	compiles the source and builds jar (Game.jar) into the root directory.
∗ java -jar Game.jar
	run the new compiled runnable jar
* java -jar SoftwareDevelopment.jar
	run the old default jar (mysql username:root password:123456)
_________________________________________________________________________________________________________
File Structure:
	|code
		--src : the Java code about this project
		--lib : all of the external jars required for compilation except standard java jar files
		--compile.sh : the script used to compile and show the project results
		--MANIFEST.MF : rule the output main class and rule the external jars import
		--SoftwareDevelopment.jar : the default runnable jar 
			* java -jar SoftwareDevelopment.jar
		--Game.jar : the jar compiled by the script "compile.sh"
			* java -jar Game.jar
		--SD.sql : the sql file which needs to be imported into Mysql database. About how to import, please follow the instruction in "How to import database" section
	|file
		--B114262_SD.pdf : The introduction about the prototype, the review of the program and the plan for the future development
	|front-end prototype
		--xxx.html : the prototype of front-end pages of the game
		--xxx : other documents like css and js
_________________________________________________________________________________________________________
How to import database
In order to import the .sql file into your computer, you need to follow these steps:
•	Install MySQL

•	Start MySQL with the command:
		$ sudo /Library/StartupItems/MySQLCOM/MySQLCOM start

•	Use terminate to login MySQL:
		1.First check whether the Path contains Mysql path: 
		$ echo $PATH

		2.If not, add the path of mysql:
		$ PATH="$PATH":/usr/local/mysql/bin 

		3.Then, login with the name and password (this command need to input MySQL password, in the writer’s database, the password is 123456, if the password is not the same, please change the password in the source code classes and compile the source code again):
		$ mysql -u root -p

•	In the mysql command line, import the sql file:
		mysql> source /Users/<the path of SD.sql>/SD.sql

That is how to import the sql file.
_________________________________________________________________________________________________________
Tips for Exceptions:
If Mysql's username is not "root" or the password is not "123456", please come into the src/com directory, and change the code in all 5 java classes:
    static final String USER = "root";
    static final String PASS = "123456";
into:
    static final String USER = "<username>";  //Your username
    static final String PASS = "<password>";  //Your password
Then, compile again and run the Game.jar so that the JDBC could run successfully in the program