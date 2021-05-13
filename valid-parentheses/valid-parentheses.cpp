#include <stack>
class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(char c: s){
            if(st.empty() && (c=='}' || c==']' || c==')')) return false;
            if(c=='{' || c=='[' || c=='(')st.push(c);
            else{
                if(c=='}'){
                    if(!st.empty() && st.top()=='{') st.pop();
                    else return false;
                }
                else if(c==')'){
                    if(!st.empty() && st.top()=='(') st.pop();
                    else return false;
                }else if(c==']') {
                     if(!st.empty() && st.top()=='[') st.pop();
                    else return false;
                }
            }
        }
        if(st.empty()) return true;
        return false;
    }
};