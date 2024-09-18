package util;

import java.sql.*;

public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/ticket_controle";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection conn;

    public static Connection getConexao() {

        try {
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão bem sucedida!");
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException ex) {
            System.out.println("Erro na conxão com o Banco de dados" + ex.getMessage());
            return null;
        }
        
    }

}
