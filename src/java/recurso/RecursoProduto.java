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
import modelo.Produto;
import servico.ServicoProduto;

@Path("/produto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RecursoProduto {
    
    ServicoProduto servicoProduto = new ServicoProduto();
    
    @GET
    public List<Produto> getProdutos(@BeanParam ApiFilterBean filterBean){
        
        if(filterBean.getNome() != null){
            String produtoNome = filterBean.getNome();
            return servicoProduto.getProdutoPorNome(produtoNome);
        }
        
        if(filterBean.getComeco() >= 0 && filterBean.getTamanho() > 0){
            return servicoProduto.getTodosProdutosPaginado(filterBean.getComeco(), filterBean.getTamanho());
        }
        
        return servicoProduto.getTodosProdutos();
    }
        
    @GET
    @Path("/{produtoID}")
    public Produto getProduto(@PathParam("produtoID") long id){
        return servicoProduto.getProduto(id);
    }
    
    @POST
    public Response addProduto(Produto produto, @Context UriInfo uriInfo){
        Produto novoProduto = servicoProduto.addProduto(produto);
        String newId = String.valueOf(novoProduto.getId());
        URI url = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(url).entity(novoProduto).build();
    }
    
    @PUT
    @Path("/{produtoID}")
    public Response updateProduto(@PathParam("produtoID") long id, Produto produto, @Context UriInfo uriInfo){
        produto.setId(id);
        Produto novoProduto = servicoProduto.updateProduto(produto);
        return Response.created(uriInfo.getAbsolutePath()).entity(novoProduto).build();
    }
    
    @DELETE
    @Path("/{produtoID}")
    public void deleteProduto(@PathParam("produtoID") long id){
        servicoProduto.removeProduto(id);
    }
}
