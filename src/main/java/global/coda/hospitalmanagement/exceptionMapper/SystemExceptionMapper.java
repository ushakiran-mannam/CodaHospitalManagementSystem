package global.coda.hospitalmanagement.exceptionMapper;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import global.coda.hospitalmanagement.exception.SystemException;

// TODO: Auto-generated Javadoc
/**
 * The Class SystemExceptionMapper.
 *
 * @author VC
 */
public class SystemExceptionMapper implements ExceptionMapper<SystemException> {

	/**
	 * To response.
	 *
	 * @param exception the exception
	 * @return the response
	 */
	@Override
	@Produces(MediaType.APPLICATION_JSON)
	public Response toResponse(SystemException exception) {
		return Response.status(400).entity("Something Went Wrong").build();
	}

}