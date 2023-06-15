package day03;

class Animal{
    void move() {System.out.println("동물움직임");}
}

class Lion extends Animal{
    void move() {System.out.println("사자움직임");}
    void aaa() {};
}

public class ObjectCasting {
    public static void main(String[] args) {
        Animal a = new Lion(); //Lion is a animal. upcasting 자동으로 됨
        //Lion one = new Animal(); //downcasting. 묵시적으로 안 됨
        Lion one = (Lion)(new Animal()); //downcasting 명시적으로 해주면 컴파일 가능. 실행시오류남
        Lion[] lions = new Lion[10]; //lion2 객체 담을 수 있음. 사자담는 배열
        Animal[] animals = new Animal[10]; //animal 객체 담을 수 있음. 사자도 고양이도 담는 배열
        animals[0] = new Lion();
    }

    static void treat(Animal a) {
        a.move();
        if(a instanceof Lion){//downcasting이 가능한지 확인
            Lion obj = (Lion)a;
            obj.aaa();
        }
    }
}
