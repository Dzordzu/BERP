package logic.math;

/**
 * Representation of the Percentage math term
 */

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

    /**
     * @return percentage String in the form 'value%'
     */
    @Override
    public String toString() {
        return getPercentage() + "%";
    }
}
