package servico;

import bancoDeDados.BancoDeDados;
import excecao.DataNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Produto;

public class ServicoProduto {
    
    private Map<Long, Produto> produtos = BancoDeDados.getProdutos();
    
    public List<Produto> getTodosProdutos(){
        return new ArrayList<Produto>(produtos.values());
    }
    
    public List<Produto> getProdutoPorNome(String nome){
        List<Produto> produtosPorNome = new ArrayList<Produto>();
        String nomeDeProduto;
        
        for(Produto produto: produtos.values()){
            nomeDeProduto = produto.getNome();
            
            if(nomeDeProduto.equals(nome)){
                produtosPorNome.add(produto);
            }
        }
        return produtosPorNome;
    }
    
    public List<Produto> getTodosProdutosPaginado(int comeco, int tamanho){
        ArrayList<Produto> lista = new ArrayList<>(produtos.values());
        
        if(comeco + tamanho > lista.size()){
            return new ArrayList<>();
        }
        
        return lista.subList(comeco, comeco + tamanho);
    }
    
    public Produto getProduto(long id){
        Produto produto = produtos.get(id);
        
        if(produto == null){
            throw new DataNotFoundException("Produto com id{" + id + "} não encontrado.");
        }
        
        return produto;
    }
    
    public Produto addProduto(Produto produto){
        BancoDeDados.saveProduto(produto);
        return produto;
    }
    
    public Produto updateProduto(Produto produto){
        if(produto.getId() <= 0){
            return null;
        }
        
        BancoDeDados.updateProduto(produto);
        return produto;
    }
    
    public void removeProduto(long id){
        BancoDeDados.removeProduto(id);
    }
}
