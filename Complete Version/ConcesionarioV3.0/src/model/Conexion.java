package model;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conectar;

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String usuario = "root";
    private static final String pwd = "";
    private static final String direccionDB = "jdbc:mysql://localhost/burnz_buttly";

    public Conexion() {
        conectar = null;
        try {
            Class.forName(driver);
            conectar = DriverManager.getConnection(direccionDB, usuario, pwd);

            if (conectar != null) {
                System.out.println("Conexión exitosa!");

            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Fallo " + e);
        }

    }

    public Connection getConnection() {
        return conectar;
    }

    public void desconectar() {
        conectar = null;
        if (conectar == null) {
            System.out.println("Desconectado");
        }
    }

}
