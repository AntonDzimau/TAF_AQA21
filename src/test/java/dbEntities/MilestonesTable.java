package dbEntities;

import models.MilestoneBuilder;
import services.DataBaseService;

import java.sql.ResultSet;

public class MilestonesTable {
    private DataBaseService dataBaseService;

    public MilestonesTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createMilestonesTable() {
        System.out.println("Create milestones table");

        String createTableSQL = "CREATE TABLE Milestones (" +
                "ID INTEGER PRIMARY KEY, " +
                "Name CHARACTER VARYING(30), " +
                "Description CHARACTER VARYING(255), " +
                "Started_On INTEGER," +
                "Project_Name CHARACTER VARYING(30), " +
                "Project_Id INTEGER" +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        System.out.println("Delete milestones table");
        String dropTableCustomersSQL = "DROP TABLE Milestones;";

        dataBaseService.executeSQL(dropTableCustomersSQL);
    }

    public void addMilestone(MilestoneBuilder milestone) {
        String insertTableSQL = "INSERT INTO public.Milestones(" +
                "Name, Description, Started_On)" +
                "VALUES ('" + milestone.getName() + "', '" + milestone.getDescription() + "', " +
                "'" + milestone.getStartedOn() + "');";
        dataBaseService.executeSQL(insertTableSQL);
    }

    public ResultSet getMilestones() {
        String selectSQL = "SELECT * FROM public.Milestones;";
        return dataBaseService.executeQuery(selectSQL);
    }

    public ResultSet getMilestoneById(int id) {
        String selectSQL = "SELECT * FROM public.Milestones WHERE id = " + id + ";";
        return dataBaseService.executeQuery(selectSQL);
    }
}
