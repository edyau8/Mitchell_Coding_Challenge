package edyausubmission;

import java.util.ArrayList;

/**
 * Defines a Vehicle object.
 *
 *
 */
public class VehicleList {
	public int Id;
	private int IdOffset;
	public ArrayList<Vehicle> vehicles;
	
	/**
	 * 
	 */
	public VehicleList() {
		this.Id = 10000;
		this.IdOffset = 10000;
		this.vehicles = new ArrayList<Vehicle>();
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	class Vehicle {
		// Member variables of a Vehicle object
		private int Id;
		private int Year;
		private String Make;
		private String Model;
		
		/**
		 * 
		 * @param Id
		 * @param Year
		 * @param Make
		 * @param Model
		 */
		private Vehicle(int Id, int Year, String Make, String Model) {
			this.Id = Id;
			if (Year < 1950 || Year > 2050) {
				throw new ArithmeticException("Vehicle year must be between 1950 and 2050");
			}
			this.Year = Year;
			this.Make = Make;
			this.Model = Model;
		}

		/**
		 * 
		 * @return
		 */
		int getId() { return this.Id; }
		
		/**
		 * 
		 * @param Id
		 */
		void setId(int Id) { this.Id = Id; }
		
		/**
		 * 
		 * @return
		 */
		int getYear() { return this.Year; }
		
		/**
		 * 
		 * @param Year
		 */
		void setYear(int Year) {
			if (Year < 1950 || Year > 2050) {
				throw new ArithmeticException("Vehicle year must be between 1950 and 2050");
			}
			this.Year = Year;
		}
		
		/**
		 * 
		 * @return
		 */
		String getMake() { return this.Make; }
		
		/**
		 * 
		 * @param Make
		 */
		void setMake(String Make) { this.Make = Make; }
		
		/**
		 * 
		 * @return
		 */
		String getModel() { return this.Model; }
		
		/**
		 * 
		 * @param Model
		 */
		void setModel(String Model) { this.Model = Model; }

	}

	/**
	 * 
	 * 
	 * @param Year
	 * @param Make
	 * @param Model
	 */
	void create(int Year, String Make, String Model) {
		Vehicle temp = new Vehicle(this.Id, Year, Make, Model);
		this.vehicles.add(temp);
		this.Id++;
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 */
	void delete(int Id) {
		this.vehicles.remove(Id - IdOffset);
	}
	
	/**
	 * 
	 */
	void delete() {
		for (int i = 0; i < this.vehicles.size(); i++) {
			this.vehicles.remove(i);
		}
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Year
	 * @param Make
	 * @param Model
	 */
	void update(int Id, int Year, String Make, String Model) {
		this.vehicles.get(Id - IdOffset).setYear(Year);
		this.vehicles.get(Id - IdOffset).setMake(Make);
		this.vehicles.get(Id - IdOffset).setModel(Model);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Year
	 */
	void update(int Id, int Year) {
		this.vehicles.get(Id - IdOffset).setYear(Year);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Make
	 * @param Model
	 */
	void update(int Id, String Make, String Model) {
		this.vehicles.get(Id - IdOffset).setMake(Make);
		this.vehicles.get(Id - IdOffset).setModel(Model);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Year
	 * @param Make
	 */
	void updateMake(int Id, int Year, String Make) {
		this.vehicles.get(Id - IdOffset).setYear(Year);
		this.vehicles.get(Id - IdOffset).setMake(Make);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Make
	 */
	void updateMake(int Id, String Make) {
		this.vehicles.get(Id - IdOffset).setMake(Make);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Year
	 * @param Model
	 */
	void updateModel(int Id, int Year, String Model) {
		this.vehicles.get(Id - IdOffset).setYear(Year);
		this.vehicles.get(Id - IdOffset).setModel(Model);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Model
	 */
	void updateModel(int Id, String Model) {
		this.vehicles.get(Id - IdOffset).setModel(Model);
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	Object[] get() {
		return this.vehicles.toArray();
	}
	
	/**
	 * 
	 * 
	 * @param Year
	 * @param Make
	 * @param Model
	 * @return
	 */
	Object[] get(int Year, String Make, String Model) {
		ArrayList<Vehicle> temp = new ArrayList<Vehicle>();
		for (Vehicle vo : this.vehicles) {
			if (vo.getYear() == Year 
					&& vo.getMake().toLowerCase().equals(Make.toLowerCase()) 
					&& vo.getModel().toLowerCase().equals(Model.toLowerCase())) {
				temp.add(vo);
			}
		}
		return temp.toArray();
	}
	
	/**
	 * 
	 * 
	 * @param Make
	 * @param Model
	 * @return
	 */
	Object[] get(String Make, String Model) {
		ArrayList<Vehicle> temp = new ArrayList<Vehicle>();
		for (Vehicle vo : this.vehicles) {
			if (vo.getMake().toLowerCase().equals(Make.toLowerCase()) 
					&& vo.getModel().toLowerCase().equals(Model.toLowerCase())) {
				temp.add(vo);
			}
		}
		return temp.toArray();
	}
	
	/**
	 * 
	 * 
	 * @param Year
	 * @param M
	 * @return
	 */
	Object[] get(int Year, String M) {
		ArrayList<Vehicle> temp = new ArrayList<Vehicle>();
		for (Vehicle vo : this.vehicles) {
			if (vo.getYear() == Year 
					&& (vo.getMake().toLowerCase().equals(M.toLowerCase()) 
							|| vo.getModel().toLowerCase().equals(M.toLowerCase()))) {
				temp.add(vo);
			}
		}
		return temp.toArray();
	}
	
	/**
	 * 
	 * 
	 * @param num
	 * @return
	 */
	Object[] get(int num) {
		ArrayList<Vehicle> temp = new ArrayList<Vehicle>();
		if (num >= 10000) {
			temp.add(this.vehicles.get(num - IdOffset));
			return temp.toArray();
		}
		for (Vehicle vo : this.vehicles) {
			if (vo.getYear() == num ) {
				temp.add(vo);
			}
		}
		return temp.toArray();
	}
	
	/**
	 * 
	 * 
	 * @param M
	 * @return
	 */
	Object[] get(String M) {
		ArrayList<Vehicle> temp = new ArrayList<Vehicle>();
		for (Vehicle vo : this.vehicles) {
			if (vo.getMake().toLowerCase().equals(M.toLowerCase()) 
					|| vo.getModel().toLowerCase().equals(M.toLowerCase())) {
				temp.add(vo);
			}
		}
		return temp.toArray();
	}
	
	
}