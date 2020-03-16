package servico;

import bancoDeDados.BancoDeDados;
import excecao.DataNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import modelo.Funcionario;

public class ServicoFuncionario {
    
    private Map<Long, Funcionario> funcionarios = BancoDeDados.getFuncionarios();
    
    public List<Funcionario> getTodosFuncionarios(){
        return new ArrayList<Funcionario>(funcionarios.values());
    }
    
    public List<Funcionario> getFuncionarioPorNome(String nome){
        List<Funcionario> funcionariosPorNome = new ArrayList<Funcionario>();
        String nomeDeFuncionario;
        
        for(Funcionario funcionario: funcionarios.values()){
            nomeDeFuncionario = funcionario.getNome();
            
            if(nomeDeFuncionario.equals(nome)){
                funcionariosPorNome.add(funcionario);
            }
        }
        return funcionariosPorNome;
    }
    
    public List<Funcionario> getTodosFuncionariosPaginado(int comeco, int tamanho){
        ArrayList<Funcionario> lista = new ArrayList<>(funcionarios.values());
        
        if(comeco + tamanho > lista.size()){
            return new ArrayList<>();
        }
        
        return lista.subList(comeco, comeco + tamanho);
    }
    
    public Funcionario getFuncionario(long id){
        Funcionario funcionario = funcionarios.get(id);
        
        if(funcionario == null){
            throw new DataNotFoundException("Funcionário com id{" + id + "} não encontrado.");
        }
        
        return funcionario;
    }
    
    public Funcionario addFuncionario(Funcionario funcionario){
        BancoDeDados.saveFuncionario(funcionario);
        return funcionario;
    }
    
    public Funcionario updateFuncionario(Funcionario funcionario){
        if(funcionario.getId() <= 0){
            return null;
        }
        
        BancoDeDados.updateFuncionario(funcionario);
        return funcionario;
    }
    
    public void removeFuncionario(long id){
        BancoDeDados.removeFuncionario(id);
    }
}
