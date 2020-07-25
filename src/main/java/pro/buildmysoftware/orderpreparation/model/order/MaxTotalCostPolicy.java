package pro.buildmysoftware.orderpreparation.model.order;

import org.joda.money.Money;

public interface MaxTotalCostPolicy {

	Money forEmployee(Employee employee);
}
