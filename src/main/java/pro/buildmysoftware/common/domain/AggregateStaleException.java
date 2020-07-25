package pro.buildmysoftware.common.domain;

public class AggregateStaleException extends RuntimeException {

	public AggregateStaleException(String message) {
		super(message);
	}

	public AggregateStaleException(String message, Throwable cause) {
		super(message, cause);
	}
}
