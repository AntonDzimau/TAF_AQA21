import org.testng.annotations.*;

public class BaseTest { //запускаем все тесты
protected Calculator calculator = new Calculator();


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite: ...");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest: ...");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass: ...");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod: ...");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("BeforeGroups: ...");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite: ...");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest: ...");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass: ...");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod: ...");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("AfterGroups: ...");
    }

}
/**

ТЕСТ CLASS - тестирует целую фичу (одну функциональность) с помощью многих тестовых методов
TEST METHOD - это вот этот маленький метод, тестирующий маленькую функциональноть

 enabled true or false -  игнорируем тест с этим параметром-аннотацией
 description - добавляет описание к тестовому методу, виден только в отчете
 testName - заменяет имя метода теста на то, что указали
 dependensOnMethods - определяет зависимость текущего тестового метода, от указанных
 если тесты от которых тест зависит, не выполнятся, то и он не выполнится, потому что он блин от них зависит
 нооо если мы хотим все-таки запустить тест вне зависимости от того, запустился ли тест, от которого
 зависит наш, мы пишем параметр alwaysRun = true.
 timeout - время в мс, если тест не выполнился за это время, он считается упавшим
 invocationCount - тест будет запущен столько раз, сколько указано, invocationTimeOut - время за которое должны быть выполнены ВСЕ
 итерации, threadPoolSize - во сколько параллельных потоков выполнить тесты (3 теста - 3 потока ---> выполняем одновременно)
 количество потоков ДЛЯ ЮНИТ ТЕСТОВ (они маленькие, можно работать) равно количеству ЯДЕР компа
 dataProvider - задает имя поставщика данных этого метода

 */