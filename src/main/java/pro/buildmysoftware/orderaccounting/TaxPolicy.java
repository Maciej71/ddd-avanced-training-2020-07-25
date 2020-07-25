package pro.buildmysoftware.orderaccounting;

public interface TaxPolicy {

	Tax taxFor(Client client);

	boolean isApplicableFor(Client client);
}
