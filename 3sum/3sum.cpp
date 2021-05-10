#include <algorithm>
#include <set>
class Solution {
public:
    //중복체크 때문에...ㅠㅠ
    //+,- 나눠서 정렬후계산 -> X
    //i 정하고 j,k 포인터써서 구하기
       
    
    vector<vector<int>> threeSum(vector<int>& nums) {        
        vector<vector<int>>res;
        sort(nums.begin(), nums.end());      
        int n = nums.size();
        if(n < 3) return res;
        for(int i=0; i<n-2; i++){
            if(i == 0 || (i>0 && nums[i] != nums[i-1] )){ //이전에 했던거 안넣으려고
            int first = nums[i];
            int j=i+1, k=n-1;
            
            while(j<k){
                if(first+nums[j]+nums[k]==0){
                    res.push_back({first,nums[j],nums[k]});
                    while(j<k && nums[j]==nums[j+1]) j++; //중복제거
                    while(j<k && nums[k]==nums[k-1]) k--; //중복제거
                    j++; k--;
                }
                else if(nums[j]+nums[k]+first>0)k--;
                else j++;
            }
            }
        }
        return res;
    }
};