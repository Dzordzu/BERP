package logic.valueobj.money;

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
	private double amount;
	private Currency currency;

	public Money(long amount, Currency currency) {
		this.amount = (double)amount;
		this.currency = currency;
	}
	public Money(long amount, String currencyCode) {
		this.amount = (double)amount;
		this.currency = Currency.getInstance(currencyCode);
	}


	public Money(double amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
	public Money(double amount, String currencyCode) {
		this.amount = amount;
		this.currency = Currency.getInstance(currencyCode);
	}

	public double getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}
	

}
