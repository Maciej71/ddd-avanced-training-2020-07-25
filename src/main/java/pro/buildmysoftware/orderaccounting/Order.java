package pro.buildmysoftware.orderaccounting;

import lombok.Value;
import org.joda.money.Money;

import java.util.UUID;

@Value
public class Order {

	private final Money totalCost;
	private final OrderId id;

	public Order(Money amount) {
		totalCost = amount;
		id = new OrderId(UUID.randomUUID().toString());
	}

	public OrderId id() {
		return id;
	}

	public Money totalCost() {
		return totalCost;
	}
}
