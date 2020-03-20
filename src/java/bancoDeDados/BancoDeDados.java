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

    public static Map<Long, Cliente> getClientes(){
        Map<Long, Cliente> clientes = new HashMap<>();
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("select * from cliente");
            ResultSet data = statement.executeQuery();

            while(data.next()){
                Cliente cliente = new Cliente();
                cliente.setId(data.getLong(1));
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
                Funcionario funcionario = new Funcionario   (data.getLong(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), 
                                                             data.getString(7), data.getString(8), data.getString(9), data.getString(10), data.getString(11), 
                                                             data.getString(12), data.getFloat(13));
                funcionarios.put(funcionario.getId(), funcionario);
            }
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return funcionarios;
    }
    
    public static Map<Long, Fornecedor> getFornecedores(){
        
        Map<Long, Fornecedor> fornecedores = new HashMap<>();
        
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("select * from fornecedor");
            ResultSet data = statement.executeQuery();

            while(data.next()){
                Fornecedor fornecedor = new Fornecedor  (data.getLong(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getString(6), 
                                                         data.getString(7), data.getString(8), data.getString(9), data.getLong(10));
                fornecedores.put(fornecedor.getId(), fornecedor);
            }
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return fornecedores;
    }
    
    public static Map<Long, Produto> getProdutos(){
        
        Map<Long, Produto> produtos = new HashMap<>();
        
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("select * from produto");
            ResultSet data = statement.executeQuery();

            while(data.next()){
                Produto produto = new Produto   (data.getInt(1), data.getString(2), data.getFloat(3), data.getFloat(4), data.getFloat(5), data.getInt(6), data.getString(7), 
                                                 data.getString(8), data.getInt(9), data.getInt(10));
                produtos.put(produto.getId(), produto);
            }
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return produtos;
    }
    
    public static void saveCliente(Cliente cliente){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement   ("INSERT INTO cliente "
                                                                                + "(nome, cpf, rg, endereco, complemento, cidade, estado, cep, telefone) "
                                                                                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
            PreparedStatement statement = databaseConnection.prepareStatement   ("insert into funcionario "
                                                                                + "(nome, usuario, senha, cpf, rg, telefone, endereco, complemento, cidade, estado, cep, salario)"
                                                                                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
    
    public static void saveFornecedor(Fornecedor fornecedor){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement   ("insert into fornecedor "
                                                                                + "(nome, cnpj, endereco, cidade, estado, complemento, cep, telefone, idForma_Pagamento) "
                                                                                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, fornecedor.getNome());
            statement.setString(2, fornecedor.getCnpj());
            statement.setString(3, fornecedor.getEndereco());
            statement.setString(4, fornecedor.getCidade());
            statement.setString(5, fornecedor.getEstado());
            statement.setString(6, fornecedor.getComplemento());
            statement.setString(7, fornecedor.getCep());
            statement.setString(8, fornecedor.getCelular());
            statement.setLong(9, fornecedor.getIdFormaDePagamento());
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void saveProduto(Produto produto){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement   ("insert into produto "
                                                                                + "(nome, preco_custo, margem, preco_final, quantidade, codigo_barras, observacao, "
                                                                                + "idFornecedor, idForma_Pagamento) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, produto.getNome());
            statement.setFloat(2, produto.getPrecoDeCusto());
            statement.setFloat(3, produto.getMargem());
            statement.setFloat(4, produto.getPrecoFinal());
            statement.setInt(5, produto.getQuantidade());
            statement.setString(6, produto.getCodigoDeBarras());
            statement.setString(7, produto.getObservacao());
            statement.setLong(8, produto.getIdFornecedor());
            statement.setLong(9, produto.getIdFormaDePagamento());
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateCliente(Cliente cliente){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement   ("UPDATE cliente SET "
                                                                                + "nome = ?, cpf = ?, rg = ?, endereco = ?, complemento = ?, cidade = ?, estado = ?, "
                                                                                + "cep = ?, telefone = ? where idCliente = ?");
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
            PreparedStatement statement = databaseConnection.prepareStatement   ("UPDATE funcionario "
                                                                                + "SET nome = ?, usuario = ?, senha = ?, cpf = ?, rg = ?, telefone = ?,endereco = ?, "
                                                                                + "complemento = ?, cidade = ?, estado = ?, cep = ?, salario = ? where idFuncionario = ?");
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
    
    public static void updateFornecedor(Fornecedor fornecedor){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement   ("UPDATE fornecedor SET "
                                                                                + "nome = ?, cnpj = ?, endereco = ?, cidade = ?, estado = ?, complemento = ?, cep = ?, "
                                                                                + "telefone = ?, idForma_Pagamento = ? where idFornecedor = ?");
            statement.setString(1, fornecedor.getNome());
            statement.setString(2, fornecedor.getCnpj());
            statement.setString(3, fornecedor.getEndereco());
            statement.setString(4, fornecedor.getCidade());
            statement.setString(5, fornecedor.getEstado());
            statement.setString(6, fornecedor.getComplemento());
            statement.setString(7, fornecedor.getCep());
            statement.setString(8, fornecedor.getCelular());
            statement.setLong(9, fornecedor.getIdFormaDePagamento());
            statement.setLong(10, fornecedor.getId());
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void updateProduto(Produto produto){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement   ("UPDATE produto SET "
                                                                                + "nome = ?, preco_custo = ?, margem = ?, preco_final = ?, "
                                                                                + "quantidade = ?, codigo_barras = ?, observacao = ?, idFornecedor = ?, "
                                                                                + "idForma_Pagamento = ? where idProduto = ?");
            statement.setString(1, produto.getNome());
            statement.setFloat(2, produto.getPrecoDeCusto());
            statement.setFloat(3, produto.getMargem());
            statement.setFloat(4, produto.getPrecoFinal());
            statement.setInt(5, produto.getQuantidade());
            statement.setString(6, produto.getCodigoDeBarras());
            statement.setString(7, produto.getObservacao());
            statement.setLong(8, produto.getIdFornecedor());
            statement.setLong(9, produto.getIdFormaDePagamento());
            statement.setLong(10, produto.getId());
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
    
    public static void removeFornecedor(long id){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("DELETE FROM fornecedor WHERE idFornecedor = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void removeProduto(long id){
        try{
            Connection databaseConnection = ConnectionDB.Connect();
            PreparedStatement statement = databaseConnection.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
            databaseConnection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
