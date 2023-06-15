package day02;

class Calculator {
    double result=0;

    void addMethod(double num) {
        result= result+num;
    }

    void subMethod(double num) {
        result= result-num;
    }

    void mulMethod(double num) {
        result = result*num;
    }

    void divMethod(double num) {
        result= result/num;
    }

    void init() {
        result = 0;
    }
}

class CalculatorTest {
    public static void main(String[] args) {
        Calculator cal1 = new Calculator();
        Calculator cal2 = new Calculator();
        cal1.result=50;
        cal1.mulMethod(5.2);
        cal1.divMethod(10);
        cal1.addMethod(1000);
        System.out.println(cal1.result);

        cal2.result=90;
        cal2.mulMethod(1000);
        cal2.divMethod(30);
        cal2.subMethod(10);
        System.out.println(cal2.result);
    }
}
