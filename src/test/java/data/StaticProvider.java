package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    /*@DataProvider (name = "dataForSum")
    public static Object[][] dataForSumTest() {
        return new Object[][] {
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5}
        };*/
    @DataProvider(name = "Data for dividing the real numbers")
    public static Object[][] dataForDivRealNumbsTest() {
        return new Object[][]{
                {7, 7, 1},
                {-7, 7, -1},
                {-7, -7, 1},
                {7, -7, -1},
                {7, 1, 7},
                {-7, -1, 7},
                {-7, 1, -7},
                {7, -1, -7},
        };
    }
    @DataProvider(name = "Data for dividing the double numbers")
    public static Object[][] dataForDivDoubleNumbsTest() {
        return new Object[][]{
                {1.2, 1.2, 1},
                {-1.2, 1.2, -1},
                {-1.2, -1.2, 1},
                {1.2, -1.2, -1},
                {1.2, 1.0, 1.2},
                {-1.2, -1.0, 1.2},
                {-1.2, 1.0, -1.2},
                {1.2, -1.0, -1.2},
        };
    }
}
