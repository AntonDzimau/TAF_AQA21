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
    @DataProvider(name = "Data for division the real numbers")
    public static Object[][] dataForDivRealNumbsTest() {
        return new Object[][]{
                {18, -2, -9},
                {0, 1, 0},
                {17, 17, 1},
                {-23, -1, 23}
        };
    }
    @DataProvider(name = "Data for division the double numbers")
    public static Object[][] dataForDivDoubleNumbsTest() {
        return new Object[][]{
                {18.9, -3, -6.3},
                {0.0, 0.2, 0},
                {21.5, -0.1, -215},
                {-9.3, -3, 3.1}
        };
    }
}
