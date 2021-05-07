#include <set>
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        set<char> sets;
        int ans=0;
        
        for(int i=0; i<s.size(); i++){
            int tmp=0;
            sets.clear();
            for(int j=i; j<s.size(); j++){
                char c=s[j];
                if(sets.find(c)==sets.end()){
                    sets.insert(c);
                    tmp++;
                }else{
                    ans=max(ans,tmp);
                    break;
                }
            }
            ans=max(ans,tmp);
        }
        return ans;
    }
};