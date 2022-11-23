package tests.db;

import baseEntities.BaseAPITest;
import dbEntities.CustomersTable;
import models.CustomerBuilder;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class simpleDataBaseTest extends BaseAPITest {
    @Test
    public void simpleDBTest(){
        CustomersTable customersTable = new CustomersTable(dataBaseService);
        customersTable.dropTable();
        customersTable.createCustomersTable();

                customersTable.addCustomer(CustomerBuilder.builder()
                        .firstName("Ivan")
                        .lastName("Ivanov")
                        .email("iviv@test.com")
                        .age(18)
                        .build());

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstName("Petr")
                .lastName("Petrov")
                .email("pepe@test.com")
                .age(33)
                .build());

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstName("Katya")
                .lastName("Kateva")
                .email("katkat@test.com")
                .age(23)
                .build());

        ResultSet rs = customersTable.getCustomers();
        try {
            while (rs.next()){
                String userid = rs.getString("ID");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                int age = rs.getInt("age");

                System.out.println(userid);
                System.out.println(firstname);
                System.out.println(lastname);
                System.out.println(age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
