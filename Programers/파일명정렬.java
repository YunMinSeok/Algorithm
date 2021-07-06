import java.util.*;
class Solution {
  public String[] solution(String[] files) {

		Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				String h1 = o1.split("[0-9]")[0];
				String h2 = o2.split("[0-9]")[0];
				
				int result = h1.toLowerCase().compareTo(h2.toLowerCase());

				if ( result == 0 ) {					
					result = findNum(o1,h1)-findNum(o2,h2);
				}
				return result;
			}
		});		
		return files;	
  }
    
 private int findNum( String s, String h ) {		
		s = s.replace(h, "");		
		String result ="";		
		for( char c : s.toCharArray()) {
			if( Character.isDigit(c) && result.length() < 5 ) {
				result+=c;
			}else
				break;
		}
		return Integer.valueOf(result);
	}    
}
