**SENG 438 - Software Testing, Reliability, and Quality**
 
**Lab. Report \#2 – Requirements-Based Test Generation**
 
| Group \#:      |  5  |
| -------------- | --- |
| Student Names: |  Nicholas Knapton   |
|                |  Jacob Artuso   |
|                |  Brian Kramer  |
|                |  Colin Christophe   |
 
# 1 Introduction
 
In our last last we practiced testing a system. This lab built on that knowledge by requiring us to choose what method of blackbox testing to utilize. Once chosen we were tasked with creating proper tests using the JUnit framework. While we may have had some exposure to JUnit testing prior to this lab, the lab had more extensive use than any prior use of the framework.
 
# 2 Detailed description of unit test strategy
 
The unit test strategy implemented for the given system utilized various blackbox testing procedures. Different functions were tested differently depending on the requirements of the functions. For functions 'getUpperBound()', 'getLowerBound()', and 'getLength()' in the org.jfree.data.Range library equivalence class testing was used. We used equivalence class testing because all these functions are getter methods so, if one test case for any given function was incorrect it was likely that all test cases would be incorrect for that function. For the function 'contains()' strong robust boundary value testing was used to ensure that there were no mistakes when testing values that would be close to the lower or upper bounds. Strong Robust testing was chosen over weak robust testing to ensure that no boundaries were left out. The last function we tested in the org.jfree.data.Range library was 'combine()' and a strong equivalence class testing was used to map
out all combinations that needed to be tested. This helped to keep track of the multitude of different possible inputs and their expected results. For the library org.jfree.data.dataUtilities function 'equals (double[][] a, double[][] b)' was testing using equivalence class testing because it can be easily split into three partitions of input in a way that the input data should have the same effect on the SUT. Functions 'calculateColumnTotal(Values2D data, int column)' and 'calculateRowTotal(Values2D data, int row)' were subject to robustness testing to attempt to cover as many input scenarios as possible. 'createNumberArray(double[] data)' and 'createNumberArray2D(double[][] data)' were both tested with weak equivalence classes.

### Mocking Discussion
Mocking is definitely a great tool to have in the testing tool belt. It isolates the SUT from any errors in external objects that are relied on, this prevents false positive errors in our tests in the case that the object being used is giving incorrect info thus causing failure. So with mocking we can fairly easily create as the name implies “mock objects” that behave exactly as they should and not hopefully as they should. This can also be great in team development where maybe someone hasn't finished the full implementation of the object you rely on in your system. You can still implement your system and even test it without needing a complete version of the external object, just what expected outputs are. Mocking obviously cant and shouldn't be used for every situation however it is more versatile then stubs. Mocks don't have very many disadvantages however like most things, too much mocking can result in code smells. Mocking also brings with it increased complexity and thus more difficult code to read and change.
 
 
# 3 Test cases developed
 
## DataUtilities
 
### calculateColumnTotal(Values2D, int);
The following functions test the function calculateColumnTotal(Values2D, int) in the DataUtilities class. They ensure that given a 2D array and a column number the sum of the column will be correct when given an assortment of number combinations. We used robust testing to ensure that a range of input combinations were tested.

`calculateColumnTotalTest();`
The test calculateColumnTotalTest() checks the sum of a column that only contains positive rational numbers.
 
`calculateColumnTotalTestNegative()`
The test calculateColumnTotalTest() checks the sum of a column that contains a mix of positive and negative rational numbers.
 
`calculateColumnTotalTestNoRows()`
The test calculateColumnTotalTestNoRows() checks the sum of a column that has no rows to ensure that the sum is 0.
 
`calculateColumnTotalTestOtherColumn()`
The test calculateColumnTotalTestOtherColumn() checks the sum of a different column to ensure that these tests were consistent across columns in the table.
 
`calculateColumnTotalTestZeroTotal()`
The test calculateColumnTotalTestNoRows() checks the sum of a column that is 0.
 
### calculateRowTotal(Values2D, int);
The following functions test the function calculateRowTotal(Values2D, int) in the DataUtilities class. They ensure that given a 2D array and a row number the sum of the row will be correct when given an assortment of number combinations. We used robust testing to ensure that a range of input combinations were tested.
 
`calculateRowTotalTest()`
The test calculateRowTotalTest() checks the sum of a row that only contains positive rational numbers.
 
`calculateRowTotalTestZero()`
 The test calculateRowTotalTestZero() checks the sum where one of the values is zero to ensure that this does not cause problems to the summation.
 
`calculateRowTotalTestZeroTotal()`
The test calculateRowTotalTestNoRows() checks the sum of a row that is 0.
 
`calculateRowTotalTestNegative()`
The test calculateRowTotalTest() checks the sum of a row that contains a mix of positive and negative rational numbers.
 
`calculateRowTotalTestNegativeTotal()`
The test calculateColumnTotalTest() checks the sum of a column that contains a mix of positive and negative rational numbers with a sum that is negative.
 
`calculateRowTotalTestNoColumns()`
The test calculateRowTotalTestNoColumns() checks the sum of a row that has no columns to ensure that the sum is 0.
 
`calculateRowTotalTestOtherRow()`
 The test calculateRowTotalTestOtherRow() checks the sum of a different row to ensure that these tests were consistent across rows in the table.
 
### equal(double[][], double[][]);
The following functions test the function equal(double[][], double[][]) in the DataUtilities class. They ensure that the function will return the correct boolean after checking if the given arrays are equal. This is done with equivalence testing as theres 3 different partitions and errors picked up by seperate tests in the same partition would likely be picked up by the one equalivalence test.
 
`equalsTestMatching()`
The equalsTestMatching() test checks if the equal(double[][], double[][]) function will return true given two arrays which are the same.
 
`equalsTestNotMatching()`
The equalsTestNotMatching() test checks if the equal(double[][], double[][]) function will return false given two arrays which are the different.
 
`equalsTestNotMatchingExtraRow()`
The equalsTestNotMatchingExtraRow() test checks if the equal(double[][], double[][]) function will return false given two arrays which are different sizes.
 
### createNumberArray(double[]);
 
`createNumberArrayTest()`
The createNumberArrayTest() asserted that the correct array was created by createNumberArray(double[]). To ensure we could test a multitude of combinations we parameterized this testing to include arrays of different sizes. These input arrays also contained various types of rational numbers. Additionally, we also check that an empty array would give the correct output.
 
### createNumberArray2D(double[][]);
`createNumberArrayTest()`
 The createNumberArrayTest2D() asserted that the correct array was created by createNumberArray(double[][]). To ensure we could test a multitude of combinations we parameterized this testing to include arrays of different sizes. These input arrays also contained various types of rational numbers. Additionally, we also checked that an empty array would give the correct output.
## Range
 
### getCentralValue();
`centralValueShouldBeZero()`
CentralValueShouldBeZero() tests the function 'getCentralValue()' in the class Range. It ensures that getCentralValue returns the correct center value of a given range. We used equivalence testing with the range (-1,1) as if there is an error in one test case its very likely it will result in an error for all other inputs.
 
### getLowerBound();
`correctLowerBound()`
CorrectLowerBound tests the function 'getLowerBound()' in the class Range. It ensures getLowerBound() returns the correct lower bound given a range. We used equivalence testing as if there is an error in one test case its very likely it will result in an error for all other inputs.
 
### getLength();
`correctLength()`
CorrectLength tests the function 'getLength()' in the class Range. It ensures getLength() returns the correct length of the given range. We used equivalence testing as if there is an error in one test case its very likely it will result in an error for all other inputs.
 
### contains();
`containsTest()`
containstest() tested whether or not the contains() function would return the proper boolean given a number and range. We parameterized this testing so we could more easily implement boundary testing. We used a test at each of the BLB, LB, ALB, NOM, BUB, UB, AUB positions.
 
### combine();
 
`combineTest()`
combineTest() check if the correct boolean was returned from the combine() function. We used parameterized testing to run a multitude of combinations of ranges through this test. We used strong equivalence class testing to create our list of inputs for combineTest().
 
### getUpperBound();
`correctUpperBound()`
CorrectUpperBound tests the function 'getUpperBound()' in the class Range. It ensures getUpperBound() returns the correct upper bound given a range. We used equivalence testing as if there is an error in one test case its very likely it will result in an error for all other inputs.
 
// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above
 
# 4 How the team work/effort was divided and managed
Team work was divided evenly in terms of writing the report, designing and writing the tests was done together on one computer for the sake of simplicity.
 
# 5 Difficulties encountered, challenges overcome, and lessons learned
We faced some challenged initially in building some of the mock objects however there was lots of resources in the slides and online to refer too about them. We also ran into a roadblock with one of the supplied packages not working and after realizing that problem we went and found it online.
 
# 6 Comments/feedback on the lab itself
 
The lab was helpful for learning how to properly implement JUnit testing in a practical setting. It also taught how to use JMock and parameterized testing. These are skills that are important to understanding course material and thus made the lab intriguing.
