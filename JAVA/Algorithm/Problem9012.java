package Algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Problem9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String str;
        n = sc.nextInt();

        for(int i=0; i<n; i++) {
            Stack<Integer> stack = new Stack<>();
            boolean flag = false;
            str=sc.next();
            int len = str.length();
            for(int j=0; j<len; j++) {
                if(str.charAt(j)=='('){
                    stack.push(1);
                }
                else 
                {
                    if(stack.empty()) {
                        break;
                    }
                    else stack.pop();
                }
                if(j==len-1) flag=true;
            }
            if(flag && stack.empty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
