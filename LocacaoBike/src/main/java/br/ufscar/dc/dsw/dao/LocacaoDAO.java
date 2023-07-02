package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Locacao;

public class LocacaoDAO extends GenericDAO {

    // private UsuarioDAO dao;

    // public void init() {
    //     dao = new UsuarioDAO();
    // }

    public void insert(Locacao locacao) {
        String sql = "INSERT INTO LOCADORA (CPF, CNPJ, data_locacao, horario_locacao) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, locacao.getCPF());
            statement.setString(1, locacao.getCPF());
            statement.setString(2, locacao.getCNPJ());
            statement.setString(3, locacao.getDataLocacao());
            statement.setString(4, locacao.getHorarioLocacao());

            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao inserir locacao");
            throw new RuntimeException(e);
        }
    }

    public List<Locacao> getAll() {

        List<Locacao> listaLocacoes = new ArrayList<>();
        String sql = "SELECT * from LOCACAO";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String CPF = resultSet.getString("CPF");
                String CNPJ = resultSet.getString("CNPJ");
                String data_locacao = resultSet.getString("data_locacao");
                String horario_locacao = resultSet.getString("horario_locacao");
                Locacao locacao = new Locacao(id, CPF, CNPJ, data_locacao, horario_locacao);
                listaLocacoes.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLocacoes;
    }

    public void delete(Locacao locacao) {
        String sql = "DELETE FROM LOCACOES where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, locacao.getID());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao remover locacao");
            throw new RuntimeException(e);
        }
    }

    public void update(Locacao locacao) {
        String sql = "UPDATE LOCACAO SET data_locacao = ?, horario_locacao = ? WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, locacao.getDataLocacao());
            statement.setString(2, locacao.getHorarioLocacao());
            statement.setLong(2, locacao.getID());
            
            statement.executeUpdate();
            statement.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao atualizar locacao");
            throw new RuntimeException(e);
        }
    }

    public Locacao get(Long id) {
        Locacao locacao = null;   
        String sql = "SELECT * from LOCACAO where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String CPF = resultSet.getString("CPF");
                String CNPJ = resultSet.getString("CNPJ");
                String data_locacao = resultSet.getString("data_locacao");
                String horario_locacao = resultSet.getString("horario_locacao");
                locacao = new Locacao(id, CPF, CNPJ, data_locacao, horario_locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return locacao;
    }
}