package Algorithm;

import java.util.Scanner;

public class Problem10828 {
    static int[] arr = new int[10001];
    static int topflag=-1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            String cmd = sc.next();
            if(cmd.equals("push")) {
                int num = sc.nextInt();
                push(num);
            }
            else if(cmd.equals("pop")) sb.append(pop()).append('\n');
            else if(cmd.equals("size")) sb.append(size()).append('\n');
            else if(cmd.equals("empty")) sb.append(empty()).append('\n');
            else sb.append(top()).append('\n');
        }
        System.out.print(sb);
    }

    static public void push(int x) {
        topflag++;
        arr[topflag]=x;
    }

    static public int pop() {
        if(topflag==-1) {
            return -1;
        }
        int tmp = arr[topflag];
        topflag--;
        return tmp;
    }

    static public int size() {
        return topflag+1;
    }

    static public int empty() {
        if(topflag==-1) return 1;
        else return 0;
    }

    static public int top() {
        if(topflag==-1) {
            return -1;
        }
        else return arr[topflag];
    }
}
