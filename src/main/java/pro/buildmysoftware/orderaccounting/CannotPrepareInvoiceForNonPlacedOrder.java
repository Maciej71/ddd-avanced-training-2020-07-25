package pro.buildmysoftware.orderaccounting;

public class CannotPrepareInvoiceForNonPlacedOrder extends RuntimeException {

	public CannotPrepareInvoiceForNonPlacedOrder(String message) {
		super(message);
	}

	public CannotPrepareInvoiceForNonPlacedOrder(String message,
						     Throwable cause) {
		super(message, cause);
	}
}
