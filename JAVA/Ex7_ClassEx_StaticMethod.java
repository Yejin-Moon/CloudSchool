package JAVA;

class Card {
    String kind;
    int number;
    static int width = 100;
    static int height = 250;

    void instanceMethod() {
        System.out.println(kind +" "+number);
        System.out.println(width +" "+height);
    }
    //static 변수만 사용가능
    //static 변수는 메소드 area에, instance 변수는 heap에 저장되니까
    static void staticMethod() {
        //System.out.println(kind +" "+number); error!
        Card c = new Card(); //이렇게 안에서 객체만들면 접근 가능
        c.kind="king";
        System.out.println(width +" "+height);
    }

    void m1() {
        instanceMethod(); staticMethod(); // 둘다가능
    }

    static void m2() {
        //instanceMethod(); error!
        staticMethod();
    }
}

public class Ex7_ClassEx_StaticMethod {
    static int width;
    static void staticMethod() {} //내 클래스에 있으니까 스태틱이라도 클래스이름. 안붙이고 사용가능
    public static void main(String[] args) {
        Card.width=100; //클래스이름.스태틱변수
        Card.staticMethod(); //클래스이름.스태틱메소드 //카드클래스꺼
        width=200;
        staticMethod();//내꺼
    }   
}
