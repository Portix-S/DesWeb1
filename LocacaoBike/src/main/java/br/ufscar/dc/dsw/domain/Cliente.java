package br.ufscar.dc.dsw.domain;
import br.ufscar.dc.dsw.domain.Usuario;

public class Cliente extends Usuario{
    private String CPF;
    private String sexo;
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
        super(nome, email, senha, "cliente");
        this.CPF = CPF;
        this.sexo = sexo;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
    }

    public Cliente(String CPF, String sexo, String email, String nome, String senha,String telefone, String data_nascimento, String papel) {
        super(nome, email, senha, papel);
        this.CPF = CPF;
        this.sexo = sexo;
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