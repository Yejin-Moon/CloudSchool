package day04;
/*
 * 인터페이스
 * (public 키워드를 생략해도 자동 public)
 * 모든 메소드는 public abstract 메소드
 * 인터페이스 안에는
 * public abstract 메소드들과, public static final .. 상수들로 구성됨.
 * 다중 상속 가능. 
 * 명명 규칙 : 대문자로 시작, 명사 또는 형용사
 */

interface Drawable{
    void draw();//자동으로 public abstract가 붙음
    public abstract void move(int x, int y); //이렇게 명시해도 안해도 상관x

    int PLAIN_PEN = 1; //자동으로 public static final 붙음
    public static final int BOLD_PEN = 2;
}

interface Drawable3D extends Drawable{
    //인터페이스가 인터페이스 상속할때는 extends 사용
}

interface AA{};
class BB{};
abstract class Shape1 implements Drawable{
    //인터페이스 상속받을 땐 implements 사용
}

abstract class Shape2 implements Drawable,AA{}//Shape가 AA와 Drawable 둘다 상속
abstract class Shape extends BB implements Drawable,AA{}//일반 클래스도 상속
//--> 다중상속 가능

class Circle extends Shape{
    public void draw() {System.out.println("원 그림");};
    public void move(int i, int j) {}
}

public class Interface {
    void 그림판(Drawable d){
        d.draw();
    }
}
