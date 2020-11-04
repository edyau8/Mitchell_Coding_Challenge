package finalsubmission;

/**
 * Reads command-line arguments, executes CRUD operations, 
 * and outputs table entries.
 * 
 * @author 18ey01
 *
 */
public class Main {
	
	/**
	 * The main driver for the program. 
	 * 
	 * @param args The specifications used to execute operations.
	 */
	public static void main(String[] args) {
		// Verify command-line arguments
		if (args.length < 1) {
			System.out.println("Incorrect number of arguments.");
			return;
		}
		String operation = args[0].toLowerCase().trim();
		if (!operation.equals("get") && !operation.equals("create") && 
				!operation.equals("update") && !operation.equals("delete")) {
			System.out.println("Invalid operation.");
			return;
		}
		
		// Store remaining arguments
		String[] argsArr = new String[args.length - 1];
		for (int i = 1; i < args.length; i++) {
			argsArr[i - 1] = args[i].toLowerCase().trim();
		}
		
		Vehicle temp = new Vehicle();
		
		// Call on respective functions
		switch(operation) {
		case "get":
			temp.get(argsArr);
			break;
			
		case "create":
			temp.create(argsArr);
			break;
			
		case "update":
			temp.update(argsArr);
			break;
			
		case "delete":
			temp.delete(argsArr);
			break;
		}
	}
}