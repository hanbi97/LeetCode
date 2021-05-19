import java.util.*;

class Solution {
    private int[] dx = {0,0,1,-1,1,-1,1,-1};
    private int[] dy = {1,-1,1,-1,-1,1,0,0};
    private boolean isInside(int y, int x, int n, int m){
        if(x>=0 && x<m && y>=0 && y<n) return true;
        return false;
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> q = new LinkedList<>();

        q.offer(click);

        while(!q.isEmpty()){
            int[] curr = q.peek(); q.poll();            
            int y = curr[0]; int x= curr[1];
           // System.out.println("curr: "+ y+" "+x);
            if(board[y][x]=='M'){
                board[y][x]='X';
                break;
            }else if(board[y][x]=='E'){
                //8방향 지뢰 있는지 먼저 체크
                int cnt=0;
                for(int d=0; d<8; d++){
                    int[] next = new int[2];
                    next[0] = y+dy[d]; next[1] = x+dx[d];
                    if(isInside(next[0],next[1],n,m)){
                        if(board[next[0]][next[1]]=='M'){
                            cnt++;
                        }
                    }
                }
                if(cnt!=0){//지뢰 있으면 넣으면 X
                    board[y][x]= (char) (cnt+'0');
                }else{
                    for(int d=0; d<8; d++){
                        int[] next = new int[2];
                        next[0] = y+dy[d]; next[1] = x+dx[d];
                     //    System.out.println("next: "+ next[0] +" "+ next[1]);
                        if(isInside(next[0],next[1],n,m) && board[next[0]][next[1]]=='E'){
                                q.offer(next);                            
                        }
                    }
                    board[y][x] = 'B';
                   // System.out.print(y+" "+x);
                }
            }
        }
        return board;
    }
}
//M지뢰 E 빈공간 B 8방향주위에 지뢰 없음
//숫자 8방향 주변에 지뢰있음
//X 지뢰
//클릭: M이나E 누름

// M이 나타나면 게임끝, 지뢰가 발견되면 X가 된다
// 빈공간 E주변에 지뢰가 없으면 E는 B로 바귄다, 주변에 지뢰없을때까지 B 계속 나옴
// E 주변에 지뢰 있으면 숫자로 변함
// 더이상 남은자리 없으면 보드 리턴

//큐: push 아니고 offer, empty()아니고 isEmpty()