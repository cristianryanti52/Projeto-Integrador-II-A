import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static final String URL = "jdbc:mysql://localhost:3306/agenda_java";
    private static final String USUARIO = "root";
    // ATENÇÃO: Altere para a senha do seu banco de dados
    private static final String SENHA = "SENHA_BANCO_MYSQL"; 

    public static Connection getConexao() {
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Retorna a conexão com o banco de dados
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            // Lança uma exceção em tempo de execução para interromper o programa
            throw new RuntimeException(e);
        }
    }
}