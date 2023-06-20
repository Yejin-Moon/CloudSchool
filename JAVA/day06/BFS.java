package day06;

import java.util.Queue;
import java.util.LinkedList;

public class BFS {
    
    public static void main(String[] args) {
        boolean visit[] = new boolean[8];

        LinkedList<Integer>[] arr = new LinkedList[8];
        for(int i=0; i<=7; i++) {
            arr[i]=new LinkedList<Integer>();
        }
        // 1과 2 연결
        arr[1].add(2) ;
        arr[2].add(1) ;
        // 1과 3 연결
        arr[1].add(3) ;
        arr[3].add(1) ;
        // 2와 3연결
        arr[2].add(3) ;
        arr[3].add(2) ;
        // 2와 4연결
        arr[2].add(4) ;
        arr[4].add(2) ;
        // 2와 5연결
        arr[2].add(5) ;
        arr[5].add(2) ;
        // 3와 6연결
        arr[3].add(6) ;
        arr[6].add(3) ;
        // 3와 7연결
        arr[3].add(7) ;
        arr[7].add(3) ;
        // 4와 5연결
        arr[4].add(5) ;
        arr[5].add(4) ;
        // 6와 7연결
        arr[6].add(7) ;
        arr[7].add(6) ;

        bfs(1,arr,visit);
    }

    public static void bfs(int v, LinkedList<Integer>[] arr, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true; 
		queue.add(v);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp +" ");

            for(int nv : arr[tmp]) {
                if(!visited[nv]) {
                    queue.add(nv);
                    visited[nv]= true;
                }
            }
        }
	}
}