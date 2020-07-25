package pro.buildmysoftware.orderpreparation;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pro.buildmysoftware.orderpreparation.model.order.Item;

public class TestFixtures {

	public static Item itemOfPrice(Money price) {
		return new Item(price);
	}

	public static Money usd(double amount) {
		return Money.of(CurrencyUnit.USD, amount);
	}
}
