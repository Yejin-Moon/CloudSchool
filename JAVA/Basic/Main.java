// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static class EmbeddedClass {
        String name;
        String email;

        public void printembedded() {
            System.out.println(name);
            System.out.println(email);
        }
    }

    public static void main(String[] args) {

        Info Info = new Info("yejin","ide",25);
        Info.printInfo();

        InfoNoConstructor noConstructor = new InfoNoConstructor();
        noConstructor.printInfo();

        EmbeddedClass embeddedClass = new EmbeddedClass();
        embeddedClass.printembedded();

        Car c1 = new Car();
        c1.speed=10;
        c1.name="mycar";
        System.out.println(c1.name);


        Car c2 = new Car(20,"hyundai");
        c2.speed=50;
        System.out.println(c2.speed);

        Calculator cal = new Calculator();
        int res = cal.sum1(1,2,3,4,5,6,7,8,9,10);
        System.out.println(res);
    }

}
