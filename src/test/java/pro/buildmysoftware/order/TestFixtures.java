package pro.buildmysoftware.order;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class TestFixtures {

	public static Item itemOfPrice(Money price) {
		return new Item(price);
	}

	public static Money usd(double amount) {
		return Money.of(CurrencyUnit.USD, amount);
	}
}
