package pro.buildmysoftware.orderpreparation.model.order;

import pro.buildmysoftware.common.domain.DomainEventPublisher;

public class OrderFactory {

	private DomainEventPublisher domainEventPublisher;
	private MaxTotalCostPolicy maxTotalCostPolicy;
	private OrderRepository repository;

	public OrderFactory(DomainEventPublisher domainEventPublisher,
			    MaxTotalCostPolicy maxTotalCostPolicy) {
		this.domainEventPublisher = domainEventPublisher;
		this.maxTotalCostPolicy = maxTotalCostPolicy;
	}

	public Order createEmptyOrder(Employee employee,
				      OrderSpecification specification) {
		if (specificationIsAcceptable(specification)) {
			var order = Order.create(maxTotalCostPolicy
				.forEmployee(employee), specification);
			repository.save(order);
			domainEventPublisher
				.publish(new OrderCreated(order.id()));
		}
		throw new SpecificationIsUnacceptable("specification " +
			"unnaceptable");
	}

	private boolean specificationIsAcceptable(OrderSpecification specification) {
		// TODO: imagine as many business as you might want, for
		//  example we might want to accept specifications containing
		//  at least one kind of product (e.g. hardware)
		return false;
	}
}
