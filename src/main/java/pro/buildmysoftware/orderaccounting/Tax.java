package pro.buildmysoftware.orderaccounting;

import lombok.Value;

@Value
public class Tax {

	String taxType;
	double taxAsPercentage;
}
