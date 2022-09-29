import org.testng.annotations.Test;

public class PriorityTest {
/**один из способов группировки по приоритету
    наприер по возастанию (если бы priority не было, то выполнялись бы
    по алфавиту. Приоритеты могут быть одинаковым приоритетом, тогда вернется
    приоритет алфавита
 ТИПА реализации HIGH, MEDIUM и LOW приоритетов выполнения тестов*/
    @Test (priority = 1)
    public void stepb() {System.out.println("stepb...");}

    @Test (priority = 2)
    public void stepa2() {System.out.println("stepa2...");}

    @Test (priority = 3)
    public void stepa11() {System.out.println("stepa11...");}

    @Test (priority = 4)
    public void stepd() {System.out.println("stepd...");}

    @Test (priority = 5)
    public void stepc() {System.out.println("stepc...");}
}
