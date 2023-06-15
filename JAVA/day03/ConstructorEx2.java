package day03;
class Emp5{
    static int cnt; //총사원수
    Emp5() {
        cnt=cnt+1;
        System.out.println("Emp()");
    }
    Emp5(int i) {
        this();//생성자가 생성자 호출. 매개인자 있는 생성자 호출시 괄호안에 매개인자 입력
        //반드시 첫 문장에 있어야 함.
        System.out.println("Emp(int i)");
    }
    Emp5(int i, int j) {
        this(1);//매개인자 있는 생성자 호출
        System.out.println("Emp(int i, int j)");
    }
}
public class ConstructorEx2 {
    public static void main(String[] args) {
        Emp5 emp = new Emp5(5,6);
    }
}
