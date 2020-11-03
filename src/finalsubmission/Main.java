package finalsubmission;

public class Main {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Incorrect number of arguments.");
		}
		String operation = args[0];
		String[] argsArr = new String[args.length - 1];
		for (int i = 1; i < args.length; i++) {
			argsArr[i - 1] = args[i];
		}
		
		Vehicle temp = new Vehicle();
		
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