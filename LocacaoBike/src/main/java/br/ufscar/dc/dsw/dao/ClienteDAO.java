package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Cliente;

public class ClienteDAO extends GenericDAO {

    public void insert(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (CPF, sexo, email, nome, telefone, data_nascimento) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getCPF());
            statement.setString(2, cliente.getSexo());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getNome());
            statement.setString(5, cliente.getTelefone());
            statement.setDate(6, cliente.getDataNascimento());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
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
                String telefone = resultSet.getString("telefone");
                java.sql.Date data_nascimento = resultSet.getDate("data_nascimento");
                Cliente cliente = new Cliente(CPF, sexo, email, nome, telefone, data_nascimento);
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
        String sql = "DELETE FROM CLIENTES where CPF = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cliente.getCPF());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Cliente cliente) {
        String sql = "UPDATE CLIENTE SET sexo = ?, email = ?, nome = ?, telefone = ?, data_nascimento = ? WHERE CPF = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cliente.getSexo());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getNome());
            statement.setString(4, cliente.getCPF());
            statement.setString(5, cliente.getSexo());
            statement.setDate(6, cliente.getDataNascimento());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
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
                String telefone = resultSet.getString("telefone");
                java.sql.Date data_nascimento = resultSet.getDate("data_nascimento");
                cliente = new Cliente(CPF, sexo, email, nome, telefone, data_nascimento);
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