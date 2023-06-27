package br.ufscar.dc.dsw.domain;
import java.util.Date;

public class Cliente {

    private String CPF;
    private String sexo;
    private String email;
    private String nome;
    // Adicionar senha
    private String telefone;
    private Date data_nascimento;

    public Cliente(String CPF) {
        this.CPF = CPF;
    }

    public Cliente(String sexo, String email, String nome, String telefone, Date data_nascimento) {
        this.sexo = sexo;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
    }

    public Cliente(String CPF, String sexo, String email, String nome, String telefone, Date data_nascimento) {
        this.CPF = CPF;
        this.sexo = sexo;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
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

    public Date getDataNascimento() {
        return data_nascimento;
    }

    public void setDataNascimento(int ano, int mes, int dia) {
        this.data_nascimento = new Date(ano, mes, dia);
    }
}