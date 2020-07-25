package pro.buildmysoftware.orderpreparation.model.order;

import lombok.NonNull;
import lombok.Value;
import pro.buildmysoftware.common.domain.DomainEvent;

@Value
public class OrderCreated implements DomainEvent {

	@NonNull OrderId id;
}
