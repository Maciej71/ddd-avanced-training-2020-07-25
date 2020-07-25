package pro.buildmysoftware.order;

public class MaxTotalCostCannotBeNegativeException extends RuntimeException {

	public MaxTotalCostCannotBeNegativeException(String message) {
		super(message);
	}

	public MaxTotalCostCannotBeNegativeException(String message,
						     Throwable cause) {
		super(message, cause);
	}
}
