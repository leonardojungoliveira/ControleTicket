package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Funcionario;
import util.Conexao;

public class FuncionarioDAO {

    // Método para cadastrar funcionário
    public static void cadastrarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, cpf, situacao, data_alteracao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, String.valueOf(funcionario.getSituacao()));
            ps.setTimestamp(4, Timestamp.valueOf(funcionario.getDataAlteracao()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao gravar funcionário no banco de dados: " + ex.getMessage());
        }
    }

    public static Funcionario buscarFuncionarioPorId(int id) {
        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";
        Funcionario funcionario = null;

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            ps.setInt(1, id);

            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSituacao(rs.getString("situacao").charAt(0));
                funcionario.setDataAlteracao(rs.getTimestamp("data_alteracao").toLocalDateTime());
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar funcionário por ID: " + ex.getMessage());
        }
        return funcionario;
    }

    // Método para listar todos os funcionários
    public static List<Funcionario> listarFuncionarios() {
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Statement stmt = Conexao.getConexao().createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSituacao(rs.getString("situacao").charAt(0));
                funcionario.setDataAlteracao(rs.getTimestamp("data_alteracao").toLocalDateTime());
                funcionarios.add(funcionario);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao listar funcionários: " + ex.getMessage());
        }

        return funcionarios;
    }

    // Método para atualizar um funcionário
    public static void atualizarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, situacao = ?, data_alteracao = ? WHERE id_funcionario = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, String.valueOf(funcionario.getSituacao()));
            ps.setTimestamp(4, Timestamp.valueOf(funcionario.getDataAlteracao()));
            ps.setInt(5, funcionario.getId_funcionario());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar funcionário: " + ex.getMessage());
        }
    }

    /* Método para deletar um funcionário
    public static void deletarFuncionario(int id) {
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar funcionário: " + ex.getMessage());
        }
    }*/
}
