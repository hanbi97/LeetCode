#include <cstring>
class Solution {
public:
    string longestPalindrome(string s) {
        int dp[1001][1001];
        memset(dp,0,sizeof(dp));
        string ans="";
        int n = s.size();
        for(int i=0; i<n; i++){
            dp[i][i]=1;
        }
        for(int i=0; i<n-1; i++){
            if(s[i]==s[i+1])
                dp[i][i+1]=1;
        }
        
        /*
        dp[i][j]가 팰린드롬인지 확인
        ex) 팰린드롬 길이 3짜리 체크할때
        dp[i][i+2]가 팰린드롬인지 확인해야함
        1. s[i]==s[i+2], dp[i+1][i+1]==1
        ex) 팰린드롬 길이 4짜리 체크할때
        dp[i][i+3]이 팰린드롬인지 확인해야함
        1. s[i]==s[i+3], dp[i+1][i+2]==1
        ....
        팰린드롬 최대 길이 = 기존 스트링 길이
        */
        for(int len=2; len<n; len++){
            for(int i=0; i<n-len+1; i++){
                if(s[i]==s[i+len]){
                    if(dp[i+1][i+len-1]==1){
                        dp[i][i+len]=1;
                    }
                }
            }
        }
       
        //스트링찾기: 한 행에서 1이 시작되고 끝나는곳을 찾으면 됨
        for(int i=0; i<n; i++){
            string res="";
            int startIdx=0; int endIdx=0;
            for(int j=0; j<n; j++){
                if(dp[i][j]==1){
                    startIdx=j; break;
                }
            }
            for(int j=n-1; j>=0; j--){
                if(dp[i][j]==1){
                    endIdx=j; break;
                }
            }
            res = s.substr(startIdx,endIdx-startIdx+1);
            if(res.size()>ans.size()){
                ans=res;
            }
        }
        return ans;
    }
};