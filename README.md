# Mitchell Coding Challenge Submission
Name: Edward Yau  
  
Methods:  


1.
**GET** vehicles/{id}  

*get()*  
- Returns an array all Vehicle objects.  

*get(int Id)*  
- Returns the Vehicle object with the given Id.  

*get(int Year, String Make, String Model)*  
- Returns an array of all Vehicle objects with the given attributes. If the 
user does not want to look for a certain Year, they can pass in -1. If the user
does not want to look for a certain Make or Model, they can pass in null.

2.
**CREATE** vehicles  

*create(int Year, String Make, String Model)*  
- Creates a Vehicle object and inserts it into a list. All attributes must be
provided.   
  
3.
**UPDATE** vehicles  

*update(Vehicle V, int Year, String Make, String Model)*  
- Updates a Vehicle object with the given attributes. If the user does not want
to update the Year, they can pass in -1. If the user does not want to update
the Make or Model, they can pass in null.  

4.
**DELETE** vehicles/{id}  

*delete()*  
- Removes all Vehicle objects.  

*delete(int Id)*  
- Removes the Vehicle object with the given Id.  