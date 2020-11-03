package finalsubmission;

import java.sql.*;

/**
 * 
 * 
 * @author 18ey01
 *
 */
class Vehicle {
	
	/**
	 * 
	 * 
	 * @param args
	 */
	void get(String[] args) {				
		Connection conn = null;
    	
        try {
        	// Create JDBC connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
            		"jdbc:mysql://"
            		+ "database-1.cffly3ha3nha.us-east-1.rds.amazonaws.com:3306/"
            		+ "vehicles", "guest", "guest123");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        Statement stmt = null;   
        ResultSet rs = null;
        String query = "SELECT * FROM vehicle_objects;";
        
    	if (args.length == 1) {
        	int Id = Integer.parseInt(args[0]);
        	query = String.format("SELECT * FROM vehicles WHERE id='%d';", Id);
    	}

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            
            // Print table
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.println();
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                }
                System.out.println();
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
	 * 
	 * 
	 * @param args
	 */
	void create(String[] args) {
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
            conn = DriverManager.getConnection(
            		"jdbc:mysql://"
            		+ "database-1.cffly3ha3nha.us-east-1.rds.amazonaws.com:3306/"
            		+ "vehicles", "guest", "guest123");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        Statement stmt = null;        
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
	 * 
	 * 
	 * @param args
	 */
	void update(String[] args) {
		if (args.length != 3) {
    		System.out.println("Incorrect number of arguments.");
    		return;
    	}
    	
    	int Id = Integer.parseInt(args[0]);
    	String Element = args[1];
    	String Value = args[2];
    	
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
            conn = DriverManager.getConnection(
            		"jdbc:mysql://"
            		+ "database-1.cffly3ha3nha.us-east-1.rds.amazonaws.com:3306/"
            		+ "vehicles", "guest", "guest123");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        Statement stmt = null;        
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
	 * 
	 * 
	 * @param args
	 */
	void delete(String[] args) {
		if (args.length != 1) {
    		System.out.println("Incorrect number of arguments.");
    		return;
    	}
    	
    	int Id = Integer.parseInt(args[0]);
    	
    	Connection conn = null;
    	
        try {
        	// Create JDBC connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
            		"jdbc:mysql://"
            		+ "database-1.cffly3ha3nha.us-east-1.rds.amazonaws.com:3306/"
            		+ "vehicles", "guest", "guest123");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        Statement stmt = null;        
        String query = String.format(
        		"DELETE FROM vehicle_objects WHERE id='%d';", Id);

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