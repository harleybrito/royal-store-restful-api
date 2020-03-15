package modelo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class PlanoDeContasCapa {
    private long id;
    private Date data;
    private char entrada;
    private long idFormaDePagamento;
    private char situacao;
    private float valorTotal;
    private String observacao;
    private String titulo;
    private Map<Long, PlanoDeContasCapa> planoDeContasCapa = new HashMap<>();

    public PlanoDeContasCapa() {    }

    public PlanoDeContasCapa(long id, Date data, char entrada, long idFormaDePagamento, char situacao, float valorTotal, String observacao, String titulo) {
        this.id = id;
        this.data = data;
        this.entrada = entrada;
        this.idFormaDePagamento = idFormaDePagamento;
        this.situacao = situacao;
        this.valorTotal = valorTotal;
        this.observacao = observacao;
        this.titulo = titulo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public char getEntrada() {
        return entrada;
    }

    public void setEntrada(char entrada) {
        this.entrada = entrada;
    }

    public long getIdFormaDePagamento() {
        return idFormaDePagamento;
    }

    public void setIdFormaDePagamento(long idFormaDePagamento) {
        this.idFormaDePagamento = idFormaDePagamento;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlTransient
    public Map<Long, PlanoDeContasCapa> getPlanoDeContasCapa() {
        return planoDeContasCapa;
    }

    public void setPlanoDeContasCapa(Map<Long, PlanoDeContasCapa> planoDeContasCapa) {
        this.planoDeContasCapa = planoDeContasCapa;
    }
}
