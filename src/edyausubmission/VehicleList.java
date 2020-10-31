package edyausubmission;

import java.util.ArrayList;

/**
 * Defines a Vehicle object.
 *
 *
 */
public class VehicleList {
	public int Id;
	public ArrayList<Vehicle> vehicles;
	
	/**
	 * 
	 */
	public VehicleList() {
		this.Id = 0;
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
		this.vehicles.remove(Id);
	}
	
	/**
	 * 
	 */
	void deleteAll() {
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
		this.vehicles.get(Id).setYear(Year);
		this.vehicles.get(Id).setMake(Make);
		this.vehicles.get(Id).setModel(Model);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Year
	 */
	void update(int Id, int Year) {
		this.vehicles.get(Id).setYear(Year);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Make
	 * @param Model
	 */
	void update(int Id, String Make, String Model) {
		this.vehicles.get(Id).setMake(Make);
		this.vehicles.get(Id).setModel(Model);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Year
	 * @param Make
	 */
	void updateMake(int Id, int Year, String Make) {
		this.vehicles.get(Id).setYear(Year);
		this.vehicles.get(Id).setMake(Make);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Make
	 */
	void updateMake(int Id, String Make) {
		this.vehicles.get(Id).setMake(Make);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Year
	 * @param Model
	 */
	void updateModel(int Id, int Year, String Model) {
		this.vehicles.get(Id).setYear(Year);
		this.vehicles.get(Id).setModel(Model);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @param Model
	 */
	void updateModel(int Id, String Model) {
		this.vehicles.get(Id).setModel(Model);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @return
	 */
	Object get(int Id) {
		return this.vehicles.get(Id);
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	Object[] getAll() {
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
	Object[] getVehicles(int Year, String Make, String Model) {
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
	Object[] getVehicles(String Make, String Model) {
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
	Object[] getVehicles(int Year, String M) {
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
	 * @param Year
	 * @return
	 */
	Object[] getVehicles(int Year) {
		ArrayList<Vehicle> temp = new ArrayList<Vehicle>();
		for (Vehicle vo : this.vehicles) {
			if (vo.getYear() == Year ) {
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
	Object[] getVehicles(String M) {
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