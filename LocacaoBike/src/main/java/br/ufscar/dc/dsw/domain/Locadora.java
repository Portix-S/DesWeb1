package br.ufscar.dc.dsw.domain;

public class Locadora extends Usuario{
    private String CNPJ;
    private String cidade;

    public Locadora(String CNPJ)
    {
        this.CNPJ = CNPJ;
    }

    public Locadora(String CNPJ, String cidade, String email, String nome, String senha) {
        super(nome, email, senha, "locadora");
        this.CNPJ = CNPJ;
        this.cidade = cidade;
    }

    public Locadora(String CNPJ, String cidade, String email, String nome, String senha, String papel) {
        super(nome, email, senha, papel);
        this.CNPJ = CNPJ;
        this.cidade = cidade;
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
}