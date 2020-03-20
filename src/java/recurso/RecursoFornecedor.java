package recurso;

import beans.ApiFilterBean;
import java.net.URI;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import modelo.Fornecedor;
import modelo.Funcionario;
import servico.ServicoFornecedor;

@Path("/fornecedor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RecursoFornecedor {
    
    ServicoFornecedor servicoFornecedor = new ServicoFornecedor();
    
    @GET
    public List<Fornecedor> getFornecedores(@BeanParam ApiFilterBean filterBean){
        
        if(filterBean.getNome() != null){
            String fornecedorNome = filterBean.getNome();
            return servicoFornecedor.getFornecedorPorNome(fornecedorNome);
        }
        
        if(filterBean.getComeco() >= 0 && filterBean.getTamanho() > 0){
            return servicoFornecedor.getTodosFornecedoresPaginado(filterBean.getComeco(), filterBean.getTamanho());
        }
        
        return servicoFornecedor.getTodosFornecedores();
    }
        
    @GET
    @Path("/{fornecedorID}")
    public Fornecedor getFornecedor(@PathParam("fornecedorID") long id){
        return servicoFornecedor.getFornecedor(id);
    }
    
    @POST
    public Response addFornecedor(Fornecedor fornecedor, @Context UriInfo uriInfo){
        Fornecedor novoFornecedor = servicoFornecedor.addFornecedor(fornecedor);
        String newId = String.valueOf(novoFornecedor.getId());
        URI url = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(url).entity(novoFornecedor).build();
    }
    
    @PUT
    @Path("/{fornecedorID}")
    public Response updateFornecedor(@PathParam("fornecedorID") long id, Fornecedor fornecedor, @Context UriInfo uriInfo){
        fornecedor.setId(id);
        Fornecedor novoFornecedor = servicoFornecedor.updateFornecedor(fornecedor);
        return Response.created(uriInfo.getAbsolutePath()).entity(novoFornecedor).build();
    }
    
    @DELETE
    @Path("/{fornecedorID}")
    public void deleteFornecedor(@PathParam("fornecedorID") long id){
        servicoFornecedor.removeFornecedor(id);
    }
}
