package dbEntities;

import dbServices.CustomerService;
import models.CustomerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.DataBaseService;

import java.sql.ResultSet;

public class CustomersTable {
    Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private DataBaseService dataBaseService;

    public CustomersTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createCustomersTable() {
        logger.info("Create customers table");

        String createTableSQL = "CREATE TABLE Customers (" +
                "ID SERIAL PRIMARY KEY, " +
                "FirstName CHARACTER VARYING(30), " +
                "LastName CHARACTER VARYING(30), " +
                "Email CHARACTER VARYING(30), " +
                "Age INTEGER" +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Delete customers table");
        String dropTableCustomersSQL = "DROP TABLE Customers;";

        dataBaseService.executeSQL(dropTableCustomersSQL);
    }

    public void addCustomer(CustomerBuilder customer) {
        String insertTableSQL = "INSERT INTO public.Customers(" +
                "firstname, lastname, email, age)" +
                "VALUES ('" + customer.getFirstName() + "', '" + customer.getLastName() + "', " +
                "'" + customer.getEmail() + "', " + customer.getAge() + ");";
        dataBaseService.executeSQL(insertTableSQL);
    }

    public ResultSet getCustomers() {
        String selectSQL = "SELECT * FROM public.customers;";
        return dataBaseService.executeQuery(selectSQL);
    }
    public ResultSet getCustomersById(int id) {
        String selectSQL = "SELECT * FROM public.customers WHERE id = " + id + ";";
        return dataBaseService.executeQuery(selectSQL);
    }
}
