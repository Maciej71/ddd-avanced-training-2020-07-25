package pro.buildmysoftware.orderaccounting;

import pro.buildmysoftware.common.domain.DomainService;

import java.math.RoundingMode;

public class InvoiceCreator implements DomainService {

	private OrderDao orderDao;

	public InvoiceCreator(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public Invoice invoiceFor(OrderId orderId, Client client) {
		return orderDao.orderBy(orderId)
			.map(placedOrder -> new Invoice(placedOrder.totalCost()
				.multipliedBy(chooseTaxValueFor(client),
					RoundingMode.HALF_UP)))
			.orElseThrow(() -> new CannotPrepareInvoiceForNonPlacedOrder("Order is not placed, so we cannot prepare an invoice for it"));
	}

	private double chooseTaxValueFor(Client client) {
		if (client.isFrom(Country.POLAND)) {
			return 1.23;
		}
		else {
			return 1.00;
		}
	}
}
