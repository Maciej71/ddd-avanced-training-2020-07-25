package pro.buildmysoftware.orderpreparation.infrastructure;

import pro.buildmysoftware.orderpreparation.model.order.Order;
import pro.buildmysoftware.orderpreparation.model.order.OrderId;
import pro.buildmysoftware.orderpreparation.model.order.OrderRepository;

import java.util.Optional;

public class InMemoryOrderRepository implements OrderRepository {

	@Override
	public Optional<Order> findBy(OrderId orderId) {
		return Optional.empty();
	}

	@Override
	public void save(Order aggregate) {

	}
}
