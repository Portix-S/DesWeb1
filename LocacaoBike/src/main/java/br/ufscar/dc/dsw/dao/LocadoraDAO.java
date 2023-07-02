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

public class LocadoraDAO extends GenericDAO {
    
    //private UsuarioDAO dao;

    //public void init() {
        //dao = new UsuarioDAO();
    //}

    public void insert(Locadora locadora) {
        String sql = "INSERT INTO LOCADORA (CNPJ, cidade, email, nome, senha, papel) VALUES (?, ?, ?, ?, ?, ?)";


        try {
            //Usuario usuario = new Usuario(locadora.getNome(), locadora.getEmail(), locadora.getSenha(), locadora.getPapel());
            //dao.insert(usuario);

            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement = conn.prepareStatement(sql);
            statement.setString(1, locadora.getCNPJ());
            statement.setString(2, locadora.getCidade());
            statement.setString(3, locadora.getEmail());
            statement.setString(4, locadora.getNome());
            statement.setString(5, locadora.getSenha());
            statement.setString(6, locadora.getPapel());

            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao inserir locadora");
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
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                Locadora locadora = new Locadora(CNPJ, cidade, email, nome, senha, papel);
                listaLocadoras.add(locadora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao pegar a lista");
            System.out.println(e);

            throw new RuntimeException(e);
        }
        return listaLocadoras;
    }

    public void delete(Locadora locadora) {
        String sql = "DELETE FROM LOCADORA where CNPJ = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            UsuarioDAO dao = new UsuarioDAO();
            dao.delete(locadora.getEmail());

            statement.setString(1, locadora.getCNPJ());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao remover locadora");
            throw new RuntimeException(e);
        }
    }

    public void update(Locadora locadora) {
        String sql = "UPDATE LOCADORA SET cidade = ?, email = ?, nome = ?, senha = ? WHERE CNPJ = ?";

        try {
            //Usuario usuario = new Usuario(locadora.getNome(), locadora.getEmail(), locadora.getSenha(), locadora.getPapel());
            //dao.update(usuario);

            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, locadora.getCidade());
            statement.setString(2, locadora.getEmail());
            statement.setString(3, locadora.getNome());
            statement.setString(4, locadora.getSenha());
            statement.setString(5, locadora.getCNPJ());

            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao atualizar locadora");
            throw new RuntimeException(e);
        }
    }

    public Locadora get(String CNPJ) {
        Locadora locadora = null;   
        String sql = "SELECT * from LOCADORA where CNPJ = ?";
        ResultSet resultSet = null;
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, CNPJ);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String cidade = resultSet.getString("cidade");
                String email = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                locadora = new Locadora(CNPJ, cidade, email, nome, senha, papel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(resultSet);
            System.out.println("Erro ao procurar locadora");
            throw new RuntimeException(e);
        }
     return locadora;
    }
}