package pro.buildmysoftware.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static pro.buildmysoftware.order.TestFixtures.itemOfPrice;

class ItemInvariantsTest {

	// @formatter:off
	@DisplayName(
		"cannot add items with negative values"
	)
	//@formatter:on
	@Test
	void cannotAddItemsWithNegativeValues() throws Exception {
		// when
		var exception =
			catchThrowableOfType(() -> itemOfPrice(TestFixtures
			.usd(-1)), ItemPriceCannotBeNegativeException.class);

		// then
		assertThat(exception).isNotNull();
	}
}
