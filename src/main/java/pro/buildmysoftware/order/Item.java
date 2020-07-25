package pro.buildmysoftware.order;

import lombok.NonNull;
import lombok.Value;
import org.joda.money.Money;

@Value
public class Item {

	Money price;

	public Item(@NonNull Money price) throws ItemPriceCannotBeNegativeException {
		if (price.isNegative()) {
			throw new ItemPriceCannotBeNegativeException("Items " + "cannot have negative price");
		}
		this.price = price;
	}
}
