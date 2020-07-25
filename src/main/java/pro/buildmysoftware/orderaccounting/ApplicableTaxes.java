package pro.buildmysoftware.orderaccounting;

import java.util.Set;

public class ApplicableTaxes {

	private Set<Tax> taxes;

	public ApplicableTaxes(Set<Tax> taxes) {
		this.taxes = Set.copyOf(taxes);
	}

	public Set<Tax> getTaxes() {
		return Set.copyOf(taxes);
	}
}
