package finalsubmission;

import java.sql.*;

/**
 * Defines the CRUD methods for the Vehicles database.
 * 
 * @author Edward Yau
 *
 */
public class Vehicle {
	
	/**
	 * Gets entries from the vehicle_objects table based on certain specifications.
	 * 
	 * @param args The specifications used to obtain certain entries.
	 */
	public void get(String[] args) {
		// Verify arguments
		if (args.length > 4) {
			System.out.println("Incorrect number of arguments.");
			return;
		}
		
		Connection conn = null;
    	
        try {
        	// Create JDBC connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection to database
            conn = DriverManager.getConnection(
            		"jdbc:mysql://"
            		+ "database-1.cffly3ha3nha.us-east-1.rds.amazonaws.com:3306/"
            		+ "vehicles", "guest", "guest123");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        Statement stmt = null;   
        ResultSet rs = null;
        
        // Query used to interact with table
        String query = "SELECT * FROM vehicle_objects;";
        
        // Get entry by ID
    	if (args.length == 1) {
        	int Id = Integer.parseInt(args[0]);
        	query = String.format("SELECT * FROM vehicle_objects WHERE id='%d';", Id);
        	
        // Get entries by ID, Make, OR Model
    	} else if (args.length == 2) {
    		String Element = args[0];
    		
    		if (Element.equals("year")) {
    			int Value = Integer.parseInt(args[1]);
        		query = String.format("SELECT * FROM vehicle_objects WHERE %s='%d';", 
        				Element, Value);
    		} else {
        		String Value = args[1];
        		query = String.format("SELECT * FROM vehicle_objects WHERE %s='%s';", 
        				Element, Value);
    		}
    		
    	// Get entries by ID, Make, AND Model
    	} else if (args.length == 3) {
    		int Year = Integer.parseInt(args[0]);
    	   	String Make = args[1];
        	String Model = args[2];
        	
        	query = String.format(
        			"SELECT * FROM vehicle_objects WHERE" +
        			"(year='%d' AND make='%s' AND model='%s');", 
        			Year, Make, Model);
        	
        // Get entries by two values
    	} else if (args.length == 4) {
    		String Element1 = args[0];
    		String Element2 = args[1];
    		
    		if (Element1.equals(Element2)) {
    			System.out.println("Invalid arguments for get.");
    			return;
    		}
    		
    		if (Element1.equals("year")) {
    			int Value1 = Integer.parseInt(args[2]);
    			String Value2 = args[3];
    			
            	query = String.format(
            			"SELECT * FROM vehicle_objects WHERE" +
            			"(%s='%d' AND %s='%s');", 
            			Element1, Value1, Element2, Value2);
            	
    		} else if (Element2.equals("year")) {
    			String Value1 = args[2];
    			int Value2 = Integer.parseInt(args[3]);
    			
            	query = String.format(
            			"SELECT * FROM vehicle_objects WHERE" +
            			"(%s='%s' AND %s='%d');", 
            			Element1, Value1, Element2, Value2);
            	
    		} else {
    			String Value1 = args[2];
    			String Value2 = args[3];
    			
            	query = String.format(
            			"SELECT * FROM vehicle_objects WHERE" +
            			"(%s='%s' AND %s='%s');", 
            			Element1, Value1, Element2, Value2);
    		}
    	}

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            
            // Print table
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(", ");
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                }
                System.out.println();
            }
            return;
        }
        
        catch (Exception ex){
            System.out.println(ex);
        }
        
        // Release resources
        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }
        	
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
	}
	
	/**
	 * Creates entries in the vehicle_objects table given a year, make, and model.
	 * 
	 * @param args The values used for the entry.
	 */
	public void create(String[] args) {
		// Verify arguments
		if (args.length != 3) {
    		System.out.println("Incorrect number of arguments.");
    		return;
    	}
    	
    	int Year = Integer.parseInt(args[0]);
    	String Make = args[1];
    	String Model = args[2];
    	
    	if (Year < 1950 || Year > 2050) {
    		System.out.println("Year must be between 1950 and 2050.");
    		return;
    	}
    	
    	Connection conn = null;
    	
        try {
        	// Create JDBC connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection to database
            conn = DriverManager.getConnection(
            		"jdbc:mysql://"
            		+ "database-1.cffly3ha3nha.us-east-1.rds.amazonaws.com:3306/"
            		+ "vehicles", "guest", "guest123");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        Statement stmt = null;
        
        // Query used to interact with table
        String query = String.format(
        		"INSERT INTO vehicle_objects (year, make, model) VALUE "
        		+ "( '%d', '%s', '%s' );", Year, Make, Model);

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            return;
        }
        
        catch (Exception ex){
            System.out.println(ex);
        }
        
        // Release resources
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
	}
	
	/**
	 * Updates an entry in the vehicle_objects table based on certain specifications.
	 * 
	 * @param args The specifications used to update the entry.
	 */
	public void update(String[] args) {
		// Verify arguments
		if (args.length != 3) {
    		System.out.println("Incorrect number of arguments.");
    		return;
    	}
    	
    	int Id = Integer.parseInt(args[0]);
    	String Element = args[1];
    	String Value = args[2];
    	
    	// Verify value for year
    	if (Element == "year") {
    		int Year = Integer.parseInt(args[2]);
    	   	if (Year < 1950 || Year > 2050) {
        		System.out.println("Year must be between 1950 and 2050.");
        		return;
        	}
    	}
    	
    	Connection conn = null;
    	
        try {
        	// Create JDBC connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection to database
            conn = DriverManager.getConnection(
            		"jdbc:mysql://"
            		+ "database-1.cffly3ha3nha.us-east-1.rds.amazonaws.com:3306/"
            		+ "vehicles", "guest", "guest123");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        Statement stmt = null;
        
        // Query used to interact with table
        String query = String.format(
        		"UPDATE vehicle_objects SET %s='%s' WHERE id=%d", Element, Value, Id);

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            return;
        }
        
        catch (Exception ex){
            System.out.println(ex);
        }
        
        // Release resources
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
	}
	
	/**
	 * Deletes entries in the vehicle_objects table.
	 * 
	 * @param args Empty if the user wants to delete the entire table, 
	 * an ID number otherwise.
	 */
	public void delete(String[] args) {
		// Verify arguments
		if (args.length > 1) {
    		System.out.println("Incorrect number of arguments.");
    		return;
    	}
    	
    	Connection conn = null;
    	
        try {
        	// Create JDBC connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection to database
            conn = DriverManager.getConnection(
            		"jdbc:mysql://"
            		+ "database-1.cffly3ha3nha.us-east-1.rds.amazonaws.com:3306/"
            		+ "vehicles", "guest", "guest123");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        Statement stmt = null;
        
        // Query used to interact with table
        String query = "TRUNCATE TABLE vehicle_objects;";

        // Delete entry by ID
        if (args.length == 1) {
        	int Id = Integer.parseInt(args[0]);
        	query = String.format(
        			"DELETE FROM vehicle_objects WHERE id='%d';", Id);
        }
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            return;
        }
        
        catch (Exception ex){
            System.out.println(ex);
        }
        
        // Release resources
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
	}
 }