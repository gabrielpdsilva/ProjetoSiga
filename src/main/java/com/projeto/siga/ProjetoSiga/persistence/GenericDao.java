package com.projeto.siga.ProjetoSiga.persistence;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class GenericDao {
    private Connection c;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String dbName = "siga";
        String user = "sa";
        String password = "123456";
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        c = DriverManager.getConnection(
                String.format(
                        "jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;",
                        hostName,
                        dbName,
                        user,
                        password
                )
        );
        return c;
    }
}
