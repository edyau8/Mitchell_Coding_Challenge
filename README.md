# Mitchell Coding Challenge Submission (Java)
Name: Edward Yau  
Task: Implement a solution that performs CRUD operations  
(Create, Read, Update, and Delete) for a Vehicle (automobile) entity.
  
## Sample Client (finalsubmission)
The client first navigates to the project directory.  

We define the "command prefix" to be:  

	java -jar finalsubmission.jar

The client wants to **get** all vehicle entries:  

	{command prefix} get
	
The client wants to **get** a vehicle entry by ID (e.g. ID = 1):  

	{command prefix} get 1
	
The client wants to **get** all vehicle entries with three filters:

	{command prefix} get 2020 Toyota Camry  	

The client wants to **get** all vehicle entries with two filters (e.g. make and model):

	{command prefix} get make model Toyota Camry
	
The client wants to **get** all vehicle entries with one filter (e.g. year):

	{command prefix} get year 2020

The client wants to **create** a vehicle entry:  

	{command prefix} create 2020 Toyota Camry	
	
The client wants to **update** a vehicle entry by ID (e.g. ID = 1):  

	{command prefix} update 1 year 2019  
	{command prefix} update 1 make Honda  
	{command prefix} update 1 model Civic
	
The client wants to **delete** all vehicle entries:  

	{command prefix} delete

The client wants to **delete** a vehicle entry by ID (e.g. ID = 1):  

	{command prefix} delete 1