package valueobj.math;

public class Percentage {
    private double value;

    public double getPercentage() {
        return value * 100;
    }

    public Percentage setPercentage(double value) {
        this.value = value / 100;
        return this;
    }

    public double getFraction() {
        return value;
    }

    public Percentage setFraction(double value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return getPercentage() + "%";
    }
}
