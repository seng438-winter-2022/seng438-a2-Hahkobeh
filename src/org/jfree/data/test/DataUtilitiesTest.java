package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

	Mockery mockingContext;
	Values2D values;
	

	@Before
    public void setUp() throws Exception { 
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
    }
	
	//regular function
	@Test
	public void calculateColumnTotalTest() {
		mockingContext.checking(new Expectations() {
			{
			oneOf(values).getRowCount();
			will(returnValue(3));
			oneOf(values).getValue(0, 0);
			will(returnValue(7.5));
			oneOf(values).getValue(1, 0);
			will(returnValue(2.5));
			oneOf(values).getValue(2, 0);
			will(returnValue(5));
			}
		});
		
		mockingContext.checking(new Expectations() {
			
		});
		
		
    
		
		
		assertEquals("Column total should be 15.", 15, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
	}
	
	//zero value (boundary)
	@Test
	public void calculateColumnTotalTestZero() {
		mockingContext.checking(new Expectations() {
			{
			oneOf(values).getRowCount();
			will(returnValue(3));
			oneOf(values).getValue(0, 0);
			will(returnValue(7.5));
			oneOf(values).getValue(1, 0);
			will(returnValue(2.5));
			oneOf(values).getValue(2, 0);
			will(returnValue(0));
			}
		});
		
		mockingContext.checking(new Expectations() {
			
		});
		
		assertEquals("Column total should be 10.", 10, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
	}
	
	//negative value (boundary)
	@Test
	public void calculateColumnTotalTestNegative() {
		mockingContext.checking(new Expectations() {
			{
			oneOf(values).getRowCount();
			will(returnValue(2));
			oneOf(values).getValue(0, 0);
			will(returnValue(7.5));
			oneOf(values).getValue(1, 0);
			will(returnValue(-2.5));
			}
		});
		
		assertEquals("Column total should be 5.", 5, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
	}
	//No rows (boundary)
	@Test
	public void calculateColumnTotalTestNoRows() {
		mockingContext.checking(new Expectations() {
			{
			oneOf(values).getRowCount();
			will(returnValue(0));
			}
		});
		
		assertEquals("Column total should be 0.", 0, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
	}
	
	//Other column (boundary)
	@Test
	public void calculateColumnTotalTestOtherColumn() {
		mockingContext.checking(new Expectations() {
			{
			oneOf(values).getRowCount();
			will(returnValue(3));
			oneOf(values).getValue(0, 1);
			will(returnValue(5));
			oneOf(values).getValue(1, 1);
			will(returnValue(5));
			oneOf(values).getValue(2, 1);
			will(returnValue(5));
			}
		});
		
		assertEquals("Column total should be 15.", 15, DataUtilities.calculateColumnTotal(values, 1), .000000001d);
	}
	
	//zero total (boundary)
	@Test
	public void calculateColumnTotalTestZeroTotal() {
		mockingContext.checking(new Expectations() {
			{
			oneOf(values).getRowCount();
			will(returnValue(3));
			oneOf(values).getValue(0, 0);
			will(returnValue(0));
			oneOf(values).getValue(1, 0);
			will(returnValue(0));
			oneOf(values).getValue(2, 0);
			will(returnValue(0));
			}
		});
		
		assertEquals("Column total should be 0.", 0, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
	}
	
	
	
	

	/*
	 * @Test public void calculateColumnTotalForTwoValues() {
	 * 
	 * // exercise double result = DataUtilities.calculateColumnTotal(values, 0);
	 * 
	 * 
	 * // verify //assertEquals(result, 10.0, .000000001d); // tear-down: NONE in
	 * this test method }
	 */

}