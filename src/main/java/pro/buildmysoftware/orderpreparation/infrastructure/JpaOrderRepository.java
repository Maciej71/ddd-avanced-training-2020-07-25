package pro.buildmysoftware.orderpreparation.infrastructure;

import pro.buildmysoftware.common.domain.AggregateStaleException;
import pro.buildmysoftware.orderpreparation.model.order.Order;
import pro.buildmysoftware.orderpreparation.model.order.OrderId;
import pro.buildmysoftware.orderpreparation.model.order.OrderRepository;

import java.util.Optional;

public class JpaOrderRepository implements OrderRepository {

	private SpringJpaOrderRepository jpaOrderRepository;

	@Override
	public Optional<Order> findBy(OrderId orderId) {
		return jpaOrderRepository.findById()
			.map(this::mapToDomainOrder);
	}

	@Override
	public void save(Order aggregate) throws AggregateStaleException {
		jpaOrderRepository.save(mapToDataOrder(aggregate));
	}

	private OrderData mapToDataOrder(Order aggregate) {
		return null;
	}

	private Order mapToDomainOrder(OrderData orderData) {
		return null;
	}
}
