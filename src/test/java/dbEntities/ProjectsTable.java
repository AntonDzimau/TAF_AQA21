package dbEntities;

import models.ProjectBuilder;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectsTable {
    private DataBaseService dataBaseService;

    public ProjectsTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createProjectsTable() {
        System.out.println("Create projects table");

        String createTableSQL = "CREATE TABLE Projects (" +
                "ID SERIAL PRIMARY KEY, " +
                "Name CHARACTER VARYING(30), " +
                "Announcement CHARACTER VARYING(255), " +
                "Is_Show_Announcement BOOLEAN, " +
                "Type_Of_Project INTEGER, " +
                "Is_Completed BOOLEAN" +
                ");";

        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        System.out.println("Delete projects table");
        String dropTableCustomersSQL = "DROP TABLE Projects;";

        dataBaseService.executeSQL(dropTableCustomersSQL);
    }

    public void addProject(ProjectBuilder project) {
        String insertTableSQL = "INSERT INTO public.Projects(" +
                "Name, Announcement, Is_Show_Announcement, Type_Of_Project, Is_Completed)" +
                "VALUES ('" + project.getName() + "', '" + project.getAnnouncement() + "', "
                + project.isShowAnnouncement() + ", " + project.getTypOfProject() + ", " + project.isCompleted() + ");";
        dataBaseService.executeSQL(insertTableSQL);
    }

    public ResultSet getProjects() {
        String selectSQL = "SELECT * FROM public.Projects;";
        return dataBaseService.executeQuery(selectSQL);
    }

    public ResultSet getProjectsById(int id) {
        String selectSQL = "SELECT * FROM public.Projects WHERE id = " + id + ";";
        return dataBaseService.executeQuery(selectSQL);
    }
}
