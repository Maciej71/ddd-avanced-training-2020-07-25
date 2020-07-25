package pro.buildmysoftware.orderpreparation.infrastructure;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class OrderData {

	@Id
	@GeneratedValue
	UUID orderId;
	String currency;
	double totalCost;
	@OneToMany
	List<ItemData> items;
}
