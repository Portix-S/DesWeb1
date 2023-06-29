package br.ufscar.dc.dsw.domain;
import java.util.Date;

public class Cliente {

    private String CPF;
    private String sexo;
    private String email;
    private String nome;
    // Adicionar senha
    private String telefone;
    private String datanascimento;

    public Cliente(String CPF) {
        this.CPF = CPF;
    }

    public Cliente(String CPF, String sexo, String email, String nome, String telefone, String datanascimento) {
        this.CPF = CPF;
        this.sexo = sexo;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.datanascimento = datanascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return datanascimento;
    }

    public void setDataNascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }
}