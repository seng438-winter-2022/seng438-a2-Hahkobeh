**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |  5  |
| -------------- | --- |
| Student Names: |  Nicholas Knapton   |
|                |  Jacob Artusio   |
|                |  Brian Kramer  |
|                |  Colin Christophe   |

# 1 Introduction

Text…

# 2 Detailed description of unit test strategy

 The unit test strategy implemented for the given system utilized various blackbox testing procedures. Different functions were tested different depending on the requirements of the functions. For fuctions 'getUpperBound()', 'getLowerBound()', and 'getLength()' in the org.jfree.data.Range library equivalence class testing was used. We used equivalence class testing because all these functions are getter methods so, if one test case for any giuven function was incorrect it was likely that all test cases would be incorrect for that function. For the function 'contains()' strong robust boundary value testing was used to ensure that there were no mistakes when testing values that would be close to the lower or upper bounds. Strong Robust testing was chosen over weak robust testing to ensure that no boundaries were left out. The last function we tested in the org.jfree.data.Range library was 'combine()' and a strong equivalence calss testing was used to map 
    out all combinations that needed to be tested. This helped to keep track of the multitude of different possible inputs and their expected results. For the library org.jfree.data.dataUtilities function 'equals (double[][] a, double[][] b)' was testing using equivalance class testing because it can be easily split into three partitions of input in a way that the input data should have the same effect on the SUT. Functions 'calculateColumnTotal(Values2D data, int column)' and 'calculateRowTotal(Values2D data, int row)' were tested using 

# 3 Test cases developed

## DataUtilities

### calculateColumnTotal(Values2D, int);
`calculateColumnTotalTest();`

`calculateColumnTotalTestZero()`

`calculateColumnTotalTestNegative()`

`calculateColumnTotalTestNoRows()`

`calculateColumnTotalTestOtherColumn()`

`calculateColumnTotalTestZeroTotal()`

### calculateRowTotal(Values2D, int);
`calculateRowTotalTest()`
`calculateRowTotalTestZero()`
`calculateRowTotalTestZeroTotal()`
`calculateRowTotalTestNegative()`
`calculateRowTotalTestNegativeTotal()`
`calculateRowTotalTestNoColumns()`
`calculateRowTotalTestOtherRow()`

### equal(double[][], double[][]);
`equalsTestMatching()`
`equalsTestNotMatching()`
`equalsTestNotMatchingExtraRow()`

### createNumberArray(double[]);
`createNumberArrayTest()`

### createNumberArray2D(double[][]);
`createNumberArrayTest()`

## Range

### getCentralValue();
`centralValueShouldBeZero()`
CentralValueShouldBeZero() tests the function 'getCentralValue()' in the class Range. It ensures that getCentralValue returns the correct center value of a given range.

### getLowerBound();
`correctLowerBound()`
 CorrectLowerBound tests the function 'getLowerBound()' in the class Range. It ensures getLowerBound() returns the correct lower bound given a range.

### getLength();
`correctLength()`
CorrectLength tests the function 'getLength()' in the class Range. It ensures getLength() returns the correct length of the given range.

### contains();
`containsTest()`

### combine();
`combineTest()`

### getUpperBound();
`correctUpperBound()`
CorrectUpperBound tests the function 'getUpperBound()' in the class Range. It ensures getUpperBound() returns the correct upper bound given a range.

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed
Team work was divided evenly in terms of writing the report, designing and writing the tests was done together on one computer for the sake of simplicity.

# 5 Difficulties encountered, challenges overcome, and lessons learned
We faced some challenged initially in building some of the mock objects however there was lots of resources in the slides and online to refer too about them. We also ran into a roadblock with one of the supplied packages not working and after relizing that problem we went and found it online. 

# 6 Comments/feedback on the lab itself

Text…
