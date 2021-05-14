class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int []dp = new int[n+1]; //선언시 자동 0 초기화
        
        for(int i=0; i<n-1; i++){
            int from = i+1;
            int go = nums[i];
            for(int j=1; j<=go; j++){
                int to = from+j;               
                if(to>n) break;
                if(dp[to]==0) dp[to]=dp[from]+1;
                else dp[to] = Math.min(dp[to], dp[from]+1);
            }
        }
        
        return dp[n];
    }
}