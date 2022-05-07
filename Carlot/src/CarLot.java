import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarLot extends ArrayList<Car> {
	// File location where the inventory of a CarLot is stored
	public static final String CARLOT_INVENTORY_LOCATION = "src\\carlot.txt";
	
	// Default Constructor, loads from disk on startup
	CarLot(){
		super.clear();
		loadFromDisk();
	}
	
	// Load the cars stored in CARLOT_INVENTORY_LOCATION
	void loadFromDisk() {
		try {
			File carFile = new File(CARLOT_INVENTORY_LOCATION);
			Scanner input = new Scanner(carFile);
			this.clear();
			while (input.hasNext()) {
				String id = input.next();
				int mileage = Integer.parseInt(input.next());
				int mpg = Integer.parseInt(input.next());
				boolean isSold = Boolean.parseBoolean(input.next());
				double cost = Double.parseDouble(input.next());
				double salesPrice = Double.parseDouble(input.next());
				double priceSold = Double.parseDouble(input.next());
				double profit = Double.parseDouble(input.next());
				profit = priceSold - cost;
				
				addCar(id, mileage, mpg, cost, salesPrice);
				if (isSold)
					this.sellCar(id, priceSold);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERR: The file was not found!");
			e.printStackTrace();
		}
	}
	
	// Save the cars in this CarLot to the file specified in CARLOT_INVENTORY_LOCATION
	void saveToDisk() {
		try {
			File carFile = new File(CARLOT_INVENTORY_LOCATION);
			if (carFile.createNewFile())
				System.out.println("File created: " + carFile.getName());
			else
				System.out.println("File already exists.");
			
			FileWriter carWriter = new FileWriter(CARLOT_INVENTORY_LOCATION);
			for (int i = 0; i < this.size(); i++) {
				System.out.println("Writing data..." + this.get(i).toString(i));
				carWriter.write(this.get(i).toString(i));	
			}
			
			carWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	// Return this inventory
	CarLot getInventory() {
		return this;
	}
	
	// Return the average MPG of all cars in inventory
	double getAverageMpg() {
		double temp = 0;
		
		for (int i = 0; i < super.size(); i++)
			temp += super.get(i).getMPG();
		
		return temp / super.size();
	}
	
	// Return the single car in the inventory that has the highest MPG
	Car getCarWithBestMPG() {
		CarLot inventoryMPG = getCardsSortedByMPG();
		
		return inventoryMPG.get(inventoryMPG.size() - 1);
	}
	
	// Return the single car in the inventory that has the highest mileage
	Car getCarWithHighestMileage() {
		CarLot inventoryMileage = this;
		int n = inventoryMileage.size();
		
		for (int i = 0; i < n - 1; i++) {
			int min_idx = 1;
			for (int j = i + 1; j < n; j++)
				if (inventoryMileage.get(j).compareMileage(inventoryMileage.get(min_idx)) == -1 ||
					inventoryMileage.get(j).compareMileage(inventoryMileage.get(min_idx)) == 0)
					min_idx = j;
			Car temp = inventoryMileage.get(min_idx);
			inventoryMileage.set(min_idx, inventoryMileage.get(i));
			inventoryMileage.set(i, temp);
		}
		
		return inventoryMileage.get(inventoryMileage.size() - 1);
	}
	
	// Return the total profit of all sold cars in inventory
	double getTotalProfit() {
		double temp = 0;
		
		for (int i = 0; i < this.size(); i++)
			temp += this.get(i).getProfit();
		
		return temp;
	}
	
	// Return a new list containing all of the cars in inventory, sorted by MPG descending
	CarLot getCardsSortedByMPG() {
		CarLot inventoryMPG = this;
		int n = inventoryMPG.size();
		
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				if (inventoryMPG.get(j).compareMPG(inventoryMPG.get(min_idx)) == -1 ||
				inventoryMPG.get(j).compareMPG(inventoryMPG.get(min_idx)) == 0)
					min_idx = j;
			
			Car temp = inventoryMPG.get(min_idx);
			inventoryMPG.set(min_idx,  inventoryMPG.get(i));
			inventoryMPG.set(i, temp);
		}
		
		return inventoryMPG;
	}
	
	// Return a list containing all of the cars in inventory, sorted by order of entry
	CarLot getCarsInOrderOfEntry() {
		return this;
	}
	
	// Sell the car identified by the identifier for the priceSold
	void sellCar(String identifier, double priceSold) {
		Car temp = findCarByIdentifier(identifier);
		
		if (temp != null)
			temp.sellCar(priceSold);
		else
			System.out.println("ERR: Car not found!");
	}
	
	// Add a new car to this CarLot
	void addCar (String id, int mileage, int mpg, double cost, double salesPrice) {
		Car newCar = new Car(id, mileage, mpg, cost, salesPrice);
		super.add(newCar);
	}
	
	// Return the car in inventory that matches the identifier or null if not found
	Car findCarByIdentifier(String identifier) {
		for (Car car : this)
			if (car.getID().equals(identifier))
				return car;
		
		return null;
	}
}
