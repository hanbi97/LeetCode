#include <map>
class Solution {
public:
    //완탐..? 매번백트래킹 어케함?
    string maps[10];
    void init(){
        maps[2]="abc";
        maps[3]="def";
        maps[4]="ghi";
        maps[5]="jkl";
        maps[6]="mno";
        maps[7]="pqrs";  
        maps[8]="tuv";
        maps[9]="wxyz";
    }

    vector<string> letterCombinations(string digits) {
        init();
        vector<string> ans;
        vector<vector<string>>tmp(digits.size()); //사이즈초기화 문법 ㅇㅋ
        // init
        if(digits.empty()) return ans;
        int start = digits[0]-'0';
        for(int i=0; i<maps[start].size(); i++){
            string a=""; a+=maps[start][i];
            tmp[0].push_back(a);
        }
        
        for(int i=1; i<digits.size(); i++){//번호
            int curr = digits[i]-'0';
            for(int j=0; j<maps[curr].size(); j++){ //새로운알파벳
                for(int k=0; k<tmp[i-1].size(); k++){ //이전꺼에더함
                    tmp[i].push_back(tmp[i-1][k]+maps[curr][j]);
                }
            }
        }
        ans=tmp[digits.size()-1];
        return ans;
        
    }
};