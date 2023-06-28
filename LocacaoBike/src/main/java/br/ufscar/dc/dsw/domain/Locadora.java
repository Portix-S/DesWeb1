package br.ufscar.dc.dsw.domain;

public class Locadora {
    private String CNPJ;
    private String cidade;
    private String email;
    private String nome;
    private String senha;
    private String papel;

    public Locadora(String CNPJ) {
        this.CNPJ = CNPJ;
        this.papel = "locadora";
    }

    public Locadora(String CNPJ, String cidade, String email, String nome, String senha) {
        this.CNPJ = CNPJ;
        this.cidade = cidade;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.papel = "locadora";
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public String getPapel()
    {
        return papel;
    }

    public void setPapel(String papel)
    {
        this.papel = papel;
    }
}