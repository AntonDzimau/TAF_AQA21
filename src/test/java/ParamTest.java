import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {
//ДВА ПАРАМЕТРА, КОТОРЫЕ МЫ ХОТИМ ПОЛУЧИТЬ ИЗВНЕ. 1 ПАРАМЕТР ИЛИ МАССИВ ПАРАМЕТРОВ

    @Parameters({"login-value", "psw-value"})
    //кол-во переменных в методе и в параметрах должно быть одинаковым
    //имена могут отличаться
    //в параметрах мы исчем login-value в файле param.xml
    //Default login - это синоним в данном случае, используемый в коде
    @Test
    public void paramTest(@Optional("Default login") String login, @Optional("111111") String psw) {
    //@Optional - это дефолтные значения, которые возьмутся методом, в случае если не получена инфа
        //извне. Ничего не нашли (например в случае запуска непосредственно метода) - значит берем дефолт
        //public void paramTest(String login, String psw) {
        System.out.println("Login is: " + login);
        System.out.println("Password is: " + psw);
    }
}
