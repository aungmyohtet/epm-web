1. The database settings file is "src/main/resources/config.properties"
   update properties that match the host system environment
   
   If the database is new
     
     set the property "hibernate.hbm2ddl.auto" to "create"
   
   If the database has been initialized with data
     
     set the property "hibernate.hbm2ddl.auto" to "update"
	
	 
2. How to run this project.
  
  Use maven command
       
       mvn compile jetty:run
  
  And access http://localhost:8080