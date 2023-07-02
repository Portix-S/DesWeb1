package br.ufscar.dc.dsw.domain;
import java.util.Date;

public class Locacao {

    private Long id;
    private String CPF;
    private String CNPJ;
    private String data_locacao;
    private String horario_locacao;

    public Locacao(Long id) {
        this.id = id;
    }

    public Locacao(Long id, String CPF, String CNPJ, String data_locacao, String horario_locacao) {
        this.id = id;
        this.CPF = CPF;
        this.CNPJ = CNPJ;
        this.data_locacao = data_locacao;
        this.horario_locacao = horario_locacao;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
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

    public String getDataLocacao() {
        return data_locacao;
    }

    public void setDataLocacao(String data_locacao) {
        this.data_locacao = data_locacao;
    }

    public String getHorarioLocacao() {
        return horario_locacao;
    }

    public void setHorarioLocacao(String horario_locacao) {
        this.horario_locacao = horario_locacao;
    }
}