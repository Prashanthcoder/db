#jdbc setup
to first get started in jdbc, 

step 1: 
paste the required dependencies in pom.xml file once finished with project creation

step 2: 
create a class, in that class just use Class.forName("com.mysql.cj.jdbc.Driver")  in which it loads the class for connectivity with database

step 3: 
then use the static method i.e getConnection() -> from the DriverManager class store its address in Connection type.

step 4: 
pass the url for the mysql connectivity and yeah you are done!

step 5: 
perform the sql queries using Statement directly or creating statements reference

step 6: 
use  Statement.execute("sql quereis ") or reference_varof_statement.execute("sql queries");
