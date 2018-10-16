package logic.time;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class AppliedDateDifference implements DateDifference {
	protected LocalDate start;
	protected LocalDate end = null;
	
	public long getDays() {
		LocalDate end = this.end == null ? LocalDate.now() : this.end;
		return ChronoUnit.DAYS.between(this.start, end);
	}
	
	public long getMonths() {
		LocalDate end = this.end == null ? LocalDate.now() : this.end;
		return ChronoUnit.MONTHS.between(this.start, end);
	}
	
	public long getYears() {
		LocalDate end = this.end == null ? LocalDate.now() : this.end;
		return ChronoUnit.YEARS.between(this.start, end);
	}
	
	
}
