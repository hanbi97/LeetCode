class Solution {
public:
    //sorted arrays!
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(); int n = nums2.size();
        int midIdx=(n+m)/2;
        double ans=0;
        int left=0; int right=0; vector<double> list;
         while(true){
                 if(right>=n){
                    while(list.size()<=midIdx){
                        list.push_back(nums1[left++]);
                    }
                    break;
                }
                if(left>=m){
                     while(list.size()<=midIdx){
                        list.push_back(nums2[right++]);
                    }
                    break;
                }
             
                if(nums1[left]>nums2[right]){
                    list.push_back(nums2[right++]);
                }else{
                    list.push_back(nums1[left++]);
                }
        }
        if((n+m)%2!=0) ans=list[midIdx];
        else ans=(list[midIdx]+list[midIdx-1])/2;
        return ans;
    }
};