import org.testng.annotations.*;
@Listeners(Listener.class)
public class BaseTest { //запускаем все тесты
    protected Calculator calculator = new Calculator();
}