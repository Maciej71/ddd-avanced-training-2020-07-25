package pro.buildmysoftware.orderaccounting;

import lombok.NonNull;
import lombok.Value;

@Value
public class Client {

	@NonNull Country country;

	public boolean isFrom(@NonNull Country country) {
		return this.country.equals(country);
	}
}
