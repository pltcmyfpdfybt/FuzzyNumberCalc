package main.java.com.numbers.fuzzy.fuzzynumber;

public class FuzzyNumber {

    //x, a, b - три поля, которые соответствуют основному, нижнему и верхнему значениям нечеткого числа соответственно.
    private double x;
    private double a;
    private double b;

    public FuzzyNumber() {
    }
    public FuzzyNumber(double x, double a, double b) {
        this.x = x;
        this.a = a;
        this.b = b;
    }

    public double getX() {
        return x;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    //Операции над нечеткими числами реализованы методами add, subtract, multiply и divide.
    //Они возвращают новое нечеткое число, полученное в результате выполнения соответствующей операции над двумя нечеткими числами.
    public FuzzyNumber add(FuzzyNumber other) {
        //return new FuzzyNumber(x + other.getX(), a + other.getA(), b + other.getB());
        double x = this.x + other.x;
        double a = this.a + other.a;
        double b = this.b + other.b;
        return new FuzzyNumber(x, a, b);
    }

    public FuzzyNumber subtract(FuzzyNumber other) {
        double x = this.x - other.x;
        double a = this.a - other.a;
        double b = this.b - other.b;
        return new FuzzyNumber(x, a, b);
    }

    public FuzzyNumber multiply(FuzzyNumber other) {
        double x = this.x * other.x;
        double a = Math.min(Math.min(this.x * other.a, this.a * other.x), this.a * other.a);
        double b = Math.max(Math.max(this.x * other.b, this.b * other.x), this.b * other.b);
        return new FuzzyNumber(x, a, b);
    }

    public FuzzyNumber divide(FuzzyNumber other) {
        double x = this.x / other.x;
        double a = Math.min(Math.min(this.x / other.a, this.a / other.x), this.a / other.a);
        double b = Math.max(Math.max(this.x / other.b, this.b / other.x), this.b / other.b);
        return new FuzzyNumber(x, a, b);
    }

    //Метод getMembershipValue позволяет вычислить степень принадлежности заданного значения нечеткому числу.
    public double getMembershipValue(double value) {
        if (a <= value && value <= b) {
            return 1.0;
        } else if (value < a) {
            return (value - a) / (x - a);
        } else {
            return (b - value) / (b - x);
        }
    }

    //Метод fromMembershipValues создает новый объект класса FuzzyNumber,
    // определяя нижнюю и верхнюю границы на основе заданных степеней принадлежности и центрального значения x.
    public static FuzzyNumber fromMembershipValues(double x, double a, double b) {
        double mid = (a + b) / 2.0;
        double lower = mid - (mid - a) * (1.0 - x);
        double upper = mid + (b - mid) * (1.0 - x);
        return new FuzzyNumber(x, lower, upper);
    }

    //Метод toString -  позволяет получить строковое представление нечеткого числа.
    public String toString() {
        return "(" + x + ", " + a + ", " + b + ")";
    }
}
