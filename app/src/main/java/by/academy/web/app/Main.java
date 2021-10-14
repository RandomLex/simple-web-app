package by.academy.web.app;

import by.academy.web.model.enterprise.Department;
import by.academy.web.model.enterprise.Employee;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/dbit";
    private static final String USER = "userit";
    private static final String PASSWORD = "asd123";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SALARY = "salary";

    public static void main(String[] args) {

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("select id, name, salary from employee");
             ResultSet rs = ps.executeQuery()) {
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                employees.add(Employee.builder()
                        .id(rs.getInt(ID))
                        .name(rs.getString(NAME))
                        .salary(rs.getInt(SALARY))
                        .build());
            }

            employees.forEach(System.out::println);

        } catch (SQLException e) {
            log.error("Connection error ", e);
        }


    }


    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
