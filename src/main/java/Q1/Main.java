package Q1;

public class Main {
    public static void main(String[] args) {
        Rational rational1 = new Rational();
        rational1.setFraction(2, 4);

        Rational rational2 = new Rational();
        rational2.setFraction(6, 9);

        //add
        Rational addResult = rational1.add(rational2);
        System.out.println("(" + rational1 + ")+(" + rational2 + ") = " + addResult.toString());

        //sub
        Rational subResult = rational1.sub(rational2);
        System.out.println("(" + rational1 + ")-(" + rational2 + ") = " + subResult.toString());
        //mul
        Rational mulResult = rational1.mul(rational2);
        System.out.println("(" + rational1 + ")*(" + rational2 + ") = " + mulResult.toString());

        //div
        Rational divResult = rational1.div(rational2);
        System.out.println("(" + rational1 + ")/(" + rational2 + ") = " + divResult.toString());

        //toFloatingPoint
        double floatingPoint = rational1.toFloatingPoint(rational1);
        System.out.println("(" + rational1 + ") to floating point = " + floatingPoint);

        //toMixedNumber
        String mixedNumber = rational1.toMixedNumber();
        System.out.println("(" + rational1 + ") to mixed number = " + mixedNumber);
    }
}
