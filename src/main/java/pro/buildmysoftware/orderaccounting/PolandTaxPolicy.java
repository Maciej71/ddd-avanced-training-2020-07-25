package pro.buildmysoftware.orderaccounting;

public class PolandTaxPolicy implements TaxPolicy {

	@Override
	public Tax taxFor(Client client) {
		return new Tax("VAT", 1.23);
	}

	@Override
	public boolean isApplicableFor(Client client) {
		return client.isFrom(Country.POLAND);
	}
}
