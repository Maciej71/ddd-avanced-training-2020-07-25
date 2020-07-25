package pro.buildmysoftware.common.domain;

import java.util.Optional;

public interface AggregateRepository<A extends AggregateRoot<ID>, ID> {

	Optional<A> findBy(ID id);

	void save(A aggregate);
}
