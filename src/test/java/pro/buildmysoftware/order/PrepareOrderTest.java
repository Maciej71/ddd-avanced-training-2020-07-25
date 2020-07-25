package pro.buildmysoftware.order;

import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PrepareOrderTest {

	// @formatter:off
	@DisplayName(
		"can prepare order"
	)
	//@formatter:on
	@Test
	void prepareOrder() throws Exception {
		// when
		Order order = Order.create(usd(100));

		// then
		assertThat(order).isNotNull();
	}

	// @formatter:off
	@DisplayName(
		"given max $100 order total cost, " +
		"when add item of value $20 to the order, " +
		"then item is successfully added to the order"
	)
	//@formatter:on
	@Test
	void addElementSuccessfully() throws Exception {
		// given
		var order = Order.create(usd(100));
		var item = itemOfPrice(usd(20));

		// when
		order.add(item);

		// then
		assertThat(order.getItems()).containsOnly(item);
		assertThat(order.totalCost()).isEqualTo(usd(20));
	}

	// @formatter:off
	@DisplayName(
		"given order with max total cost $100, " +
		"when add item of price $20 and then another item of price $81, " +
		"then the last item cannot be added"
	)
	//@formatter:on
	@Test
	void addItemUnsuccessful() throws Exception {
		// given
		var order = Order.create(usd(100));

		// when
		order.add(itemOfPrice(usd(20)));
		var exceptionWhenAddingLastItem =
			catchThrowableOfType(() -> order
			.add(itemOfPrice(usd(81))),
				MaxTotalCostExceededException.class);

		// then
		assertThat(exceptionWhenAddingLastItem).isNotNull()
			.hasMessage("Max total cost exceeded: 101.0");
	}

	// @formatter:off
	@DisplayName(
		"given order with max total cost $100, " +
		"when add item of price $101 using getItems method, " +
		"then item cannot be added"
	)
	//@formatter:on
	@Test
	void cannotModifyItemsDirectly() throws Exception {
		// given
		Order order = Order.create(usd(100));

		// when
		var exception = catchThrowable(() -> order.getItems()
			.add(itemOfPrice(usd(101))));

		// then
		assertThat(exception).isNotNull();
		assertThat(order.totalCost()).isEqualTo(usd(0));
	}

	private Item itemOfPrice(Money price) {
		return TestFixtures.itemOfPrice(price);
	}

	private Money usd(double amount) {
		return TestFixtures.usd(amount);
	}
}
