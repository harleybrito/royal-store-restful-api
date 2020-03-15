package beans;

import javax.ws.rs.QueryParam;

public class ClienteFilterBean {
    private @QueryParam("nome") String nome;
    private @QueryParam("comeco") int comeco;
    private @QueryParam("tamanho") int tamanho;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getComeco() {
        return comeco;
    }

    public void setComeco(int comeco) {
        this.comeco = comeco;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
