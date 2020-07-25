package pro.buildmysoftware.orderpreparation.model.order;

import lombok.NonNull;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pro.buildmysoftware.common.domain.AggregateRoot;
import pro.buildmysoftware.common.domain.Version;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class Order implements AggregateRoot<OrderId> {

	private Collection<Item> items;
	private Money maxTotalCost;
	private OrderId id;

	private Order(Money maxTotalCost) {
		this.maxTotalCost = maxTotalCost;
		items = new HashSet<>();
		id = new OrderId(UUID.randomUUID().toString());
	}

	public static Order create(@NonNull Money maxTotalCost) throws MaxTotalCostCannotBeNegativeException {
		if (maxTotalCost.isNegative()) {
			throw new MaxTotalCostExceededException("Max total " + "cost cannot be negative");
		}
		return new Order(maxTotalCost);
	}

	public OrderPlaced place() {
		throw new UnsupportedOperationException("Implement this " +
			"method");
	}

	/**
	 * Adds an item to this order.
	 *
	 * @param item
	 * @return
	 * @throws MaxTotalCostExceededException if business invariant
	 *                                       regarding max total cost is
	 *                                       violated
	 */
	public ItemAdded add(@NonNull Item item) throws MaxTotalCostExceededException {
		var newTotalCost = totalCost().plus(item.getPrice());
		if (newTotalCost.isGreaterThan(maxTotalCost)) {
			throw new MaxTotalCostExceededException(String
				.format("Max total cost exceeded: %s",
					newTotalCost
					.getAmount().doubleValue()));
		}
		items.add(item);
		return new ItemAdded(id, item, List.copyOf(items),
			totalCost());
	}

	public Money totalCost() {
		return items.stream().map(Item::getPrice).reduce(Money::plus)
			.orElse(Money.zero(CurrencyUnit.USD));
	}

	@Override
	public OrderId id() {
		return id;
	}

	@Override
	public Version version() {
		return null;
	}
}
