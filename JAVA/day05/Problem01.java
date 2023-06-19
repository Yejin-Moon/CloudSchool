package day05;
import java.util.Scanner;
public class Problem01 {
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.next();  
        
        int len = str.length();
        char prevc = 'a';
        int cnt=0;
        for(int i=0; i<len; i++){
            char ch = str.charAt(i);
            if(prevc!=ch) {
                if(cnt>1) System.out.print(cnt);
                System.out.print(ch);
                cnt=1;
                prevc=ch;
            }
            else {
                cnt++;
            }
            if(i==len-1 && cnt>1) System.out.print(cnt);
        }
    }
}
