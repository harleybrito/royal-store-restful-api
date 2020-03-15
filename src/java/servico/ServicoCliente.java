package servico;

import bancoDeDados.BancoDeDados;
import excecao.DataNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Cliente;

public class ServicoCliente {
    
    private Map<Long, Cliente> clientes = BancoDeDados.getClientes();
    
    public List<Cliente> getTodosClientes(){
        return new ArrayList<Cliente>(clientes.values());
    }
    
    public List<Cliente> getClientePorNome(String nome){
        List<Cliente> clientesPorNome = new ArrayList<Cliente>();
        String nomeDeCliente;
        
        for(Cliente cliente: clientes.values()){
            nomeDeCliente = cliente.getNome();
            
            if(nomeDeCliente.equals(nome)){
                clientesPorNome.add(cliente);
            }
        }
        return clientesPorNome;
    }
    
    public List<Cliente> getTodosClientesPaginado(int comeco, int tamanho){
        ArrayList<Cliente> lista = new ArrayList<>(clientes.values());
        
        if(comeco + tamanho > lista.size()){
            return new ArrayList<>();
        }
        
        return lista.subList(comeco, comeco + tamanho);
    }
    
    public Cliente getCliente(long id){
        Cliente cliente = clientes.get(id);
        
        if(cliente == null){
            throw new DataNotFoundException("Cliente com id{" + id + "} não encontrado.");
        }
        
        return cliente;
    }
    
    public Cliente addCliente(Cliente cliente){
        BancoDeDados.saveCliente(cliente);
        return cliente;
    }
    
    public Cliente updateCliente(Cliente cliente){
        if(cliente.getId() <= 0){
            return null;
        }
        
        BancoDeDados.updateCliente(cliente);
        return cliente;
    }
    
    public void removeCliente(long id){
        BancoDeDados.removeCliente(id);
    }
}
