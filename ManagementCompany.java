/*
 * Class: CMSC203 22502 
 * Instructor: Dr. Kuijt
 * Description: ManagementCompany class of Project 4
 * Due: 11/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Alex Kim
*/

public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    
	private String name,
				   taxID;
	private double managementFeePercent;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	
	public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.managementFeePercent = 0.0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxID, double managementFeePercent) {
        this.name = name;
        this.taxID = taxID;
        this.managementFeePercent = managementFeePercent;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxID, double managementFeePercent, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.managementFeePercent = managementFeePercent;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
        if (otherCompany != null) {
            this.name = otherCompany.name;
            this.taxID = otherCompany.taxID;
            this.managementFeePercent = otherCompany.managementFeePercent;
            this.plot = new Plot(otherCompany.plot);
            this.properties = new Property[MAX_PROPERTY];
            this.numberOfProperties = otherCompany.numberOfProperties;
            for (int i = 0; i < numberOfProperties; i++) {
                this.properties[i] = new Property(otherCompany.properties[i]);  
            }
        }
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setTaxID(String taxID) {
	     this.taxID = taxID;
	}
	 
	public void setManagementFeePercent(double managementFeePercent) {
	     this.managementFeePercent = managementFeePercent;
	}

	public String getName() {
	     return name;
	}

	public String getTaxID() {
	     return taxID;
	}

	public double getManagementFeePercent() {
	     return managementFeePercent;
	}

	public Plot getPlot() {
	     return plot;
	}
  
	//overloaded methods
	public int addProperty(String propertyName, String city, double rentAmount, String owner) {
        Property property = new Property(propertyName, city, rentAmount, owner);
        return addProperty(property);
    }
	
    public int addProperty(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        Property property = new Property(propertyName, city, rentAmount, owner, x, y, width, depth);
        return addProperty(property);
    }
    
    /*
    ⦁	If there is a problem adding the property, this method will return 
	    ⦁	If the array is full, it will return -1.
	    ⦁	If the property is null, it will return -2.
	    ⦁	If the plot for the property is not encompassed by the management company plot, it will return -3
	    ⦁	If the plot for the property overlaps any other property’s plot, it will return -4
	⦁	Otherwise, if the property is successfully added, it will return the index of the array where the property was added.
	*/
    public int addProperty(Property property) {
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1;
        }
        if (property == null) {
            return -2;
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }
        properties[numberOfProperties] = property;
        numberOfProperties++;
        return numberOfProperties - 1;
    }
    
    //makes the last property equal to null and subtracts total number of properties
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }
    
    public boolean isPropertiesFull() {
        if (numberOfProperties >= MAX_PROPERTY) {
        	return true; 
        }
        return false;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }
    
    public double getTotalRent() {
        double totalRent = 0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    //linear search to find and return highest value
    public Property getHighestRentPropperty() {
        if (numberOfProperties == 0) {
            return null;
        }
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    public boolean isManagementFeeValid() {
        if (managementFeePercent >= 0 && managementFeePercent <= 100) {
        	return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name)
          .append(", taxID: ").append(taxID)
          .append("\n______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            sb.append(properties[i].toString()).append("\n");
        }
        sb.append("______________________________________________________\n")
          .append("\n total management Fee: ")
          .append(getTotalRent() * managementFeePercent/100);
        return sb.toString();
    }
}
