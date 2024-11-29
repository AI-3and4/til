import java.util.*;

class Solution {
    public static int solution(int[][] jobs) {

        //1. 첫번 째 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] <= o2[0] ? -1 : 1;
            }
        });

        //2. 두번 째 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1 : 1;
            }
        });

        int time = 0;
        int totalWaitTime = 0;
        int index = 0; 
        int count = jobs.length;

        while (index < count || !queue.isEmpty()) {
            while (index < count && jobs[index][0] <= time) {
                queue.add(jobs[index]);
                index++;
            }

            if (!queue.isEmpty()) {
                int[] job = queue.poll();
                time += job[1];
                totalWaitTime += time - job[0];
            } else {
                time = jobs[index][0];
            }
        }

        return totalWaitTime / count;
    }
}