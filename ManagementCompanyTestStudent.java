/*
 * Class: CMSC203 22502 
 * Instructor: Dr. Kuijt
 * Description: ManagementCompanyTest class of Project 4
 * Due: 11/03/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Alex Kim
*/

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	Property sampleProperty;
	ManagementCompany mangementCo ; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo= new ManagementCompany("Skibidi", "12345678", 9);
	}

	@After
	public void tearDown() throws Exception {
		mangementCo=null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Chungus", "StillWater", 1234, "Sigma",1,4,2,3);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Sunsational", "StillWater", 1234, "Sigma",1,4,2,3);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	
		assertEquals(mangementCo.getPropertiesCount(), 1);
	}

	@Test
	public void testToString() {
		sampleProperty = new Property ("Chungus", "StillWater", 1234.0, "Sigma",1,4,2,3);
		assertEquals(mangementCo.addProperty(sampleProperty), 0);	//property has been successfully added to index 0
		String expectedString = "List of the properties for Skibidi, taxID: 12345678\n"
				+ "______________________________________________________\n"
				+ "Chungus,StillWater,Sigma,1234.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 111.06";
		System.out.println(expectedString);
		System.out.println(mangementCo.toString());
		assertEquals(expectedString, mangementCo.toString());
				
	}

}