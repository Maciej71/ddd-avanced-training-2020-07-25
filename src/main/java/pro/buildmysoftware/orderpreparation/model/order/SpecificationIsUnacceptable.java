package pro.buildmysoftware.orderpreparation.model.order;

public class SpecificationIsUnacceptable extends RuntimeException {

	public SpecificationIsUnacceptable(String message) {
		super(message);
	}

	public SpecificationIsUnacceptable(String message, Throwable cause) {
		super(message, cause);
	}
}
