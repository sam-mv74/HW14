package Q1;

public class Rational {
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public void setFraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator cant be 0");
        } else if (numerator == 0) {
            this.numerator = 0;
            this.denominator = denominator;
        } else {
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            if (gcd > 1) {
                this.numerator = numerator / gcd;
                this.denominator = denominator / gcd;
            } else {
                this.numerator = numerator;
                this.denominator = denominator;
            }
            if (this.denominator < 0) {
                this.denominator *= -1;
                this.numerator *= -1;
            }
        }
    }

    private int gcd(int numerator, int denominator) {
        int smallNumber;
        if (numerator > denominator)
            smallNumber = denominator;
        else
            smallNumber = numerator;
        for (int i = smallNumber; i > 0; i--) {
            if ((numerator % i == 0) && (denominator % i == 0))
                return i;
        }
        return -1;
    }

    public Rational add(Rational num) {
        Rational result = new Rational();
        int numerator = num.getNumerator() * this.getDenominator() + num.getDenominator() * this.getNumerator();
        int denominator = num.getDenominator() * this.getDenominator();
        result.setFraction(numerator, denominator);
        return result;
    }

    public Rational sub(Rational num) {
        Rational result = new Rational();
        int numerator, denominator;
        if (num.getNumerator() < 0) {
            Rational absNum = new Rational();
            absNum.setFraction(num.getNumerator() * -1, num.getDenominator());
            result = this.add(absNum);
        } else {
            numerator = num.getDenominator() * this.getNumerator() - num.getNumerator() * this.getDenominator();
            denominator = num.getDenominator() * this.getDenominator();
            result.setFraction(numerator, denominator);
        }
        return result;
    }

    public Rational mul(Rational num) {
        Rational result = new Rational();
        int numerator = num.getNumerator() * this.getNumerator();
        int denominator = num.getDenominator() * this.getDenominator();
        result.setFraction(numerator, denominator);
        return result;
    }

    public Rational div(Rational num) {
        Rational result = new Rational();
        int numerator = this.getNumerator() * num.getDenominator();
        int denominator = this.getDenominator() * num.getNumerator();
        result.setFraction(numerator, denominator);
        return result;
    }

    public double toFloatingPoint(Rational num) {
        return (double) num.getNumerator() / num.getDenominator();
    }

    public String toString() {
        if (this.getNumerator() == this.getDenominator()) {
            return "1";
        } else if (this.getNumerator() == -1 * this.getDenominator()) {
            return "-1";
        } else {
            return this.getNumerator() + "/" + this.getDenominator();
        }
    }

    public String toMixedNumber() {
        if (Math.abs(this.numerator) > Math.abs(this.denominator)) {
            int complete = this.getNumerator() / this.getDenominator();
            int numerator = this.numerator - complete * this.denominator;
            return numerator + "/" + this.denominator + "+" + complete;
        } else {
            return this + "+" + 0;
        }
    }
}
