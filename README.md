# Mitchell Coding Challenge Submission (Java)
Name: Edward Yau  
  
## Sample Client (finalsubmission)
The client first navigates to the project directory.  
We define the "command prefix" to be:  
	java -cp ./lib/mysql-connector-java-8.0.22.jar:./bin/ finalsubmission.Main

The client wants to get all vehicle entries:  
	"command prefix" get
	
The client wants to get a vehicle entry by ID:  
	"command prefix" get 1
	
The client wants to create a vehicle entry:  
	"command prefix" create 2020 Toyota Camry	
	
The client wants to update a vehicle entry by ID:  
	"command prefix" update 1 year 2019  
	"command prefix" update 1 make Honda  
	"command prefix" update 1 model Civic
	
The client wants to delete all vehicle entries:  
	"command prefix" delete

The client wants to delete a vehicle entry by ID:  
	"command prefix" delete 1