package com.codegym.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    private Connection connection;
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?verifyServerCertificate=false&useSSL=true";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";

    public BaseDAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
