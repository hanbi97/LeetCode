class Solution {
public:
    int romanToInt(string s) {
        string tmp="";
        int res=0; int i=0;
        for(; i<s.size()-1; i++){
            char c1 = s[i], c2=s[i+1];
            if(c1=='I' &&c2=='V'){
                    tmp+='A'; i++;
            }
            else if(c1=='I'&& c2=='X') {
                    tmp+='B'; i++;
            }
            else if(c1=='X'&&c2=='L'){               
                    tmp+='E'; i++;
            }
            else if(c1=='X'&&c2=='C') {
                    tmp+='F'; i++;
            }
            else if(c1=='C'&&c2=='D'){               
                    tmp+='G'; i++;
            }
            else if(c1=='C'&& c2=='M') {
                    tmp+='H'; i++;
            }
            else{
                tmp+=s[i];
            }
        }
        if(i ==s.size()-1) tmp+=s[s.size()-1];
        
        for(char c: tmp){
            if(c=='I') res+=1;
            else if(c=='V') res+=5;
            else if(c=='X') res+=10;
            else if(c=='L') res+=50;
            else if(c=='C') res+=100;
            else if(c=='D') res+=500;
            else if(c=='M') res+=1000;
            else if(c=='A') res+=4;
            else if(c=='B') res+=9;
            else if(c=='E')res+=40;
            else if(c=='F')res+=90;
            else if(c=='G')res+=400;
            else if(c=='H')res+=900;
        }
        return res;
    }
};