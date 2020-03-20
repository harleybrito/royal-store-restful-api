package servico;

import bancoDeDados.BancoDeDados;
import excecao.DataNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Fornecedor;

public class ServicoFornecedor {
    
    private Map<Long, Fornecedor> fornecedores = BancoDeDados.getFornecedores();
    
    public List<Fornecedor> getTodosFornecedores(){
        return new ArrayList<Fornecedor>(fornecedores.values());
    }
    
    public List<Fornecedor> getFornecedorPorNome(String nome){
        List<Fornecedor> fornecedoresPorNome = new ArrayList<Fornecedor>();
        String nomeDeFornecedor;
        
        for(Fornecedor fornecedor: fornecedores.values()){
            nomeDeFornecedor = fornecedor.getNome();
            
            if(nomeDeFornecedor.equals(nome)){
                fornecedoresPorNome.add(fornecedor);
            }
        }
        return fornecedoresPorNome;
    }
    
    public List<Fornecedor> getTodosFornecedoresPaginado(int comeco, int tamanho){
        ArrayList<Fornecedor> lista = new ArrayList<>(fornecedores.values());
        
        if(comeco + tamanho > lista.size()){
            return new ArrayList<>();
        }
        
        return lista.subList(comeco, comeco + tamanho);
    }
    
    public Fornecedor getFornecedor(long id){
        Fornecedor fornecedor = fornecedores.get(id);
        
        if(fornecedor == null){
            throw new DataNotFoundException("Fornecedor com id{" + id + "} não encontrado.");
        }
        
        return fornecedor;
    }
    
    public Fornecedor addFornecedor(Fornecedor fornecedor){
        BancoDeDados.saveFornecedor(fornecedor);
        return fornecedor;
    }
    
    public Fornecedor updateFornecedor(Fornecedor fornecedor){
        if(fornecedor.getId() <= 0){
            return null;
        }
        
        BancoDeDados.updateFornecedor(fornecedor);
        return fornecedor;
    }
    
    public void removeFornecedor(long id){
        BancoDeDados.removeFornecedor(id);
    }
}