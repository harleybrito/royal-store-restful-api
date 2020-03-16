package bancoDeDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import modelo.Cliente;
import modelo.Fornecedor;
import modelo.Funcionario;
import modelo.PlanoDeContasCapa;
import modelo.PlanoDeContasItens;
import modelo.Produto;
import modelo.VendaCapa;
import modelo.VendaItens;

public class BancoDeDados {
    private static final Map<Long, Fornecedor> fornecedores = new HashMap<>();
    private static final Map<Long, Funcionario> funcionarios = new HashMap<>();
    private static final Map<Long, PlanoDeContasCapa> planoDeContasCapa = new HashMap<>();
    private static final Map<Long, PlanoDeContasItens> planoDeContasItens = new HashMap<>();
    private static final Map<Long, Produto> produtos = new HashMap<>();
    private static final Map<Long, VendaCapa> vendaCapa = new HashMap<>();
    private static final Map<Long, VendaItens> vendaItens = new HashMap<>();      

    public static Map<Long, Cliente> getClientes(){
        Map<Long, Cliente> clientes = new HashMap<>();
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("select * from cliente");
            ResultSet data = statement.executeQuery();

            while(data.next()){
                Cliente cliente = new Cliente();
                cliente.setId(data.getInt(1));
                cliente.setNome(data.getString(2));
                cliente.setCpf(data.getString(3));
                cliente.setRg(data.getString(4));
                cliente.setEndereco(data.getString(5));
                cliente.setComplemento(data.getString(6));
                cliente.setCidade(data.getString(7));
                cliente.setEstado(data.getString(8));
                cliente.setCep(data.getString(9));
                cliente.setCelular(data.getString(10));
                clientes.put(cliente.getId(), cliente);
            }
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return clientes;
    }
    
    public static Map<Long, Funcionario> getFuncionarios(){
        Map<Long, Funcionario> funcionarios = new HashMap<>();
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("select * from funcionario");
            ResultSet data = statement.executeQuery();

            while(data.next()){
                Funcionario funcionario = new Funcionario(data.getInt(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), data.getString(7), data.getString(8), data.getString(9), data.getString(10), data.getString(11), data.getString(12), data.getFloat(13));
                funcionarios.put(funcionario.getId(), funcionario);
            }
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return funcionarios;
    }
    
    public static void saveCliente(Cliente cliente){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("INSERT INTO cliente (nome, cpf, rg, endereco, complemento, cidade, estado, cep, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getRg());
            statement.setString(4, cliente.getEndereco());
            statement.setString(5, cliente.getComplemento());
            statement.setString(6, cliente.getCidade());
            statement.setString(7, cliente.getEstado());
            statement.setString(8, cliente.getCep());
            statement.setString(9, cliente.getCelular());
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void saveFuncionario(Funcionario funcionario){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("insert into funcionario (nome, usuario, senha, cpf, rg, telefone, endereco, complemento, cidade, estado, cep, salario) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getUsuario());
            statement.setString(3, funcionario.getSenha());
            statement.setString(4, funcionario.getCpf());
            statement.setString(5, funcionario.getRg());
            statement.setString(6, funcionario.getCelular());
            statement.setString(7, funcionario.getEndereco());
            statement.setString(8, funcionario.getComplemento());
            statement.setString(9, funcionario.getCidade());
            statement.setString(10, funcionario.getEstado());
            statement.setString(11, funcionario.getCep());
            statement.setFloat(12, funcionario.getSalario());
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateCliente(Cliente cliente){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, rg = ?, endereco = ?, complemento = ?, cidade = ?, estado = ?, cep = ?, telefone = ? where idCliente = ?");
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getRg());
            statement.setString(4, cliente.getEndereco());
            statement.setString(5, cliente.getComplemento());
            statement.setString(6, cliente.getCidade());
            statement.setString(7, cliente.getEstado());
            statement.setString(8, cliente.getCep());
            statement.setString(9, cliente.getCelular());
            statement.setLong(10, cliente.getId());
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateFuncionario(Funcionario funcionario){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("UPDATE funcionario SET nome = ?, usuario = ?, senha = ?, cpf = ?, rg = ?, telefone = ?,endereco = ?, complemento = ?, cidade = ?, estado = ?, cep = ?, salario = ? where idFuncionario = ?");
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getUsuario());
            statement.setString(3, funcionario.getSenha());
            statement.setString(4, funcionario.getCpf());
            statement.setString(5, funcionario.getRg());
            statement.setString(6, funcionario.getCelular());
            statement.setString(7, funcionario.getEndereco());
            statement.setString(8, funcionario.getComplemento());
            statement.setString(9, funcionario.getCidade());
            statement.setString(10, funcionario.getEstado());
            statement.setString(11, funcionario.getCep());
            statement.setFloat(12, funcionario.getSalario());
            statement.setLong(13, funcionario.getId());
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void removeCliente(long id){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void removeFuncionario(long id){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("DELETE FROM funcionario WHERE idFuncionario = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Map<Long, Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public static Map<Long, PlanoDeContasCapa> getPlanoDeContasCapa() {
        return planoDeContasCapa;
    }

    public static Map<Long, PlanoDeContasItens> getPlanoDeContasItens() {
        return planoDeContasItens;
    }

    public static Map<Long, Produto> getProdutos() {
        return produtos;
    }

    public static Map<Long, VendaCapa> getVendaCapa() {
        return vendaCapa;
    }

    public static Map<Long, VendaItens> getVendaItens() {
        return vendaItens;
    }
}
