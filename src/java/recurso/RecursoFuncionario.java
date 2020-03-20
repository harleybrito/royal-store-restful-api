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
import modelo.Funcionario;
import servico.ServicoFuncionario;

@Path("/funcionario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RecursoFuncionario {
    
    ServicoFuncionario servicoFuncionario = new ServicoFuncionario();
    
    @GET
    public List<Funcionario> getFuncionarios(@BeanParam ApiFilterBean filterBean){
        
        if(filterBean.getNome() != null){
            String funcionarioNome = filterBean.getNome();
            return servicoFuncionario.getFuncionarioPorNome(funcionarioNome);
        }
        
        if(filterBean.getComeco() >= 0 && filterBean.getTamanho() > 0){
            return servicoFuncionario.getTodosFuncionariosPaginado(filterBean.getComeco(), filterBean.getTamanho());
        }
        
        return servicoFuncionario.getTodosFuncionarios();
    }
        
    @GET
    @Path("/{funcionarioID}")
    public Funcionario getFuncionario(@PathParam("funcionarioID") long id){
        return servicoFuncionario.getFuncionario(id);
    }
    
    @POST
    public Response addFuncionario(Funcionario funcionario, @Context UriInfo uriInfo){
        System.out.println(funcionario.getEndereco());
        Funcionario novoFuncionario = servicoFuncionario.addFuncionario(funcionario);
        String newId = String.valueOf(novoFuncionario.getId());
        URI url = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(url).entity(novoFuncionario).build();
    }
    
    @PUT
    @Path("/{funcionarioID}")
    public Response updateFuncionario(@PathParam("funcionarioID") long id, Funcionario funcionario, @Context UriInfo uriInfo){
        funcionario.setId(id);
        Funcionario novoFuncionario = servicoFuncionario.updateFuncionario(funcionario);
        return Response.created(uriInfo.getAbsolutePath()).entity(novoFuncionario).build();
    }
    
    @DELETE
    @Path("/{funcionarioID}")
    public void deleteFuncionario(@PathParam("funcionarioID") long id){
        servicoFuncionario.removeFuncionario(id);
    }
}
