package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LowerRangeTest {

	@DataProvider
	public static Object[][] positiveDataSet() {
		return new Object[][] { { 1, 2 }, { 5, 6 }, {20, 20}, {2,2} };
	}
	
	@DataProvider
	public static Object[][] negativeDataSet() {
		return new Object[][] { { 1, 5 }, { 5, 13 }, {20, 12} };
	}


	@Test(dataProvider = "positiveDataSet")
	public void testLowerRange(int key, int expectedResult) {
		int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
		LowerRange lowerRange = new LowerRange();
		int actualResult = lowerRange.lower_range(arr, 0, arr.length - 1, key);
		
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test(dataProvider = "negativeDataSet")
	public void testNegativeLowerRange(int key, int expectedResult) {
		int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
		LowerRange lowerRange = new LowerRange();
		int actualResult = lowerRange.lower_range(arr, 0, arr.length - 1, key);
		
		Assert.assertNotEquals(actualResult, expectedResult);
	}

}
