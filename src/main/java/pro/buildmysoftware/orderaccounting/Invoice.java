package pro.buildmysoftware.orderaccounting;

import lombok.NonNull;
import org.joda.money.Money;

public class Invoice {

	private final Money gross;

	public Invoice(@NonNull Money gross) {
		this.gross = gross;
	}

	public Money gross() {
		return gross;
	}
}
