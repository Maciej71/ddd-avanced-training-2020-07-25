package pro.buildmysoftware.orderaccounting;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static pro.buildmysoftware.orderpreparation.TestFixtures.usd;

class PrepareInvoiceForClientTest {

	// @formatter:off
	@DisplayName(
		"cannot prepare invoice for non-existent order"
	)
	//@formatter:on
	@Test
	void prepareInvoice() throws Exception {
		// given
		var invoiceCreator = invoiceCreator();
		var orderId = nonExistentOrder();

		// when
		var exception = catchThrowableOfType(() -> invoiceCreator
			.invoiceFor(orderId, anyClient()),
			CannotPrepareInvoiceForNonPlacedOrder.class);

		// then
		assertThat(exception).isNotNull();
	}

	// @formatter:off
	@DisplayName(
		"given placed order with total cost of 100 PLN, " +
		"when prepare invoice for client from Poland, " +
		"then gross value on invoice is 123 PLN"
	)
	//@formatter:on
	@Test
	void prepareInvoiceForClientFromPoland() throws Exception {
		// given
		var placedOrders = placedOrders();
		var placedOrder = orderOfTotalCost(pln(100));
		placedOrders.add(placedOrder);
		var invoiceCreator = invoiceCreator(placedOrders);
		var orderId = placedOrder.id();
		var client = clientFromPoland();

		// when
		var invoice = invoiceCreator.invoiceFor(orderId, client);

		// then
		assertThat(invoice.gross()).isEqualTo(pln(123));
	}

	// @formatter:off
	@DisplayName(
		"given placed order with total cost of 100 USD, " +
		"when prepare invoice for client from US, " +
		"then gross value on invoice is 100 USD"
	)
	//@formatter:on
	@Test
	void prepareInvoiceForClientFromUS() throws Exception {
		// given
		var placedOrders = placedOrders();
		var placedOrder = orderOfTotalCost(usd(100));
		placedOrders.add(placedOrder);
		var invoiceCreator = invoiceCreator(placedOrders);
		var orderId = placedOrder.id();
		var client = clientFromUS();

		// when
		var invoice = invoiceCreator.invoiceFor(orderId, client);

		// then
		assertThat(invoice.gross()).isEqualTo(usd(100));
	}

	private Client clientFromUS() {
		return new Client(Country.US, CompanyType.OTHER);
	}

	private Client anyClient() {
		return clientFromUS();
	}

	private Client clientFromPoland() {
		return new Client(Country.POLAND, CompanyType.OTHER);
	}

	private OrderId nonExistentOrder() {
		return new OrderId(UUID.randomUUID().toString());
	}

	private InvoiceCreator invoiceCreator() {
		return new InvoiceCreator(new InMemoryOrderDao(),
			new TaxingPolicies(Set
			.of(new PolandTaxPolicy())));
	}

	private Money pln(double amount) {
		return Money.of(CurrencyUnit.of("PLN"), amount);
	}

	private OrderDao placedOrders() {
		return new InMemoryOrderDao();
	}

	private Order orderOfTotalCost(Money amount) {
		return new Order(amount);
	}

	private OrderId anyOrderId() {
		return new OrderId(UUID.randomUUID().toString());
	}

	private InvoiceCreator invoiceCreator(OrderDao orderDao) {
		return new InvoiceCreator(orderDao, new TaxingPolicies(Set
			.of(new PolandTaxPolicy())));
	}
}
