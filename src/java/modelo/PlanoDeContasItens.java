package modelo;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class PlanoDeContasItens {
    private long id;
    private long idPlanoDeContasCapa;
    private long idProduto;
    private int quantidade;
    private Map<Long, PlanoDeContasItens> planoDeContasItens = new HashMap<>();

    public PlanoDeContasItens() {    }

    public PlanoDeContasItens(long id, long idPlanoDeContasCapa, long idProduto, int quantidade) {
        this.id = id;
        this.idPlanoDeContasCapa = idPlanoDeContasCapa;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPlanoDeContasCapa() {
        return idPlanoDeContasCapa;
    }

    public void setIdPlanoDeContasCapa(long idPlanoDeContasCapa) {
        this.idPlanoDeContasCapa = idPlanoDeContasCapa;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @XmlTransient
    public Map<Long, PlanoDeContasItens> getPlanoDeContasItens() {
        return planoDeContasItens;
    }

    public void setPlanoDeContasItens(Map<Long, PlanoDeContasItens> planoDeContasItens) {
        this.planoDeContasItens = planoDeContasItens;
    }
}
