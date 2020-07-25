package pro.buildmysoftware.orderaccounting;

import java.util.Set;
import java.util.stream.Collectors;

public class TaxingPolicies {

	private Set<TaxPolicy> policies;

	public TaxingPolicies(Set<TaxPolicy> policies) {
		this.policies = policies;
	}

	public ApplicableTaxes applicableTaxes(Client client) {
		var allTaxes = policies.stream()
			.filter(taxPolicy -> taxPolicy.isApplicableFor(client))
			.map(taxPolicy -> taxPolicy.taxFor(client))
			.collect(Collectors.toUnmodifiableSet());
		return new ApplicableTaxes(allTaxes);
	}
}
