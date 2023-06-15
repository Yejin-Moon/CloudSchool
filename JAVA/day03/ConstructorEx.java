package day03;

/*
 * 
 * 생성자 : 객체 생성 시 자동 호출되는 특수한 메소드.
            객체 생성이 되자 마자 해야할일 구현하면 됨
            만들고 한번만 호출됨
 * 생성자 작성 방법
  1) 클래스 이름과 같은 이름
  2) 반환형 안씀

  생성자가 없으면? 자동으로 생성자 생김
 */

class Emp{
    Emp() {
        System.out.println("생성자");
    } //생성자

    void Emp() {} //메소드
}

class Emp2{
    //생성자가 없으면 자동으로 기본생성자가 생성됨
    //아무일도 안하는 기본 생성자 생김
    Emp2() {} //기본생성자
}

class Emp3{ //생성자도 매개인자 받을 수 o
    int id;
    Emp3(int id) {
        this.id = id;
    }
}
//매개인자 갯수, 타입이 다르면 여러 생성자 작성 가능.
//생성자 다중정의 overloading
class Emp4{
    int id;
    Emp4() {
        System.out.println("기본생성자");
    }
    Emp4(int i) {
        this.id=i;
        System.out.println("emp4(int id) id = "+this.id);
    }
}

public class ConstructorEx {
    public static void main(String[] args) {
        Emp one = new Emp();
        Emp3 three = new Emp3(3); //객체 생성시 매개인자 넘겨준다
        //Emp3 three2 = new Emp3(); //매개인자 없이 만들면 기본(무인자)생성자 호출한다는 것
        //생성자 하나라도 있으면 기본생성자 자동 생성되지 않음.
        System.out.println(three.id);

        Emp4 a = new Emp4();
        Emp4 b = new Emp4(4);
    }
}
