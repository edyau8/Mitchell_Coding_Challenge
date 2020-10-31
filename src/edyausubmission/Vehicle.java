package edyausubmission;

import java.util.ArrayList;

/**
 * Defines a Vehicle object.
 *
 *
 */
public class Vehicle {
	public int Id;
	public ArrayList<VehicleObj> vehicles;
	
	/**
	 * 
	 */
	public Vehicle() {
		this.Id = 0;
		this.vehicles = new ArrayList<VehicleObj>();
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	class VehicleObj {
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
		private VehicleObj(int Id, int Year, String Make, String Model) {
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
		VehicleObj temp = new VehicleObj(this.Id, Year, Make, Model);
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
	 * 
	 * @param Id
	 * @return
	 */
	VehicleObj getVehicle(int Id) {
		return this.vehicles.get(Id);
	}
	
	/**
	 * 
	 * @param Year
	 * @param Make
	 * @param Model
	 * @return
	 */
	VehicleObj[] getVehicles(int Year, String Make, String Model) {
		ArrayList<VehicleObj> temp = new ArrayList<VehicleObj>();
		for (VehicleObj vo : this.vehicles) {
			if (vo.getYear() == Year 
					&& vo.getMake().equals(Make) 
					&& vo.getModel().equals(Model)) {
				temp.add(vo);
			}
		}
		return (VehicleObj[]) temp.toArray();
	}
	
	/**
	 * 
	 * @param Year
	 * @param Make
	 * @return
	 */
	VehicleObj[] getVehicles(int Year, String Make) {
		ArrayList<VehicleObj> temp = new ArrayList<VehicleObj>();
		for (VehicleObj vo : this.vehicles) {
			if (vo.getYear() == Year 
					&& vo.getMake().equals(Make)) {
				temp.add(vo);
			}
		}
		return (VehicleObj[]) temp.toArray();
	}
	
	/**
	 * 
	 * @param Year
	 * @return
	 */
	VehicleObj[] getVehicles(int Year) {
		ArrayList<VehicleObj> temp = new ArrayList<VehicleObj>();
		for (VehicleObj vo : this.vehicles) {
			if (vo.getYear() == Year ) {
				temp.add(vo);
			}
		}
		return (VehicleObj[]) temp.toArray();
	}
	
	/**
	 * 
	 * @param Make
	 * @param Model
	 * @return
	 */
	VehicleObj[] getVehicles(String Make, String Model) {
		ArrayList<VehicleObj> temp = new ArrayList<VehicleObj>();
		for (VehicleObj vo : this.vehicles) {
			if (vo.getMake().equals(Make) 
					&& vo.getModel().equals(Model)) {
				temp.add(vo);
			}
		}
		return (VehicleObj[]) temp.toArray();
	}
	
}