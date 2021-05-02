import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack <Integer> st = new Stack<>();
        st.push(0);
        
        for(int move : moves){
            for(int j=0; j < board.length; j++){
                if(board[j][move-1] !=0){
                    if(st.peek() == board[j][move-1]){
                        st.pop();
                        answer +=2;
                    }else{
                        st.push(board[j][move-1]);
                    }
                    board[j][move-1]=0;
                    break;
                }
            }
        }
        return answer;
    }
}
