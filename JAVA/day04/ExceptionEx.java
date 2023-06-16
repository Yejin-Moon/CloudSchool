package day04;
/*
 * 프로그래밍의 오류의 종류
 * 1. 컴파일 오류(문법 오류)
 * 2. 런타임 오류
   (실행 오류. 실행시 발생되는 오류. 문법 오류가 아니라 컴파일시엔 알 수 없음)
     ex) 메모리 부족, file not found
     1) 심각한 실행 오류 - ex) 메모리부족
     2) 가벼운 실행 오류(Exception) - ex) file not found
 * 3. 논리 오류(아예 개발을 잘못함) - 테스트 케이스로 테스트해서 해결
 */

 /*
  * 자바는 exception이 발생하면 exception 객체를 생성해서 실행환경으로 넘겨줌
    예외처리가 안되어 있으면(넘겨준거안받으면) 에러메시지 화면에 출력하고 프로그램 수행 중지.
    예외처리가 되어 있으면 그 구문을 수행. 프로그램 종료되지 않음.
  */

  /*
   * 예외처리 방법
   * 1) try catch finally
   * 2) thorws
   */
public class ExceptionEx {
    public static void main(String[] args) {
        int i=0;
        String str=null;
        //int result = 10/i; //컴파일러는 값은 안보니까 컴파일은 되지만 실행오류남
                            //0으로 나눌 수 없어서 ArithmeticException 발생
        try { //try 블럭 안에서 예외 발생하면 catch 수행
            //int result = 10/i;
            str.substring(1);//str이 널이라 널포인트 exception 발생
        }catch(ArithmeticException e) { 
              System.out.println("aaaaa");
              //ArithmeticException 이 발생 했을 때만 실행
        }catch(NullPointerException e) { 
            System.out.println("bbb");
            //NullPointerException 이 발생 했을 때만 실행
        }catch(Exception e) {//모든 Exception의 부모는 Exception
                            //Exception 클래스는 모든 자바 예외의 최상위클래스
            System.out.println(e.getMessage());
        }finally{//try block 끝나면 실행
            System.out.println("항상 실행");
        }
        System.out.println( "정상 종료");
    }
}

