import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range; 
import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class RangeTest {
    
    
    @RunWith(Parameterized.class)
    public static class RangeContainsTest{
    	
    	
    	private Range exampleRange;
    	private double number;
        private boolean expectedResult;
        
        public RangeContainsTest(double num, boolean res) {
        	this.number = num;
        	this.expectedResult = res;
        }
        
        @Before
        public void setUp() throws Exception { 
        	exampleRange = new Range(-1, 1);
        }
        
        
    	
	    
	    @Parameters
	    public static Collection<Object[]> data(){
	    	return Arrays.asList(new Object[][] {
	    		{-1.0001, false},
	    		{-1, true},
	    		{-0.9999,true},
	    		{0,true},
	    		{0.9999,true},
	    		{1,true},
	    		{1.0001,false}
	    	});
	    }
	    
	    @Test
	    public void containsTest() {
	    	assertEquals("Contains test", this.expectedResult,exampleRange.contains(this.number));
	    }
	    
	    
	    @After
        public void tearDown() throws Exception {
	    	exampleRange = null;
        	assertNull(exampleRange);
        }
    }
    
    @RunWith(Parameterized.class)
    public static class RangeCombinedTest{
    	
    	
    	private Range firstRange;
    	private Range secondRange;
    	private Range expectedRange;
        
        public RangeCombinedTest(Range first, Range second, Range expected) {
        	this.firstRange = first;
        	this.secondRange = second;
        	this.expectedRange = expected;
        }
        
        @Before
        public void setUp() throws Exception { 
        }
        
	    
	    @Parameters
	    public static Collection<Object[]> data(){
	    	return Arrays.asList(new Object[][] {
	    		{new Range(0,2), new Range(1,2), new Range(0,2)},
	    		{new Range(1,2), new Range(0,2), new Range(0,2)},
	    		{new Range(0,2), new Range(0,1), new Range(0,2)},
	    		{new Range(0,1), new Range(0,2), new Range(0,2)},
	    		{new Range(0,2), new Range(2,4), new Range(0,4)},
	    		{new Range(0,1), new Range(3,4), new Range(0,4)},
	    		{new Range(-1,0), new Range(0,1), new Range(-1,1)},
	    		{new Range(0,1), new Range(0,1), new Range(0,1)},
	    		{new Range(0,1), null, new Range(0,1)},
	    		{null, new Range(0,1), new Range(0,1)},
	    		{null, null, null},
	    		{new Range(0,0), new Range(0,0), new Range(0,0)},
	    		{new Range(0,50000), new Range(-50000,0), new Range(-50000,50000)}
	    		
	    		
	    		
	    		
	    		
	    		
	    	});
	    }
	    
	    @Test
	    public void combineTest() {
	    	assertEquals("Combine test", Range.combine(firstRange, secondRange), this.expectedRange);
	    }
	    
	    @After
        public void tearDown() throws Exception {
        	firstRange = null;
        	secondRange = null;
        	expectedRange = null;
        	assertNull(firstRange);
        	assertNull(secondRange);
        	assertNull(expectedRange);
        	
        }

    }
    
    public static class RangeRegularTests{
    	private Range exampleRange;
        

        @BeforeClass public static void setUpBeforeClass() throws Exception {
        }


        @Before
        public void setUp() throws Exception { 
        	exampleRange = new Range(-1, 1);
        }


        @Test
        public void centralValueShouldBeZero() {
            assertEquals("The central value of -1 and 1 should be 0",
            0, exampleRange.getCentralValue(), .000000001d);
        }
        
        
        @Test
        public void correctUpperBound() {
        	assertEquals("The Upper Bound should be 1",1,exampleRange.getUpperBound(),.000000001d);
        }
        
        @Test
        public void correctLowerBound() {
        	assertEquals("The Lower Bound should be -1",-1,exampleRange.getLowerBound(),.000000001d);
        }
        
        @Test
        public void correctLength() {
        	assertEquals("The length should be 2", 2, exampleRange.getLength(),.000000001d);
        }

        @After
        public void tearDown() throws Exception {
        	exampleRange = null;
        	assertNull(exampleRange);
        }

        @AfterClass
        public static void tearDownAfterClass() throws Exception {
        }
    }
        
}
    
    
    
    
    
    
    

    
    

    
     
    
    
