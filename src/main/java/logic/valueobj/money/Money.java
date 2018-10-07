package logic.valueobj.money;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * @class Money
 * @author dzordzu
 * @category ValueObject
 * 
 * Handles info about currency and its decimal places
 * Additionally handles info about value as string (without deci
 * 
 * @version 1.0.0
 *
 */
public class Money {
	private long ammount;
	
	private Currency currency;
	private short precision;
	// By default scale will be read from the currency field
	private boolean useOwnScale = false;
	private int ownScale; 
	
	Money(String money) {}
	public Money(long ammount, Currency currency) {}
	Money(long ammount, String currencyCode) {}
	
	
	public long getUnscaledAmmount() {
		return ammount;
	}
	public double getAmmount() {
		return BigDecimal.valueOf(ammount)
				.setScale(this.getPrecision(), BigDecimal.ROUND_HALF_DOWN)
				.setScale(this.getScale())
				.doubleValue();

	}

	public Currency getCurrency() {
		return currency;
	}
	public short getPrecision() {
		return precision;
	}
	public void setPrecision(short precision) {
		this.precision = precision;
	}
	public void unsetScale() {
		this.useOwnScale = false;
	}
	public int getScale() {
		if(this.useOwnScale) return ownScale;
		else return currency.getDefaultFractionDigits();
	}
	public void setOwnScale(short ownScale) {
		this.useOwnScale = true;
		this.ownScale = ownScale;
	}
	

}
