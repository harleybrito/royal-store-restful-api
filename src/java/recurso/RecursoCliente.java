package recurso;

import beans.ClienteFilterBean;
import java.net.URI;
import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Encoded;
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
import modelo.Cliente;
import servico.ServicoCliente;

@Path("/cliente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RecursoCliente {
    
    ServicoCliente servicoCliente = new ServicoCliente();
    
    @GET
    public List<Cliente> getClientes(@BeanParam ClienteFilterBean filterBean){
        
        if(filterBean.getNome() != null){
            String clienteNome = filterBean.getNome();
            return servicoCliente.getClientePorNome(clienteNome);
        }
        
        if(filterBean.getComeco() >= 0 && filterBean.getTamanho() > 0){
            return servicoCliente.getTodosClientesPaginado(filterBean.getComeco(), filterBean.getTamanho());
        }
        
        return servicoCliente.getTodosClientes();
    }
        
    @GET
    @Path("/{clienteID}")
    public Cliente getCliente(@PathParam("clienteID") long id){
        return servicoCliente.getCliente(id);
    }
    
    @POST
    public Response addCliente(Cliente cliente, @Context UriInfo uriInfo){
        System.out.println(cliente.getEndereco());
        Cliente novoCliente = servicoCliente.addCliente(cliente);
        String newId = String.valueOf(novoCliente.getId());
        URI url = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(url).entity(novoCliente).build();
    }
    
    @PUT
    @Path("/{clienteID}")
    public Response updateCliente(@PathParam("clienteID") long id, Cliente cliente, @Context UriInfo uriInfo){
        cliente.setId(id);
        Cliente novoCliente = servicoCliente.updateCliente(cliente);
        return Response.created(uriInfo.getAbsolutePath()).entity(novoCliente).build();
    }
    
    @DELETE
    @Path("/{clienteID}")
    public void deleteCliente(@PathParam("clienteID") long id){
        servicoCliente.removeCliente(id);
    }
}
