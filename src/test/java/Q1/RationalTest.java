package Q1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RationalTest {
    Rational rational1;
    Rational rational2;

    @BeforeEach
    void init() {
        rational1 = new Rational();
        rational2 = new Rational();
    }

    @Test
    void setFractionWithZeroDenominator() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> rational1.setFraction(1, 0));
        assertEquals("denominator cant be 0", exception.getMessage());
    }

    @Test
    void setFraction() {
        rational1.setFraction(2, 4);
        assertEquals(1, rational1.getNumerator());
        assertEquals(2, rational1.getDenominator());
    }

    @Test
    void add() {
        rational1.setFraction(2, 4);
        rational2.setFraction(6, 9);
        assertEquals(7, rational1.add(rational2).getNumerator());
        assertEquals(6, rational1.add(rational2).getDenominator());
    }

    @Test
    void sub() {
        rational1.setFraction(1, 2);
        rational2.setFraction(2, 4);
        assertEquals(0, rational1.sub(rational2).getNumerator());
        assertEquals(4, rational1.sub(rational2).getDenominator());
    }

    @Test
    void mul() {
        rational1.setFraction(2, 4);
        rational2.setFraction(6, 9);
        assertEquals(1, rational1.mul(rational2).getNumerator());
        assertEquals(3, rational1.mul(rational2).getDenominator());
    }

    @Test
    void div() {
        rational1.setFraction(2, 4);
        rational2.setFraction(6, 9);
        assertEquals(3, rational1.div(rational2).getNumerator());
        assertEquals(4, rational1.div(rational2).getDenominator());
    }

    @Test
    void toFloatingPoint() {
        rational1.setFraction(1, 2);
        assertEquals(0.5, rational1.toFloatingPoint(rational1));
    }
}