package pro.buildmysoftware.orderpreparation.model.order;

public class OrderDoesntExistException extends RuntimeException {

	public OrderDoesntExistException(String message) {
		super(message);
	}

	public OrderDoesntExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
