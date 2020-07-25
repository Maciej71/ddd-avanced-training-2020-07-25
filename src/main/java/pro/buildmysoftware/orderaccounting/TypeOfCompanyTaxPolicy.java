package pro.buildmysoftware.orderaccounting;

public class TypeOfCompanyTaxPolicy implements TaxPolicy {

	@Override
	public Tax taxFor(Client client) {
		return new Tax("IT", 1.08);
	}

	@Override
	public boolean isApplicableFor(Client client) {
		return client.getCompany().equals(CompanyType.IT);
	}
}
