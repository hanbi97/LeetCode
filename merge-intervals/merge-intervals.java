/*
merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
겹치는 부분을 다 합치고 겹치지 않는 부분을 리턴해라.

시작점으로 정렬

case1. 연결되는경우
currStart<=end

case2. 연결 안되는 경우
currStart>end
*/
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> answer = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
        
        for(int[] i: intervals){
            pq.offer(i);
        }
        
        int start = pq.peek()[0]; int end = pq.peek()[1];
        pq.remove(); //자바에서는 리무브
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll(); //반환하고 제거
            int currStart = curr[0]; int currEnd = curr[1];
            if(currStart<=end){
                if(currEnd>end){
                    end = currEnd;
                }
            }
            else if(currStart>end){
                int[] a = {start, end};
                answer.add(a);
                start = currStart; end=currEnd;
            }
        }
        int[] a = {start, end};
        answer.add(a);
        return answer.toArray(new int[answer.size()][2]);
    }
}