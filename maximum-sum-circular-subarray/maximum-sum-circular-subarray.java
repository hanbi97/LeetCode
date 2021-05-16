//일일이 구하면 time limit
//주변에 마이너스 있으면 더할 필요 없음 이 아니라 그 다음 수가 큰 양수면 더할수도 있음..
//dp인가
// O(N) 풀이가 있었다..!
// 배열은 [maxSum일부 + subarray + maxSum 일부] 로 이루어짐
// 답은 max(maxSum, total-subarray)이고 배열 전부가 음수이면 currMax -> maxSum이 답이됨

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
       for(int a: nums){
            curMax = Math.max(curMax+a,a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin+a, a);
            minSum = Math.min(minSum, curMin);
            total+=a;
       }
        return maxSum>0? Math.max(maxSum, total-minSum):maxSum;
    }
}