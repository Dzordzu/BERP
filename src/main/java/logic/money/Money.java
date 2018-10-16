package logic.money;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class Money {
	private double amount;
	@Getter private Currency currency;

	private static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

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
		return round(this.amount, currency.getDefaultFractionDigits());
	}

	@Override
	public String toString() {
		return getAmount() + currency.getCurrencyCode();
	}
}
