import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    /**
     * Обработчик событий. Выполняет что-то в случае какого-то ивента, например когда тест упал
     */
    //переопределяем один из методов класса Listener
    public void onTestFailure(ITestResult result) {
        System.out.println("Make a screenshot...");
    }

}
