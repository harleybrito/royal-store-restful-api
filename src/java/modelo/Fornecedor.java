package modelo;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Fornecedor {
    private long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String cidade;
    private String estado;
    private String complemento;
    private String cep;
    private String celular;
    private long idFormaDePagamento;
    private Map<Long, Fornecedor> fornecedores = new HashMap<>();

    public Fornecedor() {    }

    public Fornecedor(long id, String nome, String cnpj, String endereco, String cidade, String estado, String complemento, String cep, String celular, long idFormaDePagamento) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
        this.cep = cep;
        this.celular = celular;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public long getIdFormaDePagamento() {
        return idFormaDePagamento;
    }

    public void setIdFormaDePagamento(long idFormaDePagamento) {
        this.idFormaDePagamento = idFormaDePagamento;
    }

    @XmlTransient
    public Map<Long, Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Map<Long, Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }
}
