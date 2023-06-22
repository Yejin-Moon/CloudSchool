package Algorithm;

import java.util.Scanner;

public class fibo {
    static int arr_td[] = new int[101010];
    public static int fibo_TopDown(int n){
        if(n==0) return 0;
        if(n<=2) return 1;
        int res = arr_td[n];
        return res = fibo_TopDown(n-1)+fibo_TopDown(n-2);
    }

    public static int fibo_BottomUp(int n){
        int arr_bu[] = new int[101010];
        arr_bu[0] = 0; arr_bu[1] = 1; arr_bu[2]=1;
        for(int i=2; i<=n; i++){
            arr_bu[i]=arr_bu[i-1]+arr_bu[i-2];
        }
        return arr_bu[n];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 : ");
        int n = sc.nextInt();
        System.out.println("하향식 피보나치 결과 : "+fibo_TopDown(n));
        System.out.println("상향식 피보나치 결과 : "+fibo_BottomUp(n));
    }
}
