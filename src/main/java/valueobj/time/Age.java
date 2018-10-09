package valueobj.time;

import java.time.LocalDate;

public class Age extends Date {
	
	/*
	 * Date of the birth
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
	 * Date of the death
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
