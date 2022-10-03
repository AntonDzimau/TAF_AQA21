import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivHW extends BaseTest {
    @Test(groups = "smoke", priority = 1)
    public void testDivInt() {
        Assert.assertEquals(calculator.div(4, 2), 2, "Неверный ожидаемый результат...");
    }

    @Test(groups = "regression", enabled = false, priority = 10)
    public void testDivInt1() {
        Assert.assertEquals(calculator.div(4, 3), 2, "Неверный ожидаемый результат!");
    }

    @Test(groups = "smoke", description = "Тест проверяющий деление 0 на целое число числа на 0.", priority = 2)
    public void testDivInt2() {
        Assert.assertEquals(calculator.div(0, 87), 1, "Если ноль разделить на число получится ноль!");
    }

    @Test(groups = "smoke", testName = "Division of two real numbers.", priority = 3)
    public void testDivDouble() {
        Assert.assertEquals(calculator.div(1.3, 2.0), 0.65, "Неверный ожидаемый результат!");
    }

    @Test(groups = "regression", timeOut = 750, testName = "Division after some time test.", priority = 1)
    public void testDivDouble1() throws InterruptedException {
        Thread.sleep(735);
        Assert.assertEquals(calculator.div(88888888.4444, 22222222.1111), 4, "Неверный ожидаемый результат.");
    }

    @Test(groups = "regression", invocationCount = 4, invocationTimeOut = 1000, threadPoolSize = 2, testName = "Quadruple division on two streams.", priority = 2)
    public void testDivWithInvocation() throws InterruptedException {
        Thread.sleep(900);
        Assert.assertEquals(calculator.div(999999999, 333333333), 3, "Неверный ожидаемый результат.");
        Assert.assertEquals(calculator.div(15.6, 3.0), 5.2, "Неверный ожидаемый результат.");
        Assert.assertEquals(calculator.div(10.0, 0.1), 100, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", dataProvider = "Data for division the real numbers", dataProviderClass = StaticProvider.class, threadPoolSize = 4, priority = 4)
    public void testDivDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", dependsOnMethods = "testDivDataProvider", dataProvider = "Data for division the double numbers", dataProviderClass = StaticProvider.class, threadPoolSize = 2, timeOut = 10, priority = 5)
    public void testDataProvider(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "Неверный ожидаемый результат.");
    }

    @Test(groups = "smoke", testName = "Div int nums by 0", expectedExceptions = ArithmeticException.class, priority = 6)
    public void testExceptionsWithIntNumbs() throws ArithmeticException {
        calculator.div(17, 0);
    }

    @Test(groups = "smoke", dependsOnMethods = "testExceptionsWithIntNumbs", testName = "Div double nums by 0", expectedExceptions = ArithmeticException.class, priority = 7)
    public void testExceptionsWithDoubleNumbs() {
        calculator.div(23.7, 0);
        //Assert.assertEquals(calculator.div(23.7, 0), "Inf");
        /**Тест ПАДАЕТ, не ловит ошибку ArithmeticException by zero, а пишет актуальным результат - Infinity*/
    }
}
