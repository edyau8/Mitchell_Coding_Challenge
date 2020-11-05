# Mitchell Coding Challenge Submission (Java)
Author: Edward Yau  

Task: Implement a solution that performs CRUD operations (Create, Read, Update, and Delete) for a Vehicle (automobile) entity.
  
## Sample Client (finalsubmission)
The client first navigates to the project directory.  

The client wants to **get** all vehicle entries:  

	java -jar finalsubmission.jar get
	
The client wants to **get** a vehicle entry by ID (e.g. ID = 1):  

	java -jar finalsubmission.jar get 1
	
The client wants to **get** all vehicle entries with three filters:

	java -jar finalsubmission.jar get 2020 Toyota Camry  	

The client wants to **get** all vehicle entries with two filters (e.g. make and model):

	java -jar finalsubmission.jar get make model Toyota Camry
	
The client wants to **get** all vehicle entries with one filter (e.g. year):

	java -jar finalsubmission.jar get year 2020

The client wants to **create** a vehicle entry:  

	java -jar finalsubmission.jar create 2020 Toyota Camry	
	
The client wants to **update** a vehicle entry by ID (e.g. ID = 1):  

	java -jar finalsubmission.jar update 1 year 2019  
	java -jar finalsubmission.jar update 1 make Honda  
	java -jar finalsubmission.jar update 1 model Civic
	
The client wants to **delete** all vehicle entries:  

	java -jar finalsubmission.jar delete

The client wants to **delete** a vehicle entry by ID (e.g. ID = 1):  

	java -jar finalsubmission.jar delete 1