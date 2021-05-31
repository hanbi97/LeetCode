// dp
class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        boolean[] arr = new boolean[length];
        
        if(nums[0]==0 && length>1) return false;
        arr[0]=true;
        for(int i=0; i<length; i++){
            int curr = nums[i];
            if(arr[i]){
                for(int j=1; j<=curr; j++){
                    if(i+j<length)
                        arr[i+j]=true;
                }
            }
        }
        return arr[length-1];
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int idx=0; int n = nums.length;
        for(int reach=0; idx<n && idx<=reach; idx++){
            reach = Math.max(idx+nums[idx], reach);
        }
        return idx==n;
    }
}
