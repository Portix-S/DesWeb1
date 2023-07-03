package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.UsuarioDAO;

public class ClienteDAO extends GenericDAO {

    // private UsuarioDAO dao;

    // public void init() {
    //     dao = new UsuarioDAO();
    // }

    public void insert(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (CPF, sexo, email, nome, senha, telefone, data_nascimento, papel) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getCPF());
            statement.setString(2, cliente.getSexo());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getNome());
            statement.setString(5, cliente.getSenha());
            statement.setString(6, cliente.getTelefone());
            statement.setString(7, cliente.getDataNascimento());
            statement.setString(8, cliente.getPapel());
            System.out.println(cliente.getPapel());

            //Usuario usuario = new Usuario(cliente.getNome(), cliente.getEmail(), cliente.getSenha(), cliente.getPapel());

            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao inserir cliente");
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getAll() {

        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * from CLIENTE";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String CPF = resultSet.getString("CPF");
                String sexo = resultSet.getString("sexo");
                String email = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String telefone = resultSet.getString("telefone");
                String data_nascimento = resultSet.getString("data_nascimento");
                String papel = resultSet.getString("papel");
                Cliente cliente = new Cliente(CPF, sexo, email, nome, senha, telefone, data_nascimento, papel);
                listaClientes.add(cliente);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;
    }

    public void delete(Cliente cliente) {
        String sql = "DELETE FROM CLIENTE where CPF = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            //dao.delete(cliente.getEmail());

            statement.setString(1, cliente.getCPF());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao remover cliente");
            throw new RuntimeException(e);
        }
    }

    public void update(Cliente cliente) {
        String sql = "UPDATE CLIENTE SET sexo = ?, email = ?, nome = ?, senha = ?, telefone = ?, data_nascimento = ?, papel = ? WHERE CPF = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cliente.getSexo());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getNome());
            statement.setString(4, cliente.getSenha());
            statement.setString(5, cliente.getTelefone());
            statement.setString(6, cliente.getDataNascimento());
            statement.setString(7, cliente.getPapel());
            statement.setString(8, cliente.getCPF());

            
            statement.executeUpdate();
            statement.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao atualizar cliente");
            throw new RuntimeException(e);
        }
    }

    public Cliente get(String CPF) {
        Cliente cliente = null;   
        String sql = "SELECT * from CLIENTE where CPF = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, CPF);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String sexo = resultSet.getString("sexo");
                String email = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String telefone = resultSet.getString("telefone");
                String data_nascimento = resultSet.getString("data_nascimento");
                cliente = new Cliente(CPF, sexo, email, nome, senha, telefone, data_nascimento);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return cliente;
    }

    public Cliente getByEmail(String email) {
        Cliente cliente = null;   
        String sql = "SELECT * from CLIENTE where email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String sexo = resultSet.getString("sexo");
                String CPF = resultSet.getString("CPF");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String telefone = resultSet.getString("telefone");
                String data_nascimento = resultSet.getString("data_nascimento");
                System.out.println("CPF " + resultSet.getString("CPF"));
                System.out.println("email " + email);
                System.out.println("sennha " + senha);

                cliente = new Cliente(CPF, sexo, email, nome, senha, telefone, data_nascimento);
            }

            resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return cliente;
    }
}