package br.com.geracaoelias.ekklesia_server.resource.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DebugExceptionMapper implements ExceptionMapper<Exception>
{

    @Override
    public Response toResponse(Exception exception)
    {
        exception.printStackTrace();
        return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}
