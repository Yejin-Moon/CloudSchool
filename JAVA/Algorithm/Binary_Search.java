package Algorithm;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Binary_Search {

    public static int bs(Vector<Integer> seq, int data){
        int l=0, r= seq.size()-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(seq.get(mid)==data) return mid;
            else if(seq.get(mid)<data) l = mid+1;
            else r=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자들을 입력하세요(입력을 끝내려면 -1을 입력하세요)");
        while(true) {
            int n=sc.nextInt();
            if(n==-1) break;
            v.add(n);
        }
        System.out.print("찾고자 하는 수를 입력하세요 : ");
        int target = sc.nextInt();
        Collections.sort(v);
        int res = bs(v,target);
        if(res==-1) System.out.println("찾고자 하는 숫자가 없습니다.");
        else System.out.println("해당 숫자는 "+res+"번째 인덱스에 있습니다.");
    }
}
