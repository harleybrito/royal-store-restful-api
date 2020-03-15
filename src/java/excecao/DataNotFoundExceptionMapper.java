package excecao;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import modelo.MensagemDeErro;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

    @Override
    public Response toResponse(DataNotFoundException exception) {
        MensagemDeErro errorMessage = new MensagemDeErro(exception.getMessage(), 404, "http://javabrains.koushik.org");
        return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
    }
    
}
