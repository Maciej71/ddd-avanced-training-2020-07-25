package pro.buildmysoftware.orderpreparation.infrastructure;

import java.util.Optional;

public interface SpringJpaOrderRepository {

	Optional<OrderData> findById();

	void save(OrderData mapToDataOrder);
}
