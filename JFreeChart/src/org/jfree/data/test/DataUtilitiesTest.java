package org.jfree.data.test;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class DataUtilitiesTest extends DataUtilities {

	
	public static class rowAndColumnTests{
		Mockery mockingContext;
		Values2D values;
		

        //Creates a mockery for the tests and initializes values
		@Before
	    public void setUp() throws Exception { 
			mockingContext = new Mockery();
			values = mockingContext.mock(Values2D.class);
	    }
		
		// The test calculateColumnTotalTest() checks the sum of a column that only contains positive rational numbers.
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
			
			
			
	    
			
			
			assertEquals("Column total should be 15.", 15, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
		}
		
        //The test calculateColumnTotalTestNoRows() checks the sum of a column that is 0
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
			
			
			
			assertEquals("Column total should be 10.", 10, DataUtilities.calculateColumnTotal(values, 0), .000000001d);
		}
		
        //The test calculateColumnTotalTest() checks the sum of a column that contains a mix of positive and negative rational numbers.
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

        //The test calculateColumnTotalTestNoRows() checks the sum of a column that has no rows to ensure that the sum is 0
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
		
        //The test calculateColumnTotalTestOtherColumn() checks the sum of a different column to ensure that these tests were consistent across columns in the table.
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
		
        //The test calculateColumnTotalTestNoRows() checks the sum of a column that is 0
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
		
		//ROWS
		
        //The test calculateRowTotalTest() checks the sum of a row that only contains positive rational numbers.
		//regular function
		@Test
		public void calculateRowTotalTest() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(5));
				}
			});
	
			
			assertEquals("Row total should be 15.", 15, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		
        //The test calculateRowTotalTestZero() checks the sum where one of the values is zero to ensure that this does not cause problems to the summation
		//zero value
		@Test
		public void calculateRowTotalTestZero() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(0));
				}
			});
	
			
			assertEquals("Row total should be 10.", 10, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		
		//The test calculateRowTotalTestNoRows() checks the sum of a row that is 0.
		@Test
		public void calculateRowTotalTestZeroTotal() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(0));
				oneOf(values).getValue(0, 1);
				will(returnValue(0));
				oneOf(values).getValue(0, 2);
				will(returnValue(0));
				}
			});
	
			
			assertEquals("Row total should be 0.", 0, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		

		//The test calculateRowTotalTest() checks the sum of a row that contains a mix of positive and negative rational numbers.
		@Test
		public void calculateRowTotalTestNegative() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(-5));
				}
			});
	
			
			assertEquals("Row total should be 5.", 5, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		
		//The test calculateColumnTotalTest() checks the sum of a column that contains a mix of positive and negative rational numbers with a sum that is negative.
		@Test
		public void calculateRowTotalTestNegativeTotal() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(0));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(-5));
				}
			});
	
			
			assertEquals("Row total should be -2.5.", -2.5, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		
		//The test calculateRowTotalTestNoColumns() checks the sum of a row that has no columns to ensure that the sum is 0.
		@Test
		public void calculateRowTotalTestNoColumns() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(0));
				}
			});
	
			
			assertEquals("Row total should be 0.", 0, DataUtilities.calculateRowTotal(values, 0), .000000001d);
		}
		
		//The test calculateRowTotalTestOtherRow() checks the sum of a different row to ensure that these tests were consistent across rows in the table.
		@Test
		public void calculateRowTotalTestOtherRow() {
			mockingContext.checking(new Expectations() {
				{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(1, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(1, 2);
				will(returnValue(5));
				}
			});
	
			
			assertEquals("Row total should be 15.", 15, DataUtilities.calculateRowTotal(values, 1), .000000001d);
		}
	}
	
	//Create Number Array
	@RunWith(Parameterized.class)
	public static class createNumberArrayTests{
		
			
		double [] primitiveDoubleArray;
		
		Double [] objectDoubleArray;
		
		//The constructor initializes primitiveDoubleArray, and objectDoubleArray
		public createNumberArrayTests(double [] arr, Double [] arr2) {
			this.primitiveDoubleArray = arr;
			this.objectDoubleArray = arr2;
		}
		
        //Sets up parameterized testing and all the test cases that will check if the createNumberArray(double[]) function has bugs
        //Since we used weak equivalence class testing we used several inputs to ensure that the function works as intended
		@Parameters
	    public static Collection<Object[]> data(){
	    	return Arrays.asList(new Object[][] {
	    		{new double [] {2,3,4}, new Double [] {Double.valueOf(2),Double.valueOf(3),Double.valueOf(4)}},
	    		{new double [] {2.2,3.3,4.4}, new Double [] {Double.valueOf(2.2),Double.valueOf(3.3),Double.valueOf(4.4)}},
	    		{new double [] {-2,-3,-4}, new Double [] {Double.valueOf(-2),Double.valueOf(-3),Double.valueOf(-4)}},
	    		{new double [] {-2.2,-3.3,-4.4}, new Double [] {Double.valueOf(-2.2),Double.valueOf(-3.3),Double.valueOf(-4.4)}},
	    		{new double [] {2}, new Double [] {Double.valueOf(2)}},
	    		{new double [] {}, new Double [] {}}
	    		
	    	});
	    }
			
	    @Test
		public void createNumberArrayTest() {
			Assert.assertArrayEquals(objectDoubleArray,DataUtilities.createNumberArray(primitiveDoubleArray));
		}
	}
	
	//Create 2D Number Array
	@RunWith(Parameterized.class)
	public static class createNumberArray2DTests{
		
			
		double [][] primitiveDoubleArray2D;
		
		Double [][] objectDoubleArray2D;
		
		
		public createNumberArray2DTests(double [][] arr, Double [][] arr2) {
			this.primitiveDoubleArray2D = arr;
			this.objectDoubleArray2D = arr2;
		}
		

        //Sets up parameterized testing and all the test cases that will check if the createNumberArray2D(double[][]) function has bugs
        //Since we used weak equivalence class testing we used several inputs to ensure that the function works as intended
		@Parameters
	    public static Collection<Object[]> data(){
	    	return Arrays.asList(new Object[][] {
	    		//regular
	    		{
	    			new double [][]{ 
	    					{2,3,4},
	    					{5,6,7}
	    			}, new Double [][]{
	    				{Double.valueOf(2),Double.valueOf(3),Double.valueOf(4)},
	    				{Double.valueOf(5),Double.valueOf(6),Double.valueOf(7)},
	    			}
	    			
	    		},
	    		//one empty
	    		{
	    			new double [][]{ 
	    					{2,3,4},
	    					{}
	    			}, new Double [][]{
	    				{Double.valueOf(2),Double.valueOf(3),Double.valueOf(4)},
	    				{},
	    			}
	    			
	    		},
	    		//all empty
	    		{
	    			new double [][]{ 
	    					{},
	    					{}
	    			}, new Double [][]{
	    				{},
	    				{}
	    			}
	    			
	    		},
	    		//nothing
	    		{
	    			new double [][]{ 
	    					
	    			}, new Double [][]{
	    				
	    			}
	    			
	    		},
	    		{
	    			new double [][]{ 
	    					{-2,-3,-4},
	    					{-5,-6,-7}
	    			}, new Double [][]{
	    				{Double.valueOf(-2),Double.valueOf(-3),Double.valueOf(-4)},
	    				{Double.valueOf(-5),Double.valueOf(-6),Double.valueOf(-7)},
	    			}
	    			
	    		},
	    		{
	    			new double [][]{ 
	    					{2.2,3.2,4.2},
	    					{5.2,6.2,7.2}
	    			}, new Double [][]{
	    				{Double.valueOf(2.2),Double.valueOf(3.2),Double.valueOf(4.2)},
	    				{Double.valueOf(5.2),Double.valueOf(6.2),Double.valueOf(7.2)},
	    			}
	    			
	    		},
	    	});
	    }
			
	    @Test
		public void createNumberArrayTest() {
			Assert.assertArrayEquals(objectDoubleArray2D,DataUtilities.createNumberArray2D(primitiveDoubleArray2D));
		}
	}
	
	
	public static class equalsTests{
		double [][] arr1;
		double [][] arr2;
		double [][] arr3;
		double [][] arr4;
		
		
		//Sets up a
		@Before
		public void setUp() throws Exception { 
			arr1 = new double [][]{
					{2,3,4},
					{4,5,2}
			};
			arr2 = new double [][]{
				{2,3,4},
				{4,5,2}
			};
			arr3 = new double [][]{
				{55,2,4},
				{4,2,1}
			};
			arr4 = new double [][]{
				{55,2,4},
				{4,2,1},
				{444}
			};
		}

        // The equalsTestMatching() test checks if the equal(double[][], double[][]) function will return true given two arrays which are the same.	
		@Test
		public void equalsTestMatching() {
			assertTrue("They should be the same.", DataUtilities.equal(arr1, arr2));
		}

        // The equalsTestNotMatching() test checks if the equal(double[][], double[][]) function will return false given two arrays which are the different.
		@Test
		public void equalsTestNotMatching() {
			assertFalse("They should be different.", DataUtilities.equal(arr1, arr3));
		}
        
        //The equalsTestNotMatchingExtraRow() test checks if the equal(double[][], double[][]) function will return false given two arrays which are different sizes.
		@Test
		public void equalsTestNotMatchingExtraRow() {
			assertFalse("They should be different.", DataUtilities.equal(arr3, arr4));
		}
	}
}
