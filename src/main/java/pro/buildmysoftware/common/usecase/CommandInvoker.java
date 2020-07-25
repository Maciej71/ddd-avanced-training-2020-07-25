package pro.buildmysoftware.common.usecase;

import pro.buildmysoftware.common.domain.AggregateRepository;
import pro.buildmysoftware.common.domain.AggregateRoot;
import pro.buildmysoftware.common.domain.DomainEvent;
import pro.buildmysoftware.common.domain.DomainEventPublisher;

import java.util.function.Function;

public class CommandInvoker<A extends AggregateRoot<ID>, ID> {

	private AggregateRepository<A, ID> aggregateRepository;
	private DomainEventPublisher domainEventPublisher;

	public CommandInvoker(AggregateRepository<A, ID> aggregateRepository,
			      DomainEventPublisher domainEventPublisher) {
		this.aggregateRepository = aggregateRepository;
		this.domainEventPublisher = domainEventPublisher;
	}

	public void invoke(Function<A, ? extends DomainEvent> consumer,
			   ID id) {
		aggregateRepository.findBy(id).ifPresent(aggregate -> {
			DomainEvent event = consumer.apply(aggregate);
			aggregateRepository.save(aggregate);
			domainEventPublisher.publish(event);
		});
	}
}
