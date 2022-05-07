
public class Car {
	String id;
	int mileage;
	int mpg;
	double cost;
	double salesPrice;
	boolean sold;
	double priceSold;
	double profit;
	String soldCarID;
	
	// Default Constructor
	public Car() {
		id = "Car";
		mileage = 0;
		mpg = 0;
		cost = 0.0;
		salesPrice = 0.0;
	}
	
	//Constructor
	public Car(String id, int mileage, int mpg, double cost, double salesPrice) {
		this.id = id;
		this.mileage = mileage;
		this.mpg = mpg;
		this.cost = cost;
		this.salesPrice = salesPrice;
	}
	
	// Prints all related information for this Car object
	public String toString() {
		return "Car:  " + id + ", Mileage:  " + mileage + ", MPG:  " + mpg + ", Sold:  " + sold + ", Cost:  $"
				+ cost + ", Selling price:  $" + salesPrice + ", Sold For  $" + priceSold + ", Profit:  $" + profit;
	}
	
	// Prints all raw data for this Car object
	public String toString(int i) {
		return id + " " + mileage + " " + mpg + " " + sold + " " + cost + " " + salesPrice + " " + priceSold + " " + profit + "\n";
	}
	
	// Compares this car's MPG to another car and returns an integer
	int compareMPG(Car otherCar) {
		if (this.mpg < otherCar.mpg)
			return -1;
		else if (this.mpg > otherCar.mpg)
			return 1;
		else
			return 0;
	}
	
	// Compares this car's mileage to another car and returns an integer
	int compareMileage(Car otherCar) {
		if (this.mileage < otherCar.mileage)
			return -1;
		else if (this.mileage > otherCar.mileage)
			return 1;
		else
			return 0;
	}
	
	// Compares this car's sales price to another car and returns an integer
	int compareSalesPrice(Car otherCar) {
		if (this.salesPrice < otherCar.salesPrice)
			return -1;
		else if (this.salesPrice > otherCar.salesPrice)
			return 1;
		else
			return 0;
	}
	
	// Return car id
	String getID() {
		return id;
	}
	
	// Return car mileage
	int getMileage() {
		return mileage;
	}
	
	// Return car mpg
	int getMPG() {
		return mpg;
	}
	
	// Return car cost
	double getCost() {
		return cost;
	}
	
	// Return car sales price
	double getSalesPrice() {
		return salesPrice;
	}
	
	// Return car sold state
	boolean getSold() {
		return sold;
	}
	
	// Return car profit
	double getProfit() {
		return profit;
	}
	
	// Set car id
	void setID(String id) {
		this.id = id;
	}
	
	// Set car mileage
	void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	// Set car mpg
	void setMPG(int mpg) {
		this.mpg = mpg;
	}
	
	// Set car cost
	void setCost(double cost) {
		this.cost = cost;
	}
	
	// Set car sales price
	void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	// Set if car is sold
	void setSold(boolean sold) {
		this.sold = sold;
	}
	
	// Set car price sold
	void setPriceSold(double priceSold) {
		this.priceSold = priceSold;
	}
	
	// Set car profit
	void setProfit(double profit) {
		this.profit = profit;
	}
	
	// Sells car
	void sellCar(double priceSold) {
		setSold(true);
		setPriceSold(priceSold);
		setProfit(priceSold - cost);
	}
}
