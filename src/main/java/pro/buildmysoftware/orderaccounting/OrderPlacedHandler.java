package pro.buildmysoftware.orderaccounting;

import pro.buildmysoftware.orderpreparation.model.order.OrderPlaced;

public class OrderPlacedHandler {

	private OrderDao orderDao;

	public OrderPlacedHandler(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void handle(OrderPlaced orderPlaced) {
		orderDao.add(translateToOrder());
	}

	private Order translateToOrder() {
		throw new UnsupportedOperationException("implement " +
			"translation");
	}
}
