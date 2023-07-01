package br.ufscar.dc.dsw.domain;

public class Cliente {

    private String CPF;
    private String sexo;
    private String email;
    private String nome;
    private String senha;
    private String telefone;
    private String data_nascimento;
    private String papel;

    public Cliente(String CPF) {
        this.CPF = CPF;
    }   

    public Cliente(String CPF, String sexo, String email, String nome, String senha,String telefone) {
        this.CPF = CPF;
        this.sexo = sexo;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.papel = "cliente";
    }

    public Cliente(String CPF, String sexo, String email, String nome, String senha,String telefone, String data_nascimento) {
        this.CPF = CPF;
        this.sexo = sexo;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
        this.papel = "cliente";
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

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return data_nascimento;
    }

    public void getDataNascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    
    public String getPapel()
    {
        return papel;
    }

    public void setPapel(String papel)
    {
        this.papel = papel;
    }
}