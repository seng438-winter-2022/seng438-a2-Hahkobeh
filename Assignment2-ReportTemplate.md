**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |  5  |
| -------------- | --- |
| Student Names: |  Nicholas Knapton   |
|                |  Jacob Artusio   |
|                |  Brian Kramer  |
|                |  Colin Chripstophe   |

# 1 Introduction

Text…

# 2 Detailed description of unit test strategy

Our strategy for testing this system is to unit test with a combination of various blackbox testing techniques.

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
