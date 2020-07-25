package pro.buildmysoftware.order;

public class ItemPriceCannotBeNegativeException extends RuntimeException {

	public ItemPriceCannotBeNegativeException(String message) {
		super(message);
	}

	public ItemPriceCannotBeNegativeException(String message,
						  Throwable cause) {
		super(message, cause);
	}
}
