package pro.buildmysoftware.order;

import lombok.NonNull;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Order {

	private Collection<Item> items;
	private Money maxTotalCost;

	private Order(Money maxTotalCost) {
		this.maxTotalCost = maxTotalCost;
		items = new HashSet<>();
	}

	public static Order create(@NonNull Money maxTotalCost) throws MaxTotalCostCannotBeNegativeException {
		if (maxTotalCost.isNegative()) {
			throw new MaxTotalCostExceededException("Max total " + "cost cannot be negative");
		}
		return new Order(maxTotalCost);
	}

	/**
	 * Adds an item to this order.
	 *
	 * @param item
	 * @throws MaxTotalCostExceededException if business invariant
	 *                                       regarding max total cost is
	 *                                       violated
	 */
	public void add(@NonNull Item item) throws MaxTotalCostExceededException {
		var newTotalCost = totalCost().plus(item.getPrice());
		if (newTotalCost.isGreaterThan(maxTotalCost)) {
			throw new MaxTotalCostExceededException(String
				.format("Max total cost exceeded: %s",
					newTotalCost
					.getAmount().doubleValue()));
		}
		items.add(item);
	}

	public Collection<Item> getItems() {
		return List.copyOf(items);
	}

	public Money totalCost() {
		return items.stream().map(Item::getPrice).reduce(Money::plus)
			.orElse(Money.zero(CurrencyUnit.USD));
	}
}
