package br.ufscar.dc.dsw.domain;
import java.util.Date;

public class Locacao {

    private String CPF;
    private String CNPJ;
    private Date data_locacao;

    public Locacao(String CPF, String CNPJ) {
        this.CPF = CPF;
        this.CNPJ = CNPJ;
    }

    public Locacao(String CPF, String CNPJ, Date data_locacao) {
        this.CPF = CPF;
        this.CNPJ = CNPJ;
        this.data_locacao = data_locacao;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String cnpj) {
        this.CNPJ = cnpj;
    }

    public Date getDataLocacao() {
        return data_locacao;
    }

    public void setDataLocacao(int ano, int mes, int dia) {
        this.data_locacao = new Date(ano, mes, dia);
    }
}