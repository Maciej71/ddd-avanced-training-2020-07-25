package pro.buildmysoftware.common.domain;

public interface DomainEventPublisher {

	void publish(DomainEvent event);
}
