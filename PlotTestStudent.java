/*
 * Class: CMSC203 22502 
 * Instructor: Dr. Kuijt
 * Description: PlotTest class of Project 4
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

public class PlotTestStudent {
	private Plot plot1, plot3;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(0, 0, 1, 1);
		plot3 = new Plot(2, 2, 2, 2);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot3 = null;
	}

	@Test
	public void testOverlaps() {
		assertFalse(plot1.overlaps(plot3));
	}
	
	@Test
	public void testToString() {
		assertEquals("2,2,2,2",plot3.toString());	
	}

}
