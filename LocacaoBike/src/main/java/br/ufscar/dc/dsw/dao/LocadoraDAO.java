package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.UsuarioDAO;

public class LocadoraDAO extends GenericDAO {

    public void insert(Locadora locadora) {
        String sql = "INSERT INTO LOCADORA (CNPJ, cidade, email, nome) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, locadora.getCNPJ());
            statement.setString(2, locadora.getCidade());
            statement.setString(3, locadora.getEmail());
            statement.setString(4, locadora.getNome());

            // Usuario usuario = new Usuario()
            // Inserir no dao
            // Colocar senha e atualizar no DAO do usuário
            // Lembrar de atualizar no Cliente DAO quanto der pull
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Locadora> getAll() {

        List<Locadora> listaLocadoras = new ArrayList<>();
        String sql = "SELECT * from LOCADORA";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String CNPJ = resultSet.getString("CNPJ");
                String cidade = resultSet.getString("cidade");
                String email = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                Locadora locadora = new Locadora(CNPJ, cidade, email, nome);
                listaLocadoras.add(locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocadoras;
    }

    public void delete(Locadora locadora) {
        String sql = "DELETE FROM LOCADORA where CNPJ = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locadora.getCNPJ());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Locadora locadora) {
        String sql = "UPDATE LOCADORA SET cidade = ?, email = ?, nome = ? WHERE CNPJ = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locadora.getCidade());
            statement.setString(2, locadora.getEmail());
            statement.setString(3, locadora.getNome());
            statement.setString(4, locadora.getCNPJ());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Locadora get(String CNPJ) {
        Locadora locadora = null;   
        String sql = "SELECT * from LOCADORA where CNPJ = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, CNPJ);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String cidade = resultSet.getString("cidade");
                String email = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                locadora = new Locadora(CNPJ, cidade, email, nome);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return locadora;
    }
}