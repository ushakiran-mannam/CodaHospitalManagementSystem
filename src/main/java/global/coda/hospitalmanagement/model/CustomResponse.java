package global.coda.hospitalmanagement.model;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomResponse.
 *
 * @param <T> the generic type
 */
public class CustomResponse<T> {
	
	/** The status. */
	private int status;
	
	/** The data. */
	private T data;

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
}