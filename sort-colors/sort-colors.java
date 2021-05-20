class Solution {
    //red white blue
    //inplace quicksort, selection sort
    private void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;
    }
    
    private void inPlacePartition(int[] arr, int left, int right){
        if(left>=right) return;
        int pivot = left;
        int l = left; int r = right;
        while(l<r){
            while(arr[l]<arr[pivot]) l++;
            while(arr[r]>arr[pivot]) r--;
            if(l<=r){
                swap(arr,l,r);
                l++; r--;
            }
        }
        if(left<r) inPlacePartition(arr,left,r);
        if(l<right) inPlacePartition(arr,l,right);
    }
   
    public void sortColors(int[] nums) {
        //가운데 pivot으로 잡음
        inPlacePartition(nums,0, nums.length-1);
    }
}
//2 0 2 1 1 0
//left right pivot:2
//0 2 2 1 1 0