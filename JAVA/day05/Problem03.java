package day05;
import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        String str;
        char ch;
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        ch = sc.next().charAt(0);

        int len = str.length();

        int[] arr = new int[101];
        int idx=0;
        for(int i=0; i<len; i++){
            if(str.charAt(i)==ch) {
                arr[idx]=i;
                idx++;
            }
        }
        for(int i=0; i<len; i++) {
            int min=101;
            for(int j=0; j<idx; j++){
                int tmp = Math.abs(arr[j]-i);
                if(tmp<min) min=tmp;
            }
            System.out.print(min+" ");
        }
    }
}
