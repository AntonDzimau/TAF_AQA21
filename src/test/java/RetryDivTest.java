import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryDivTest extends BaseTest {
    private int attempt = 1;

    @Test(retryAnalyzer = Retry.class)
    public void flakyTestDivIntNumbs() {
        if (attempt == 3) {
            Assert.assertEquals(calculator.div(4, 2), 2, "Неверный ожидаемый результат!");
        } else {
            attempt++;
            System.out.println("Attempt is: " + attempt);
            throw new NullPointerException();
        }
    }
}
