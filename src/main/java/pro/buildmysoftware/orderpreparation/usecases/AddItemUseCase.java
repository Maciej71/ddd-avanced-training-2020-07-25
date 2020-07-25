package pro.buildmysoftware.orderpreparation.usecases;

import lombok.NonNull;
import pro.buildmysoftware.orderpreparation.model.order.Item;
import pro.buildmysoftware.orderpreparation.model.order.Order;
import pro.buildmysoftware.orderpreparation.model.order.OrderId;

public class AddItemUseCase {

	private CommandInvoker<Order, OrderId> commandInvoker;

	public AddItemUseCase(@NonNull CommandInvoker<Order, OrderId> commandInvoker) {
		this.commandInvoker = commandInvoker;
	}

	public void addItem(@NonNull OrderId orderId, @NonNull Item item) {
		commandInvoker.invoke(order -> order.add(item), orderId);
	}
}
