package quaternarycalculator.bsu.edu.backend;

import java.util.ArrayList;

public class Operator {
    Converter converter = new Converter();

    public String setOperation(String opSymbol, ArrayList<String> arrayList){
        if (arrayList.size() == 1) {
            return this.doSqrOperation(opSymbol,arrayList.get(0));
        }else{
            return this.doOperation(opSymbol,arrayList.get(0), arrayList.get(1));
        }
    }

    public String doOperation(String operationSymbol, String value1, String value2) {
        return switch (operationSymbol) {
            case "+" -> add(value1, value2);
            case "-" -> subtract(value1, value2);
            case "*" -> multiply(value1, value2);
            case "/" -> divide(value1, value2);
            default -> throw new IllegalArgumentException("Unexpected Operation: " + operationSymbol);
        };
    }

    public String doSqrOperation(String operationSymbol, String value1){
        return switch (operationSymbol) {
            case "x²" -> sqr(value1);
            case "√" -> sqrt(value1);
            default -> throw new IllegalArgumentException("Unexpected Operation: " + operationSymbol);
        };
    }

    private String add(String addend1, String addend2) {
        int a1 = converter.convertToDecimal(addend1);
        int a2 = converter.convertToDecimal(addend2);
        int sum = a1 + a2;
        return converter.convertToQuaternary(sum);
    }

    private String subtract(String minuend, String subtrahend) {
        int min = converter.convertToDecimal(minuend);
        int sub = converter.convertToDecimal(subtrahend);
        int diff = min - sub;
        return converter.convertToQuaternary(diff);
    }

    private String multiply(String factor1, String factor2) {
        int f1 = converter.convertToDecimal(factor1);
        int f2 = converter.convertToDecimal(factor2);
        int prod = f1 * f2;
        return converter.convertToQuaternary(prod);
    }

    private String divide(String dividend, String divisor) {
        int dend = converter.convertToDecimal(dividend);
        int sor = converter.convertToDecimal(divisor);
        int quot = dend / sor;
        return converter.convertToQuaternary(quot);
    }

    private String sqr(String root) {
        int droot = converter.convertToDecimal(root);
        int dsquare = droot * droot;
        return converter.convertToQuaternary(dsquare);
    }

    private String sqrt(String square) {
        int dsquare = converter.convertToDecimal(square);
        double dsqrt = Math.sqrt(dsquare);
        int roundedsqrt = (int)Math.round(dsqrt);
        return converter.convertToQuaternary(roundedsqrt);
    }
}
