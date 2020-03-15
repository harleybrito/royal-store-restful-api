package modelo;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Produto {
    private long id;
    private String nome;
    private float precoDeCusto;
    private float margem;
    private float precoFinal;
    private int quantidade;
    private String codigoDeBarras;
    private String observacao;
    private long idFornecedor;
    private long idFormaDePagamento;
    private Map<Long, Produto> produtos = new HashMap<>();

    public Produto() {    }

    public Produto(long id, String nome, float precoDeCusto, float margem, float precoFinal, int quantidade, String codigoDeBarras, String observacao, long idFornecedor, long idFormaDePagamento) {
        this.id = id;
        this.nome = nome;
        this.precoDeCusto = precoDeCusto;
        this.margem = margem;
        this.precoFinal = precoFinal;
        this.quantidade = quantidade;
        this.codigoDeBarras = codigoDeBarras;
        this.observacao = observacao;
        this.idFornecedor = idFornecedor;
        this.idFormaDePagamento = idFormaDePagamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(float precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    public float getMargem() {
        return margem;
    }

    public void setMargem(float margem) {
        this.margem = margem;
    }

    public float getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(float precoFinal) {
        this.precoFinal = precoFinal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public long getIdFormaDePagamento() {
        return idFormaDePagamento;
    }

    public void setIdFormaDePagamento(long idFormaDePagamento) {
        this.idFormaDePagamento = idFormaDePagamento;
    }

    @XmlTransient
    public Map<Long, Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<Long, Produto> produtos) {
        this.produtos = produtos;
    }
}
