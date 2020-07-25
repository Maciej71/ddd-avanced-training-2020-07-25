package pro.buildmysoftware.orderaccounting;

import java.util.Optional;

public interface OrderDao {

	void add(Order order);

	Optional<Order> orderBy(OrderId orderId);
}
