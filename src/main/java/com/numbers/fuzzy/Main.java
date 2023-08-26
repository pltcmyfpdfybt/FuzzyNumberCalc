package main.java.com.numbers.fuzzy;


import main.java.com.numbers.fuzzy.fuzzynumber.FuzzyNumber;

public class Main {
    public static void main(String[] args) {
//        Примеры использования методов
//        FuzzyNumber number1 = new FuzzyNumber(5.0, 4.0, 6.0);
//        FuzzyNumber number2 = new FuzzyNumber(7.0, 6.0, 8.0);
//        FuzzyNumber sum = number1.add(number2);
//        FuzzyNumber difference = number1.subtract(number2);
//        FuzzyNumber product = number1.multiply(number2);
//        FuzzyNumber quotient = number1.divide(number2);
//        System.out.println(number1);
//        System.out.println(number2);
//        System.out.println(sum);
//        System.out.println(difference);
//        System.out.println(product);
//        System.out.println(quotient);

        FuzzyNumber number3 = new FuzzyNumber(20.0, 30.0, 10.0);
        double membershipValue = number3.getMembershipValue(21.0);
        System.out.println(membershipValue);

//        FuzzyNumber number4 = FuzzyNumber.fromMembershipValues(0.7, 4.0, 6.0);
//        System.out.println(number4);

    }
}