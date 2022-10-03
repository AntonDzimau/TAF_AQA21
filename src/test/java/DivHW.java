import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivHW extends BaseTest {
    @Test(groups = "smoke", priority = 1, testName = "Dividing of two positive real numbers.")
    public void divisionPosIntTest() {
        Assert.assertEquals(calculator.div(9, 3), 3, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 1, testName = "Dividing of two negative real numbers.")
    public void divisionNegIntTest1() {
        Assert.assertEquals(calculator.div(-9, -3), 3, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 1, testName = "Dividing a positive real number by a negative real number.")
    public void divisionNegIntTest2() {
        Assert.assertEquals(calculator.div(9, -3), -3, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 1, testName = "Dividing a negative real number by a positive real number.")
    public void divisionNegIntTest3() {
        Assert.assertEquals(calculator.div(-9, 3), -3, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 2, testName = "Dividing a real numbers with data from provider.", dataProvider = "Data for dividing the real numbers", dataProviderClass = StaticProvider.class, threadPoolSize = 4)
    public void divisionIntFromDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 3, testName = "Dividing zero by a positive real number.")
    public void divisionZeroByPosRealNumberTest() {
        Assert.assertEquals(calculator.div(0, 8), 0, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 3, testName = "Dividing zero by a negative real number.")
    public void divisionZeroByNegRealNumberTest() {
        Assert.assertEquals(calculator.div(0, -8), 0, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 3, testName = "Dividing a positive real number by zero.", expectedExceptions = ArithmeticException.class)
    public void divisionPosRealNumberByZeroTest() throws ArithmeticException {
        calculator.div(8, 0);
    }

    @Test(groups = "smoke", priority = 3, testName = "Dividing a negative real number by zero.", expectedExceptions = ArithmeticException.class)
    public void divisionNegRealNumberByZeroTest() throws ArithmeticException {
        calculator.div(-8, 0);
    }

    @Test(groups = "smoke", priority = 3, testName = "Dividing of two real zeroes.", expectedExceptions = ArithmeticException.class)
    public void divisionRealZeroesTest() throws ArithmeticException {
        calculator.div(0, 0);
    }

    @Test(groups = "smoke", priority = 4, testName = "Dividing of two positive double numbers.")
    public void divisionPosDoubleTest() {
        Assert.assertEquals(calculator.div(15.6, 3.0), 5.2, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 4, testName = "Dividing of two negative double numbers.")
    public void divisionNegDoubleTest1() {
        Assert.assertEquals(calculator.div(-15.6, -3.0), 5.2, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 4, testName = "Dividing a positive double number by a negative double number.")
    public void divisionNegDoubleTest2() {
        Assert.assertEquals(calculator.div(15.6, -3.0), -5.2, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 4, testName = "Dividing a negative double number by a positive double number.")
    public void divisionNegDoubleTest3() {
        Assert.assertEquals(calculator.div(-15.6, 3.0), -5.2, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 5, testName = "Dividing a double numbers with data from provider.", dataProvider = "Data for dividing the double numbers", dataProviderClass = StaticProvider.class, threadPoolSize = 2, timeOut = 10)
    public void divisionDoubleFromDataProvider(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 6, testName = "Dividing zero by a positive double number.")
    public void divisionZeroByPosDoubleNumberTest() {
        Assert.assertEquals(calculator.div(0, 1.2), 0, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 6, testName = "Dividing zero by a negative double number.")
    public void divisionZeroByNegDoubleNumberTest() {
        Assert.assertEquals(calculator.div(0, -1.2), 0, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 6, testName = "Dividing a positive real number by zero.")
    public void divisionPosDoubleNumberByZeroTest() throws ArithmeticException {
        Assert.assertEquals(calculator.div(1.2, 0), Double.POSITIVE_INFINITY, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 6, testName = "Dividing a negative real number by zero.")
    public void divisionNegDoubleNumberByZeroTest() throws ArithmeticException {
        Assert.assertEquals(calculator.div(-1.2, 0), Double.NEGATIVE_INFINITY, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", priority = 6, testName = "Dividing of two real zeroes.")
    public void divisionDoubleZeroesTest() throws ArithmeticException {
        Assert.assertEquals(calculator.div(0.0, 0.0), Double.NaN, "Неверный ожидаемый результат.");
    }

    @Test(groups = "regression", priority = 10, invocationCount = 4, invocationTimeOut = 1000, threadPoolSize = 2, testName = "Quadruple dividing on two streams.")
    public void testDivWithInvocation() throws InterruptedException {
        Thread.sleep(800);
        Assert.assertEquals(calculator.div(-15.6, 3.0), -5.2, "Неверный ожидаемый результат.");
        Assert.assertEquals(calculator.div(-15, 5), -3, "Неверный ожидаемый результат.");
        Assert.assertEquals(calculator.div(-150, -15), 10, "Неверный ожидаемый результат.");
        Assert.assertEquals(calculator.div(63.6, 2.0), 31.8, "Неверный ожидаемый результат.");
    }

    @Test(groups = "regression", priority = 10, timeOut = 750, testName = "Dividing of two double after some time test.")
    public void testDivDouble1() throws InterruptedException {
        Thread.sleep(732);
        Assert.assertEquals(calculator.div(15.6, 3.0), 5.2, "Неверный ожидаемый результат.");
    }
}
