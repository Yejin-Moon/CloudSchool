package day05;

import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        int len = str.length();

        for(int i=0; i<len; i++){
            char ch = str.charAt(i);
            if(ch>='0' && ch<='9') System.out.print(ch);
        }
    }
}
