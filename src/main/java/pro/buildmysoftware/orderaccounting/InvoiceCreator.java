package pro.buildmysoftware.orderaccounting;

import pro.buildmysoftware.common.domain.DomainService;

import java.math.RoundingMode;

public class InvoiceCreator implements DomainService {

	private OrderDao orderDao;
	private TaxingPolicies taxingPolicies;

	public InvoiceCreator(OrderDao orderDao,
			      TaxingPolicies taxingPolicies) {
		this.orderDao = orderDao;
		this.taxingPolicies = taxingPolicies;
	}

	public Invoice invoiceFor(OrderId orderId, Client client) {
		return orderDao.orderBy(orderId)
			.map(placedOrder -> new Invoice(placedOrder.totalCost()
				.multipliedBy(chooseTaxValueFor(client),
					RoundingMode.HALF_UP)))
			.orElseThrow(() -> new CannotPrepareInvoiceForNonPlacedOrder("Order is not placed, so we cannot prepare an invoice for it"));
	}

	private double chooseTaxValueFor(Client client) {
		return taxingPolicies.applicableTaxes(client).getTaxes()
			.stream().mapToDouble(Tax::getTaxAsPercentage).max()
			.orElse(1.00);
	}
}
