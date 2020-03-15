package modelo;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class VendaItens {
    private long id;
    private long idVendaCapa;
    private long idProduto;
    private int quantidade;
    private Map<Long, VendaItens> vendasItens = new HashMap<>();

    public VendaItens() {    }

    public VendaItens(long id, long idVendaCapa, long idProduto, int quantidade) {
        this.id = id;
        this.idVendaCapa = idVendaCapa;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdVendaCapa() {
        return idVendaCapa;
    }

    public void setIdVendaCapa(long idVendaCapa) {
        this.idVendaCapa = idVendaCapa;
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
    public Map<Long, VendaItens> getVendasItens() {
        return vendasItens;
    }

    public void setVendasItens(Map<Long, VendaItens> vendasItens) {
        this.vendasItens = vendasItens;
    }
}
