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
	 * @param V
	 */
	void delete(Vehicle V) {
		delete(V.getId());
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
	 * @param V
	 * @param Year
	 */
	void updateYear(Vehicle V, int Year) {
		V.setYear(Year);
	}
	
	/**
	 * 
	 * 
	 * @param V
	 * @param Make
	 */
	void updateMake(Vehicle V, String Make) {
		V.setMake(Make);
	}
	
	/**
	 * 
	 * 
	 * @param V
	 * @param Model
	 */
	void updateModel(Vehicle V, String Model) {
		V.setModel(Model);
	}
	
	/**
	 * 
	 * 
	 * @param Id
	 * @return
	 */
	Object get(int Id) {
		return this.vehicles.get(Id - this.IdOffset);
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
		
		if (Year >= 0 && Make != null && Model != null) {
			for (Vehicle V : this.vehicles) {
				if (V.getYear() == Year
						&& V.getMake().toLowerCase().equals(Make.toLowerCase())
						&& V.getModel().toLowerCase().equals(Model.toLowerCase())) {
					temp.add(V);
				}
			}
		} else if (Year >= 0 && Make != null) {
			for (Vehicle V : this.vehicles) {
				if (V.getYear() == Year
						&& V.getMake().toLowerCase().equals(Make.toLowerCase())) {
					temp.add(V);
				}
			}
		} else if (Year >= 0 && Model != null) {
			for (Vehicle V : this.vehicles) {
				if (V.getYear() == Year
						&& V.getModel().toLowerCase().equals(Model.toLowerCase())) {
					temp.add(V);
				}
			}
		} else if (Make != null && Model != null) {
			for (Vehicle V : this.vehicles) {
				if (V.getMake().toLowerCase().equals(Make.toLowerCase())
						&& V.getModel().toLowerCase().equals(Model.toLowerCase())) {
					temp.add(V);
				}
			}
		} else if (Year >= 0) {
			for (Vehicle V : this.vehicles) {
				if (V.getYear() == Year) {
					temp.add(V);
				}
			}
		} else if (Make != null) {
			for (Vehicle V : this.vehicles) {
				if (V.getMake().toLowerCase().equals(Make.toLowerCase())) {
					temp.add(V);
				}
			}
		} else if (Model != null) {
			for (Vehicle V : this.vehicles) {
				if (V.getModel().toLowerCase().equals(Model.toLowerCase())) {
					temp.add(V);
				}
			}
		}
		
		return temp.toArray();
	}
	
	
}