/*
 * Class: CMSC203 22502 
 * Instructor: Dr. Kuijt
 * Description: Property class of Project 4
 * Due: 11/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Alex Kim
*/

public class Property {
	private String propertyName,
				   city,
				   owner;
	private double rentAmount;
	private Plot plot;
	
	public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
        this.plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount; 
		this.owner = owner;
		this.plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
	}
	
	public Property(Property otherProperty) {
		//Check for null error condition
		if (otherProperty != null) {
            this.propertyName = otherProperty.propertyName;
            this.city = otherProperty.city;
            this.rentAmount = otherProperty.rentAmount;
            this.owner = otherProperty.owner;
            this.plot = new Plot(otherProperty.plot);
        }
	}
	
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }
    
    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public Plot getPlot() {
        return plot;
    }

    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
