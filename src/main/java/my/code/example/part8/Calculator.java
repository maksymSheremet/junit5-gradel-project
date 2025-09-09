package my.code.example.part8;

public class Calculator {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Дільник не може бути нулем.");
        }
        return dividend / divisor;
    }
}
