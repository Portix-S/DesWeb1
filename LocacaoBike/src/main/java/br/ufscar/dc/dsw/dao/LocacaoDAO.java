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
        String sql = "INSERT INTO LOCACAO (CPF, CNPJ, data_locacao, hora_locacao, data_hora_locacao) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, locacao.getCPF());
            statement.setString(2, locacao.getCNPJ());
            statement.setString(3, locacao.getDataLocacao());
            statement.setString(4, locacao.getHorarioLocacao());
            statement.setString(5, locacao.getDataHoraLocacao());

            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao inserir locacao");
            throw new RuntimeException(e);
        }
    }

    public List<Locacao> getAll(String CPF) {

        List<Locacao> listaLocacoes = new ArrayList<>();
        String sql = "SELECT * from LOCACAO where CPF = ?";

        try {
            Connection conn = this.getConnection();
            //Statement statement = conn.createStatement();
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println(CPF + "procurando");
            statement.setString(1, CPF);
            ResultSet resultSet = statement.executeQuery();

            //ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String CNPJ = resultSet.getString("CNPJ");
                String data_locacao = resultSet.getString("data_locacao");
                String hora_locacao = resultSet.getString("hora_locacao");
                String data_hora_locacao = resultSet.getString("data_hora_locacao");
                Locacao locacao = new Locacao(id, CPF, CNPJ, data_locacao, hora_locacao, data_hora_locacao);
                listaLocacoes.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao pegar a lista");
            throw new RuntimeException(e);
        }
        return listaLocacoes;
    }

    public List<Locacao> getAllByCNPJ(String CNPJ) {

        List<Locacao> listaLocacoes = new ArrayList<>();
        String sql = "SELECT * from LOCACAO where CNPJ = ?";

        try {
            Connection conn = this.getConnection();
            //Statement statement = conn.createStatement();
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println(CNPJ + "procurando");
            statement.setString(1, CNPJ);
            ResultSet resultSet = statement.executeQuery();

            //ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String CPF = resultSet.getString("CPF");
                String data_locacao = resultSet.getString("data_locacao");
                String hora_locacao = resultSet.getString("hora_locacao");
                String data_hora_locacao = resultSet.getString("data_hora_locacao");
                Locacao locacao = new Locacao(id, CPF, CNPJ, data_locacao, hora_locacao, data_hora_locacao);
                listaLocacoes.add(locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao pegar a lista");
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
        String sql = "UPDATE LOCACAO SET data_locacao = ?, hora_locacao = ? WHERE id = ?";

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
                String hora_locacao = resultSet.getString("hora_locacao");
                String data_hora_locacao = resultSet.getString("data_hora_locacao");
                locacao = new Locacao(id, CPF, CNPJ, data_locacao, hora_locacao, data_hora_locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return locacao;
    }

    public Locacao getByCNPJ(String CNPJ) {
        Locacao locacao = null;   
        String sql = "SELECT * from LOCACAO where CNPJ = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, CNPJ);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String CPF = resultSet.getString("CPF");
                Long id = resultSet.getLong("id");
                String data_locacao = resultSet.getString("data_locacao");
                String horario_locacao = resultSet.getString("hora_locacao");
                String data_hora_locacao = resultSet.getString("data_hora_locacao");
                locacao = new Locacao(id, CPF, CNPJ, data_locacao, horario_locacao, data_hora_locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     return locacao;
    }

    public Locacao getByDataHora(String CPF, String CNPJ, String data_horario_locacao) {
        Locacao locacao = null;   
        String sql = "SELECT * from LOCACAO where CPF = ? and CNPJ = ? and data_hora_locacao = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, CPF);
            statement.setString(2, CNPJ);
            statement.setString(3, data_horario_locacao);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String data_locacao = resultSet.getString("data_locacao");
                String hora_locacao = resultSet.getString("hora_locacao");
                locacao = new Locacao(CPF, CNPJ, data_locacao, hora_locacao, data_horario_locacao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Nao esta pegando o objeto");
            throw new RuntimeException(e);
        }
     return locacao;
    }
}