import java.util.*;
import java.io.*;

public class Main{
    static int [][] arr;
    static int N;
    static StringBuilder temp;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        temp =new StringBuilder(); 
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j < N; j++){
                arr[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }
        
        QuadTree(0,0,N);
        System.out.println(temp.toString());
    }
    public static boolean isAble(int row, int col, int size){
        int t = arr[row][col];
        
        for(int i=row; i < row+size; i++){
            for(int j=col; j < col+size; j++){
                if(t!= arr[i][j]) return false;
            }
        }
        return true;
    }
    
    public static void QuadTree(int row, int col, int size){
        if(isAble(row,col,size)){
            temp.append(arr[row][col]);
        }else{
            temp.append("(");
            
            int newsize = size/2;
            
            QuadTree(row,col,newsize);
            QuadTree(row,col+newsize,newsize);
            QuadTree(row + newsize,col,newsize);
            QuadTree(row+newsize,col+newsize,newsize);
            
            temp.append(")");
        }
    }
}
