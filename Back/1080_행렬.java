import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();//행
        int m = sc.nextInt();//렬
        
        char first [][] = new char[51][51];
        char second [][] = new char[51][51];
        
        for(int i=0; i < n; i++){//행렬 A 입력받기
            String line = sc.next();
            for(int j=0; j < m; j++){
                first[i][j] = line.charAt(j);
            }
        }
        for(int i=0; i < n; i++){//행렬 B 입력받기
            String line = sc.next();
            for(int j=0; j < m; j++){
                second[i][j] = line.charAt(j);
            }
                
        }
        
        int count =0; // 연산횟수
        
        
           for (int i = 0; i < n - 2; i++) {
		      for (int j = 0; j < m - 2; j++) {
			       if (first[i][j] != second[i][j]) {
				       count +=1;
				      for (int a = i; a <= i + 2; a++) {
					     for (int b = j; b <= j + 2; b++) {
					          if(first[a][b] == '0'){
                                 first[a][b] = '1';
                              }else{
                                 first[a][b] = '0';
                              }
					   }
				  }
			   }
		    }
           }
            
            for (int i = 0; i < n; i++) {
		       for (int j = 0; j < m; j++) {
			        if (first[i][j] != second[i][j])
			    	    count = -1;
		        }
	        }
        
        
	    
        System.out.println(count);
    }
}
