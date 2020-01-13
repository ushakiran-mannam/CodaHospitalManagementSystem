package global.coda.hospitalmanagement.exceptionMapper;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import global.coda.hospitalmanagement.exception.BusinessException;

// TODO: Auto-generated Javadoc
/**
 * The Class BusinessExceptionMapper.
 */
@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

	/**
	 * To response.
	 *
	 * @param exception the exception
	 * @return the response
	 */
	@Override
	@Produces(MediaType.APPLICATION_JSON)
	public Response toResponse(BusinessException exception) {
		return Response.status(400).entity("Invalid Input").build();
	}

}
