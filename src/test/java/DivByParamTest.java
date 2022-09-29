import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DivByParamTest {
    @Parameters({"firstNum-value", "secondNum-value"})
    @Test
    public void DivByParamTest(@Optional("First num is not found.") String firstNum, @Optional("Second num is not found.") String secondNum) {
        System.out.println("First num is: " + firstNum);
        System.out.println("First num is: " + secondNum);
        System.out.println("Division first num by second num is: " + Integer.parseInt(firstNum) / Integer.parseInt(secondNum));
    }
}
