package logic.valueobj.money;

import lombok.Getter;

import java.util.Currency;

public class Money {
	@Getter private double amount;
	@Getter private Currency currency;

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
	

}
