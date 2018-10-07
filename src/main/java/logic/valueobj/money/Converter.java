package logic.valueobj.money;

import java.util.Currency;

public class Converter {
	private Money from;
	private Currency to;
	private Markup markup = null;
	private double marketExchangeRate;
	
	Converter(Money from) {
		this.from = from;
	}
	
//	public Money exchange() {}
	
}
