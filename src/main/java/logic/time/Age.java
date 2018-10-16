package logic.time;

import java.time.LocalDate;

/**
 * Each instance of this object is immutable. Represents difference between birthday and now or birthday and death date.
 */

public class Age extends AppliedDateDifference {
	
	/*
	 * AppliedDateDifference of the birth
	 */
	
	public LocalDate getBirthDate() {
		return start;
	}
	public Age(final LocalDate start) {
		this.start = start;
	}
	public Age(final String start) {
		this.start = LocalDate.parse(start);
	}
	
	/*
	 * AppliedDateDifference of the death
	 */
	public LocalDate getDeathDate() {
		return end;
	}
	public Age setDeathDate(final LocalDate end) {
		this.end = end;
		return this;
	}
	public Age setDeathDate(final String end) {
		this.end = LocalDate.parse(end);
		return this;
	}
	public boolean isAlreadyDead() {
		return this.end != null;
	}
}
