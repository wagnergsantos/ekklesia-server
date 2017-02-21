package br.com.geracaoelias.ekklesia_server.resource.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException>
{

    @Override
    public Response toResponse(RuntimeException exception)
    {
        exception.printStackTrace();
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }

}
