/*
 * Class: CMSC203 22502 
 * Instructor: Dr. Kuijt
 * Description: PropertyTest class of Project 4
 * Due: 11/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Alex Kim
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
	Property propertyOne;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("Property XYZ", "SkibidiVille", 3100.00, "Sigma Grindset");
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("Property XYZ", propertyOne.getPropertyName());
	}

	@Test
	void testGetRentAmount() {
		assertEquals(3100.00, propertyOne.getRentAmount());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("Property XYZ,SkibidiVille,Sigma Grindset,3100.0",propertyOne.toString());	
	}

}
