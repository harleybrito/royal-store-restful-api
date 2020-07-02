package modelo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class VendaCapa {
    private long id;
    private Date data;
    private long idFormaDePagamento;
    private long idCliente;
    private float valorTotal;
    private String status;
    private String preVenda;
    private String comanda;
    private long idFuncionario;
    private Map<Long, VendaCapa> vendasCapa = new HashMap<>();

    public VendaCapa() {    }

    public VendaCapa(long id, Date data, long idFormaDePagamento, long idCliente, float valorTotal, String status, String preVenda, String comanda, long idFuncionario) {
        this.id = id;
        this.data = data;
        this.idFormaDePagamento = idFormaDePagamento;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.status = status;
        this.preVenda = preVenda;
        this.comanda = comanda;
        this.idFuncionario = idFuncionario;
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

    public long getIdFormaDePagamento() {
        return idFormaDePagamento;
    }

    public void setIdFormaDePagamento(long idFormaDePagamento) {
        this.idFormaDePagamento = idFormaDePagamento;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPreVenda() {
        return preVenda;
    }

    public void setPreVenda(String preVenda) {
        this.preVenda = preVenda;
    }

    public String getComanda() {
        return comanda;
    }

    public void setComanda(String comanda) {
        this.comanda = comanda;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @XmlTransient
    public Map<Long, VendaCapa> getVendasCapa() {
        return vendasCapa;
    }

    public void setVendasCapa(Map<Long, VendaCapa> vendasCapa) {
        this.vendasCapa = vendasCapa;
    }
}
