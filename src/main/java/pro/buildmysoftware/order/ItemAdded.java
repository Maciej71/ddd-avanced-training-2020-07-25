package pro.buildmysoftware.order;

import lombok.NonNull;
import lombok.Value;
import org.joda.money.Money;

import java.util.Collection;

@Value
public class ItemAdded implements DomainEvent {

	@NonNull OrderId order;
	@NonNull Item item;
	@NonNull Collection<Item> allItems;
	@NonNull Money totalCost;
}
