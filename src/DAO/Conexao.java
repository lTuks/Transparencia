package DAO;

import java.sql.*;

public class Conexao {

    private Connection conexao;

    public Conexao() throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, SQLException {
        String databaseURL = "jdbc:postgresql://localhost:5432/postgres";
        String usuario = "postgres";
        String senha = "123";
        String driverName = "org.postgresql.Driver";
        //Carrega o driver
        Class.forName(driverName).newInstance();
        //Conecta o BD
        conexao = DriverManager.getConnection(databaseURL, usuario, senha);
    }
    public static Connection getConnection(String url, String usuario, String senha ) throws SQLException {
        return DriverManager.getConnection( url, usuario, senha );
    }

    public void setConnection(Connection connection) {
        this.conexao = connection;
    }

    public Connection getConnection() {
        return conexao;
    }
     public static Connection getSafetyPlanConnection() throws SQLException {
        return getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
    }
}
