package pro.buildmysoftware.orderpreparation.model.order;

public interface OrderSpecification {

	boolean isSatisfiedBy(Order order);
}
