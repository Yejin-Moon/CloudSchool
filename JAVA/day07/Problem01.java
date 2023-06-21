package day07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    public int x,y;

    Point(int x, int y){
        this.x =x;
        this.y= y;
    }
}

public class Problem01 {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int[][] maze, res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        maze = new int[8][8];
        res = new int[8][8];

        for(int i=1; i<8; i++) {
            for(int j=1; j<8; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        
        BFS(1,1);

        if(res[7][7] ==0) System.out.println(-1);
        else System.out.println(res[7][7]);
    }

    static public void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        maze[x][y]=1;

        while(!Q.isEmpty()) {
            Point tmp = Q.poll();
            for(int i=0; i<4; i++) {
                int rx = tmp.x+dx[i];
                int ry = tmp.y+dy[i];

                if(rx>=1 && rx<=7 && ry>=1 && ry <=7 && maze[rx][ry]==0) {
                    maze[rx][ry] = 1;
                    Q.add(new Point(rx,ry));
                    res[rx][ry] = res[tmp.x][tmp.y]+1;
                }
            }
        }
    }
}
