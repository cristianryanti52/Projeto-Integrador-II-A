import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

    // CREATE
    public void salvar(Contato contato) {
        String sql = "INSERT INTO contatos (nome, telefone, email) VALUES (?, ?, ?)";
        
        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, contato.getNome());
            pstmt.setString(2, contato.getTelefone());
            pstmt.setString(3, contato.getEmail());
            pstmt.executeUpdate();
            
            System.out.println("✅ Contato salvo com sucesso!");

        } catch (SQLException e) {
            System.err.println("❌ Erro ao salvar contato: " + e.getMessage());
        }
    }

    // READ
    public List<Contato> listar() {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contatos";

        try (Connection conn = ConexaoMySQL.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setEmail(rs.getString("email"));
                contatos.add(contato);
            }

        } catch (SQLException e) {
            System.err.println("❌ Erro ao listar contatos: " + e.getMessage());
        }
        return contatos;
    }

    // UPDATE
    public void atualizar(Contato contato) {
        String sql = "UPDATE contatos SET nome = ?, telefone = ?, email = ? WHERE id = ?";

        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, contato.getNome());
            pstmt.setString(2, contato.getTelefone());
            pstmt.setString(3, contato.getEmail());
            pstmt.setInt(4, contato.getId());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("✅ Contato atualizado com sucesso!");
            } else {
                System.out.println("⚠️ Contato não encontrado para atualização.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Erro ao atualizar contato: " + e.getMessage());
        }
    }

    // DELETE
    public void deletar(int id) {
        String sql = "DELETE FROM contatos WHERE id = ?";

        try (Connection conn = ConexaoMySQL.getConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("✅ Contato deletado com sucesso!");
            } else {
                System.out.println("⚠️ Contato não encontrado para exclusão.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Erro ao deletar contato: " + e.getMessage());
        }
    }
}