import java.io.*;
import java.util.*;

public class Main{

    private static int[] parent = new int[100000];
    private static boolean[] visited = new boolean[100000];
    private static ArrayList<Integer>[] graph = new ArrayList[100000];

    private static int findRoot(int x){
        if(parent[x] != x){
            parent[x] = findRoot(parent[x]);
        }
        return parent[x];
    }

    private static void union(int a, int b){
        a = findRoot(a);
        b = findRoot(b);

        if(a<b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    private static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();

        visited[x] = true;
        queue.add(x);

        int cur;
        while (!queue.isEmpty()) { 
            cur = queue.poll();
            for(Integer i : graph[cur]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]); // 정점 수
        int M = Integer.parseInt(inputs[1]); // 간선들
        int K = Integer.parseInt(inputs[2]); // 새 간선 가격

        // 부모 초기화
        for(int i=0; i<N; i++){
            parent[i] = i;
            graph[i] = new ArrayList<>();
        }

        ArrayList<Integer[]> edges = new ArrayList<>();

        int a,b,c;
        for(int i=0; i<M; i++){
            inputs = br.readLine().split(" ");
            a = Integer.parseInt(inputs[0])-1;
            b = Integer.parseInt(inputs[1])-1;
            c = Integer.parseInt(inputs[2]);

            graph[a].add(b);
            graph[b].add(a);

            edges.add(new Integer[]{c,a,b});
        }
        
        edges.sort(Comparator.comparingInt(arr -> arr[0]));

        long result = 0;
        int cost;
        for (Integer[] i : edges){
            cost = Math.min(i[0], K);
            a = i[1];
            b = i[2];

            if(findRoot(a) != findRoot(b)){
                result += cost;
                union(a, b);
            }
        }

        // 이제 연결 안된 애들은 어쩐담.
        // 모든 정점 들러가며 탐색해서 덩어리 봐야하나
        // => 그럼 N번 씀.
        // 이후 각 덩어리에서 vertex 한개씩 내놓기.
        // 얘네들 끼리는 무조건 k로 잇기. 다해서 2N 정도 걸릴듯.

        ArrayList<Integer> regions = new ArrayList<>();
        
        // 덩어리
        for (Integer[] i : edges){
            a = i[1];
            if(!visited[a]){
                bfs(a);
                regions.add(a);
            }
        }

        // 외딴섬
        for (int i=0; i<N; i++){
            if(!visited[i]){
                regions.add(i);
            }
        }

        // 각 덩어리 끼리 결합
        int regionSize = regions.size();
        for (int i =1; i<regionSize; i++) {
            result += K;
            union(i, i-1);
        }

        System.out.print(result);
    }
}