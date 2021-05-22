#include <cstring>
class Solution {
public:
    bool visited[10];
    int n;
    vector<vector<int>> result;
    void dfs(int cnt, int target, int idx, vector<int>& nums){
        if(cnt==target){
            vector<int> tmp;
            for(int i=0; i<n; i++){
                if(visited[i]){
                    tmp.push_back(nums[i]);
                }
            }
            result.push_back(tmp);
            return;
        }
        for(int i=idx; i<n; i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(cnt+1, target, i+1, nums);
                visited[i]=false;
            }
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        n = nums.size();
        for(int i=0; i<=n; i++){
            memset(visited,false,sizeof(visited));
            dfs(0,i,0, nums);
        }
        return result;
    }
};