package pro.buildmysoftware.orderpreparation.model.order;

public class MaxTotalCostExceededException extends RuntimeException {

	public MaxTotalCostExceededException(String message) {
		super(message);
	}

	public MaxTotalCostExceededException(String message, Throwable cause) {
		super(message, cause);
	}
}
